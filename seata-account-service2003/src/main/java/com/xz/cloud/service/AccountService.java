package com.xz.cloud.service;


import org.apache.ibatis.annotations.Param;

/**
* @author mxz
* @description 针对表【t_account】的数据库操作Service
* @createDate 2024-09-09 15:54:53
*/
public interface AccountService {
    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 本次消费金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}
