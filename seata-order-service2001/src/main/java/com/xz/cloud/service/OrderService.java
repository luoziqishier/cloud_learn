package com.xz.cloud.service;


import com.xz.cloud.entity.Order;

/**
* @author mxz
* @description 针对表【t_order】的数据库操作Service
* @createDate 2024-09-09 15:41:52
*/
public interface OrderService {

    void createOrder(Order order);
}
