package com.project.study.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Aspect
@Slf4j
@Component
public class TimeTraceAspect {

    @Around("@annotation(com.project.study.utils.annotation.TimeTrace)")
    public void doTrace(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTIme = System.currentTimeMillis();

        joinPoint.proceed();

        long endTIme = System.currentTimeMillis();

        long resultTime = endTIme - startTIme;
        String target = joinPoint.getSignature().toShortString();
        log.info("메서드 시간 측정 {} , {} ms", target, resultTime);

    }
}



