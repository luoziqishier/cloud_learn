package com.xz.cloud.service.impl;

import com.xz.cloud.apis.AccountFeignApi;
import com.xz.cloud.apis.StorageFeignApi;
import com.xz.cloud.entity.Order;
import com.xz.cloud.mapper.OrderMapper;
import com.xz.cloud.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.persistence.criteria.Root;

/**
 * @author mxz
 * @description 针对表【t_order】的数据库操作Service实现
 * @createDate 2024-09-09 15:41:52
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private AccountFeignApi accountFeignApi;

    @Resource
    private StorageFeignApi storageFeignApi;

    @Resource
    private OrderMapper orderMapper;

    @Override
    @GlobalTransactional(name = "xz-create-order",rollbackFor = Exception.class) //AT
    public void createOrder(Order order) {
        //Xid全局事务id的检查，*****
        String xid = RootContext.getXID();
        //1.新建订单
        log.info("==================>开始新建订单" + "\t" + "xid_order:" + xid);
        //订单状态status-> 0:正在创建,1:创建完成
        order.setStatus(0);
        int result = orderMapper.insertSelective(order);
        Order orderFromDb = null;
        //插入成功后获得mysql对象
        if (result > 0) {
            orderFromDb = orderMapper.selectOne(order);
            log.info("-------> 新建订单成功，orderFromDB info: " + orderFromDb);
            System.out.println();
            //2.扣减库存
            storageFeignApi.decrease(orderFromDb.getProductId(), orderFromDb.getCount());
            log.info("-------> 订单微服务结束调用Storage库存，做扣减完成");
            System.out.println();
            //3. 扣减账号余额
            accountFeignApi.decrease(orderFromDb.getUserId(), orderFromDb.getMoney());
            log.info("-------> 订单微服务结束调用Account账号，做扣减完成");
            System.out.println();
            //4. 修改订单状态
            //订单状态status：0：创建中；1：已完结
            log.info("-------> 修改订单状态");
            orderFromDb.setStatus(1);

            Example whereCondition = new Example(Order.class);
            Example.Criteria criteria = whereCondition.createCriteria();
            criteria.andEqualTo("userId", orderFromDb.getUserId());
            criteria.andEqualTo("status", 0);

            int updateResult = orderMapper.updateByExampleSelective(orderFromDb, whereCondition);

            log.info("-------> 修改订单状态完成" + "\t" + updateResult);
            log.info("-------> orderFromDB info: " + orderFromDb);
        }
        System.out.println();
        log.info("==================>结束新建订单" + "\t" + "xid_order:" + xid);
    }
}





