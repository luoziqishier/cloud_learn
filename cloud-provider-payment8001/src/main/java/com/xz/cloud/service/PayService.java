package com.xz.cloud.service;

import com.xz.cloud.entities.Pay;

import java.util.List;


public interface PayService {

    int add(Pay pay);

    int update(Pay pay);

    int delete(Integer id);

    Pay findById(Integer id);

    List<Pay> getAll();
}
