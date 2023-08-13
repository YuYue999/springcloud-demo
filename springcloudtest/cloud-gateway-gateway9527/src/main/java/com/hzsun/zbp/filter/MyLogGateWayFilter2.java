package com.hzsun.zbp.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Date;

@Component
@Slf4j
public class MyLogGateWayFilter2 implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("***********come in MyLogGateWayFilter第二个过滤器:  "+new Date());
        URI uri = exchange.getRequest().getURI();
        int port = uri.getPort();
        if(port != 2222)
        {
            log.info("*******用户名为null，端口号不是8011，不允许通过，o(╥﹏╥)o");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            //不予放行
            return exchange.getResponse().setComplete();
        }
        //放行，进入过滤器链上的下一个过滤器
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
