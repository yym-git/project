package shop.product.com.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.product.com.entity.Product;
import shop.product.com.mappers.ProductMapper;
import shop.product.com.service.ProductService;

/**
 * @author ym.y
 * @description
 * @package shop.product.com.service.impl
 * @updateUser
 * @date 15:36 2021/2/7
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product queryInfo(String productId) {
        log.info("查询商品信息，参数：{}", productId);
        Product product = productMapper.selectByPrimaryKey(Integer.parseInt(productId));
        log.info("商品查询结果：{}", JSON.toJSONString(product));
        return product;
    }

    @Override
    public int updateProductInfo(Product product) {
        log.info("更新商品信息");
        int  result  = productMapper.updateByPrimaryKeySelective(product);
        return result;
    }
}
