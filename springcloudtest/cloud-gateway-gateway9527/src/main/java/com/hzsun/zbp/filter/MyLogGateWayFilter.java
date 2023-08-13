package com.hzsun.zbp.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @auther zzyy
 * @create 2020-02-21 16:40
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("***********come in MyLogGateWayFilter 第一个过滤器:  " + new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");

        if (uname == null) {
            log.info("*******用户名为null，非法用户，o(╥﹏╥)o");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            //不予放行
            return exchange.getResponse().setComplete();
        }
        //放行，进入过滤器链上的下一个过滤器
        return chain.filter(exchange);
    }

    /**
     * 加载过滤器的顺序，数字越低，越先加载
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
