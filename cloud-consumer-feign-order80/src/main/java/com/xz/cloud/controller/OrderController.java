package com.xz.cloud.controller;


import cn.hutool.core.date.DateUtil;
import com.xz.cloud.apis.PayFeign;
import com.xz.cloud.entities.PayDTO;
import com.xz.cloud.resp.ResultData;
import com.xz.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @Author xz
 * @CreateDate 2024/8/19 17:17
 * <p>
 * description:
 */
@RestController
public class OrderController {

    @Resource
    private PayFeign payFeignApi;

    @PostMapping("/feign/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO) {
        ResultData resultData = payFeignApi.addPay(payDTO);
        return resultData;
    }

    @GetMapping("/feign/pay/get/{id}")
    public ResultData getPay(@PathVariable("id") Integer id) {
        System.out.println("-------支付微服务远程调用，按照id查询订单支付流水信息");
        ResultData resultData = null;
        try
        {
            System.out.println("调用开始-----:"+ DateUtil.now());
            resultData = payFeignApi.getPayById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("调用结束-----:"+DateUtil.now());
            ResultData.fail(ReturnCodeEnum.RC500.getCode(),e.getMessage());
        }
        return resultData;
    }

    @GetMapping("/feign/pay/mylb")
    public String getInfo(){
        return payFeignApi.getPayInfo();
    }

}
