package com.gateway.predicates;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author ym.y
 * @description 自定义断言工厂
 * 1、名字必须为 配置参数+RoutePredicateFactory
 * 2、必须继承AbstractRoutePredicateFactory<配置类>
 * @package com.gateway.predicates
 * @updateUser
 * @date 22:19 2021/2/8
 */
@Component
public class AgeRoutePredicateFactory extends AbstractRoutePredicateFactory<AgeRoutePredicateFactory.Config> {

    public AgeRoutePredicateFactory() {
        super(AgeRoutePredicateFactory.Config.class);
    }


    /**
     * @description 读取配置类中的参数值，赋值给配置类属性
     * @author ym.y
     * @updateUser
     * @date 22:30 2021/2/8
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("minAge", "maxAge");
    }


    /**
     * @description 断言逻辑
     * @author ym.y
     * @updateUser
     * @date 22:32 2021/2/8
     */
    @Override
    public Predicate<ServerWebExchange> apply(AgeRoutePredicateFactory.Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                String ageStr = serverWebExchange.getRequest().getQueryParams().getFirst("age");
                if (StringUtils.isNotEmpty(ageStr)) {
                    int age = Integer.parseInt(ageStr);
                    if (age >= config.getMinAge() && age <= config.getMaxAge()) {
                        return true;
                    } else {
                        return false;
                    }
                }
                return false;
            }
        };
    }


    /**
     * 配置类：用于接收配置文件中的参数
     */
    @Data
    @NoArgsConstructor
    public static class Config {

        private int minAge;
        private int maxAge;

    }

}
