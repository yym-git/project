package shop.product.com;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ym.y
 * @description
 * @package shop.product.com
 * @updateUser
 * @date 12:25 2021/2/7
 */
@SpringBootApplication
@MapperScan("shop.product.com.mappers")
@EnableDiscoveryClient
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
