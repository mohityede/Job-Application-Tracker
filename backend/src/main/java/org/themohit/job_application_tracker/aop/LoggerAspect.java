package org.themohit.job_application_tracker.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {
    public static final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    // return-type class-name.method-name(args)
    @Before("execution(* org.themohit.job_application_tracker.service.ApplicationService.*(..))")
    public void logMethodCall(JoinPoint jp){
        logger.warn("log method called "+jp.getSignature().getName());
//        System.out.println("logg sout");
    }
}
