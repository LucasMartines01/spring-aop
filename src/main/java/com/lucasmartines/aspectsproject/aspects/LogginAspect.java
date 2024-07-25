package com.lucasmartines.aspectsproject.aspects;

import com.lucasmartines.aspectsproject.exceptions.BusinessException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LogginAspect {

    Logger logger = Logger.getLogger(LogginAspect.class.getName());

    @Before("execution(* com.lucasmartines.aspectsproject.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Before method execution " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.lucasmartines.aspectsproject.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("After method execution " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* com.lucasmartines.aspectsproject.service.*.*(..))", throwing = "businessException")
    public void logAfterThrowing(JoinPoint joinPoint, BusinessException businessException) {
        logger.severe(
                "After throwing " +
                        joinPoint.getSignature().getName() + " " +
                        "Exception message:" +
                        businessException.getMessage()
        );
    }

    @AfterReturning(pointcut = "execution(* com.lucasmartines.aspectsproject.controller.*.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info(
                "After returning " +
                        "Class: " + joinPoint.getSignature().getDeclaringTypeName() + " " +
                        joinPoint.getSignature().getName()
                        + " Result: " + result.toString()
        );
    }
}
