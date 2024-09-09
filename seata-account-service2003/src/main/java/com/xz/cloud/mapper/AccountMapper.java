package com.xz.cloud.mapper;


import com.xz.cloud.entity.Account;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
* @author mxz
* @description 针对表【t_account】的数据库操作Mapper
* @createDate 2024-09-09 15:54:53
* @Entity com.xz.cloud.entity.Account
*/
public interface AccountMapper extends Mapper<Account>
{

    /**
     * @param userId
     * @param money 本次消费金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}




