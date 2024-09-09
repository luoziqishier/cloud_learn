package com.xz.cloud.controller;

import com.xz.cloud.apis.PayFeign;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xz
 * @CreateDate 2024/8/28 16:08
 * <p>
 * description:
 */
@RestController
@Slf4j
public class OrderMicrometerController
{
    @Resource
    private PayFeign payFeignApi;

    @GetMapping(value = "/feign/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id)
    {
        return payFeignApi.myMicrometer(id);
    }
}