package com.xz.cloud.service;


/**
* @author mxz
* @description 针对表【t_storage】的数据库操作Service
* @createDate 2024-09-09 15:53:48
*/
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
