package shop.product.com.service;

import shop.product.com.entity.Product;

/**
 * @author ym.y
 * @description
 * @package shop.product.com.service
 * @updateUser
 * @date 15:35 2021/2/7
 */
public interface ProductService {
    Product queryInfo(String productId);

    int  updateProductInfo(Product product);
}
