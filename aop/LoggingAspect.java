package com.codingfist.burninghouseuser.globalcommon.globalcommon.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import tv.kees.kees.common.Principal.FanzyAuthenticate;

@Aspect
@Component
@Slf4j
public class LoggingAspect {


    @Pointcut(
            "within(@org.springframework.stereotype.Repository *)" +
                    "|| within(@org.springframework.stereotype.Service *)"
    )
    private void allCut() {
    }
    @Pointcut(
            "within(@org.springframework.stereotype.Controller *)"
    )
    private void controllerCut() {

    }

    //@Before(value = "@annotation(customController)")
    @Before(value = "controllerCut()")
    public void before(JoinPoint joinPoint) {
        log.info("--------------- @Before ---------------");
        ServerRequest test = (ServerRequest) joinPoint.getArgs()[0];
        log.info(test.remoteAddress().get().getHostString());
        log.info("Request : {} {} | {} ", test.method(), test.path(), test.remoteAddress());
//
    }

    @AfterThrowing(pointcut = "allCut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        Long userId = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof FanzyAuthenticate) {
                userId = ((FanzyAuthenticate) arg).getUserId();
            }
        }
        String user = null;
        if (userId == null) {
            user = "anonymous";
        } else {
            user = userId.toString();
        }
        log.error("Error - Method : {} | Message : {} | UserIdFromPrincipal : {} | args : {}", joinPoint.getSignature().getName(), e.getMessage(), user, joinPoint.getArgs());
    }

//    @AfterReturning(value = "controllerCut()", returning = "object")
//    public void afterReturn(JoinPoint joinPoint, Object object) {
//        log.info("--------------- @After Return--------------- {}",object.getClass());

//    }
}
