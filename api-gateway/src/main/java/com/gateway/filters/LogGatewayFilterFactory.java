package com.gateway.filters;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @author ym.y
 * @description 自定义过滤器
 * 1、 过滤器名字 配置+GatewayFilterFactory
 * 2、AbstractGatewayFilterFactory<配置类>
 * @package com.gateway.filters
 * @updateUser
 * @date 23:21 2021/2/8
 */
@Slf4j
@Component
public class LogGatewayFilterFactory extends AbstractGatewayFilterFactory<LogGatewayFilterFactory.Config>
        implements Ordered {


    public LogGatewayFilterFactory() {
        super(LogGatewayFilterFactory.Config.class);
    }

    /**
     * @description 过滤器逻辑
     * @author ym.y
     * @updateUser
     * @date 23:29 2021/2/8
     */
    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                if (config.isCacheLog()) {
                    log.info("CacheLog缓存开启");
                }
                if (config.isConsoleLog()) {
                    log.info("ConsoleLog缓存开启");
                }
                return chain.filter(exchange);
            }
        };
    }


    /**
     * @description 读取配置文件中参数
     * @author ym.y
     * @updateUser
     * @date 23:29 2021/2/8
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("consoleLog", "cacheLog");
    }

    @Override
    public int getOrder() {
        return 1;
    }

    @Data
    @NoArgsConstructor
    public static class Config {
        private boolean consoleLog;
        private boolean cacheLog;

    }
}
