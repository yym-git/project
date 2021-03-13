package shop.user.com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author ym.y
 * @description
 * @package shop.user.com
 * @updateUser
 * @date 15:03 2021/2/7
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //取消数据源的自动自动装配
//@SpringBootApplication
@MapperScan("shop.user.com.mappers")
public class ShopUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopUserApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
