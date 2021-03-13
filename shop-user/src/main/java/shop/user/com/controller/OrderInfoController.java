package shop.user.com.controller;

import com.alibaba.fastjson.JSON;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import shop.user.com.service.OrderInfoService;
import shop.user.com.entity.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author ym.y
 * @description
 * @package shop.user.com.controller
 * @updateUser
 * @date 15:11 2021/2/7
 */
@Slf4j
@RestController
@RequestMapping(value = "/orderInfo", produces = "application/json;charset=utf-8")
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * @description 查询订单信息
     * @author ym.y
     * @updateUser
     * @date 15:57 2021/2/7
     */
    @RequestMapping("/query/{orderId}")
    public String queryOrderInfo(@PathVariable("orderId") String orderId) {
        return JSON.toJSONString(orderInfoService.queryByKey(orderId));
    }


    /**
     * @description 查询商品信息
     * @author ym.y
     * @updateUser
     * @date 15:57 2021/2/7
     */
    @RequestMapping("/prd")
    public void queryPrd() {

        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//        Product product = restTemplate.getForObject("http://localhost:8008/product/query/1", Product.class);
//
//        int  index  = new Random().nextInt(instances.size());
//        ServiceInstance instance = instances.get(index);
//        String host=instance.getHost();
//        int port = instance.getPort();
//        log.info("主机：{}，端口：{}",host,port);
//        Product product = restTemplate.getForObject("http://"+instance.getHost()+":"+port+"/product/query/1", Product.class);
//        log.info("查询出的商品信息：{}", JSON.toJSONString(product));

//        Ribbon实现负载均衡
        Product product = restTemplate.getForObject("http://service-product/product/query/1", Product.class);
    }

    @RequestMapping("/add")
    @GlobalTransactional
    public void addOrderInfo() {
        log.info("用户下单........");
        OrderInfo orderInfo = new OrderInfo();
        String orderId = UUID.randomUUID().toString().replace("-", "");
        log.info("订单编号：{}", orderId);
        orderInfo.setOrderId(orderId);
        orderInfo.setUserId(1);
        orderInfo.setUserName("张无忌");
        orderInfo.setpId(1);
        orderInfo.setpName("京东E卡100元");
        orderInfo.setpPrice(new BigDecimal("90"));
        orderInfo.setNumber(1);
        int result = orderInfoService.createOrderInfo(orderInfo);
        log.info("用户下单结果：{}", result);
    }
}
