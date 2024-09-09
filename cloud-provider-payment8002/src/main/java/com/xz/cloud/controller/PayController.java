package com.xz.cloud.controller;



import com.xz.cloud.entities.Pay;
import com.xz.cloud.entities.PayDTO;
import com.xz.cloud.resp.ResultData;
import com.xz.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author xz
 * @CreateDate 2024/8/16 18:37
 * <p>
 * description:
 */
@RestController
@Tag(name = "支付微服务模块", description = "支付CRUD")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增", description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay) {
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值：" + 1);
    }

    @DeleteMapping(value = "/pay/del/{id}")
    @Operation(summary = "删除", description = "删除支付流水方法")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
        int delete = payService.delete(id);
        return ResultData.success(delete);
    }

    @PutMapping(value = "/pay/update")
    @Operation(summary = "修改", description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDto) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDto, pay);
        int update = payService.update(pay);
        return ResultData.success("成功修改记录，返回值：" + update);
    }

    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "按照ID查流水", description = "查询支付流水方法")
    public ResultData<Pay> getPay(@PathVariable("id") Integer id) {
            Pay pay = payService.findById(id);
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/getAll")
    @Operation(summary = "查询全部流水", description = "查询支付流水方法")
    public ResultData<List<Pay>> getPayList() {
        List<Pay> payList = payService.getAll();
        return ResultData.success(payList);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/pay/get/info")
    public String getInfo( @Value("${xz.info}") String xzInfo) {
        return "xzInfo:" + xzInfo + ",\nport:" + port;
    }
}
