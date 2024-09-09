package com.xz.cloud.service.impl;

import com.xz.cloud.entities.Pay;
import com.xz.cloud.mapper.PayMapper;
import com.xz.cloud.service.PayService;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xz
 * @CreateDate 2024/8/16 18:30
 * <p>
 * description:
 */
@Service
public class PayServiceImpl implements PayService {

    @Resource
    private PayMapper payMapper;

    @Override
    public int add(Pay pay) {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int update(Pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Pay findById(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll() {
        return payMapper.selectAll();
    }
}
