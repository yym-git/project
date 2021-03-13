package shop.product.com.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.product.com.entity.Product;
import shop.product.com.service.ProductService;

/**
 * @author ym.y
 * @description
 * @package shop.product.com.controller
 * @updateUser
 * @date 15:35 2021/2/7
 */
@Slf4j
@RestController
@RequestMapping(value = "/product", produces = "application/json;charset=utf-8")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/query/{productId}")
    public String queryPrd(@PathVariable("productId") String productId) {
        return JSON.toJSONString(productService.queryInfo(productId));
    }

    @RequestMapping("/route")
    public String test() {
        return "server-product返回的结果";
    }


    /**
     * @description 商品库存减少
     * @author ym.y
     * @updateUser
     * @date 12:59 2021/2/16
     */
    @RequestMapping("/decrease/{productNo}/{num}")
    public void decreaseNum(@PathVariable("productNo") String productNo, @PathVariable("num") Integer num) {
        log.info("下单扣减库存，商品id：{}", productNo);
        int i = 1/0;
        Product product = productService.queryInfo(productNo);
        product.setpStock(product.getpStock() - num);
        int result = productService.updateProductInfo(product);
        log.info("商品库存扣减结果：{}", result);
    }

}
