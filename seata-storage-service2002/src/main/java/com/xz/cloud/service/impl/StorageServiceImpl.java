package com.xz.cloud.service.impl;


import com.xz.cloud.mapper.StorageMapper;
import com.xz.cloud.service.StorageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* @author mxz
* @description 针对表【t_storage】的数据库操作Service实现
* @createDate 2024-09-09 15:53:48
*/
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {


    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId,count);
        log.info("------->storage-service中扣减库存结束");
    }
}




