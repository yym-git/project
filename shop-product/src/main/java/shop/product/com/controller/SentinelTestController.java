package shop.product.com.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ym.y
 * @description
 * @package shop.product.com.controller
 * @updateUser
 * @date 20:58 2021/2/7
 */
@Slf4j
@RestController
@RequestMapping("/test/sentinel")
public class SentinelTestController {

    @RequestMapping("/message1")
    @SentinelResource(value = "message1",blockHandler = "handlerMethod1")
    public String test(){
        log.info("测试方法一...................");
        return  "message1";
    }
    @RequestMapping("/message2")
    public String tes2t(){
        log.info("测试方法二...................");
        return  "message2";
    }

    public String handlerMethod1(BlockException e){
        log.info("限流处理...................");
        return  "请求过于频繁，请稍后再试";
    }
}
