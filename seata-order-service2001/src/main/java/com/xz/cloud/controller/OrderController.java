package com.xz.cloud.controller;

import com.xz.cloud.entity.Order;
import com.xz.cloud.resp.ResultData;
import com.xz.cloud.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xz
 * @CreateDate 2024/9/9 19:05
 * <p>
 * description:
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/order/create")
    public ResultData createOrder(Order order)
    {
        orderService.createOrder(order);
        return ResultData.success(order);
    }
    @GetMapping("/test")
    public String test(){
        return "abc";
    }
}
