package com.teamphoneix.gatewayserver.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Iterator;
import java.util.Set;

@Slf4j
@Component
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config> {

    Environment environment;

    public AuthorizationHeaderFilter(Environment environment) {
        super(Config.class);
        this.environment = environment;
    }

    public static class Config {
    }
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest httpRequest = exchange.getRequest();

            if (!httpRequest.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                return onErr(exchange, "Authorization 헤더 부재", HttpStatus.UNAUTHORIZED);
            }

            HttpHeaders httpHeaders = httpRequest.getHeaders();
            Set<String> keys = httpHeaders.keySet();
            Iterator<String> iter = keys.iterator();

            while (iter.hasNext()) {
                log.info(iter.next());
            }

            return chain.filter(exchange);
        };
    }

    private Mono<Void> onErr(ServerWebExchange exchange, String err, HttpStatus httpStatus) {
        ServerHttpResponse httpResponse = exchange.getResponse();
        httpResponse.setStatusCode(httpStatus);

        return httpResponse.setComplete();
    }
}
