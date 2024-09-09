package com.xz.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author xz
 * @CreateDate 2024/8/20 21:53
 * <p>
 * description:
 */
@Configuration
public class FeignConfig {

    @Bean
    public Retryer myRetryer(){
        return Retryer.NEVER_RETRY;
        //return new Retryer.Default(100,1,3);
    }
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
