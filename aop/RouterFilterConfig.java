package com.codingfist.burninghouseuser.globalcommon.globalcommon.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import tv.kees.kees.common.Principal.FanzyAuthenticate;

@Configuration
@Slf4j
public class RouterFilterConfig {

    public Mono<ServerResponse> routerFilter(ServerRequest request, HandlerFunction<ServerResponse> handler) {
        return request.bodyToMono(String.class)// 1
                .doOnNext(body -> requestLogging(request, body)) // 2
                .flatMap(body ->handler.handle(ServerRequest.from(request).build()))// 3
                .doOnNext(response -> responseLogging(request, response)); // 4
    }

//    public Mono<ServerResponse> routerFilterWithPrincipal(ServerRequest request, HandlerFunction<ServerResponse> handler) {
//        return request.principal()// 1
//                .doOnNext(body -> requestLogging2(request, (FanzyAuthenticate)body)) // 2
//                .flatMap(body -> handler.handle(request))// 3
//                .doOnNext(response -> responseLogging(request, response)); // 4
//    }

    public Mono<ServerResponse> afterReturn(ServerRequest request, HandlerFunction<ServerResponse> handler) {
        return handler.handle(request)
                .doOnNext(response -> responseLogging(request, response)); // 4
    }

    private void requestLogging(ServerRequest request, String body) {
        log.info("Request : {} {} | {}", request.method(), request.path(), body);
    }

    private void requestLogging2(ServerRequest request, FanzyAuthenticate principal) {
        log.info("Request : {} {} | {} | {}", request.method(), request.path(), principal.getUserId());
    }

    private void responseLogging(ServerRequest request, ServerResponse response) {
        log.info("Response : {} {} | {}", request.method(), request.path(), response.statusCode());
        log.info("--------------- @After ---------------");
    }
}