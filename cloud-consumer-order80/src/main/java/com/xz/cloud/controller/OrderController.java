package com.xz.cloud.controller;

import com.xz.cloud.entities.PayDTO;
import com.xz.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author xz
 * @CreateDate 2024/8/19 17:17
 * <p>
 * description:
 */
@RestController
public class OrderController {

    //public static final String PaymentSrv_URL = "http://localhost:8001";
    public static final String PaymentSrv_URL = "http://cloud-payment-service";
    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL+"/pay/add" , payDTO, ResultData.class);
    }
    @GetMapping(value = "/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/get/" + id, ResultData.class,id);
    }
    @DeleteMapping(value = "/consumer/pay/del/{id}")
    public ResultData deletePay(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/del/" + id, ResultData.class,id);
    }

    @PutMapping(value = "/consumer/pay/update")
    public ResultData updatePay(@RequestBody PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/update" , payDTO, ResultData.class);
    }
    @GetMapping(value = "/consumer/pay/getAll")
    public ResultData getAllPay(){
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/getAll", ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/get/info")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
    }

    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/consumer/discovery")
    public String discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        System.out.println("===================================");

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }

        return instances.get(0).getServiceId()+":"+instances.get(0).getPort();
    }

}
