package org.themohit.job_application_tracker.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspact {

    public static final Logger LOGGER= LoggerFactory.getLogger(PerformanceMonitorAspact.class);

    @Around("execution(* org.themohit.job_application_tracker.service.ApplicationService.*(..))")
    public Object getExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long startTime=System.currentTimeMillis();
        Object methodCalled= pjp.proceed();
        long endTime=System.currentTimeMillis();
        LOGGER.info("time taken by "+pjp.getSignature().getName()+" is "+(endTime-startTime)+"ms");
        return methodCalled;
    }
}
