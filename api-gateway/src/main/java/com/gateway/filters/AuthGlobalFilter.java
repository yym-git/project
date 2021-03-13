package com.gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author ym.y
 * @description 自定义全局过滤器
 * 作用：统一鉴权,检验是否传为token为admin
 * @package com.gateway.filters
 * @updateUser
 * @date 23:42 2021/2/8
 */
@Slf4j
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    /**
     * @description 过滤器逻辑
     * @author ym.y
     * @updateUser
     * @date 23:45 2021/2/8
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if(!StringUtils.equals("admin",token)){
            //认证失败
            log.info("认证失败.....");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return  exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }


    /**
     * @description 标识过滤器的优先级，越小，优先级越高
     * @author ym.y
     * @updateUser
     * @date 23:44 2021/2/8
     */
    @Override
    public int getOrder() {
        return -1;
    }
}
