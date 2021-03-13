package shop.product.com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ym.y
 * @description
 * @package shop.product.com.controller
 * @updateUser
 * @date 22:56 2021/2/15
 */
@Slf4j
@RestController
@RequestMapping(value = "nacos/config", produces = "application/json;charset=utf-8")
public class TestNacosConfig {

    @Value("${test.id}")
    private String id;

    @RequestMapping("/test")
    public void testConfig() {
        log.info("从nacos配置中心读取的值：{}",id);
    }
}
