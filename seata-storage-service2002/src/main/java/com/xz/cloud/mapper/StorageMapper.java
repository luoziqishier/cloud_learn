package com.xz.cloud.mapper;


import com.xz.cloud.entity.Storage;
import tk.mybatis.mapper.common.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author mxz
* @description 针对表【t_storage】的数据库操作Mapper
* @createDate 2024-09-09 15:53:48
* @Entity com.xz.cloud.entity.Storage
*/
public interface StorageMapper  extends Mapper<Storage> {
    /**
     * 扣减库存
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}




