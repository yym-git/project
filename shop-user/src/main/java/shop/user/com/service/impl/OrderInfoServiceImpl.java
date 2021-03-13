package shop.user.com.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shop.user.com.entity.OrderInfo;
import shop.user.com.mappers.OrderInfoMapper;
import shop.user.com.service.OrderInfoService;

/**
 * @author ym.y
 * @description
 * @package shop.user.com.service.impl
 * @updateUser
 * @date 15:10 2021/2/7
 */
@Service
@Slf4j
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public OrderInfo queryByKey(String orderId) {
        log.info("查询订单信息,参数：{}", orderId);
        return orderInfoMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int createOrderInfo(OrderInfo orderInfo) {
        log.info("用户下单，请求参数：{}", JSON.toJSONString(orderInfo));
        int result = orderInfoMapper.insertSelective(orderInfo);
        restTemplate.postForEntity("http://service-product/product/decrease/"+orderInfo.getpId()+"/"+orderInfo.getNumber(),null,null);
        return result;
    }
}
