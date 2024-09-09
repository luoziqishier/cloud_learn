package com.xz.cloud.apis;

import com.xz.cloud.resp.ResultData;
import com.xz.cloud.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

/**
 * @Author xz
 * @CreateDate 2024/9/7 20:57
 * <p>
 * description:
 */
@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi{
    @Override
    public ResultData getPayByOrderNo(String orderNo) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),"对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}
