package org.themohit.job_application_tracker.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidateAspact {
    public static final Logger LOGGER= LoggerFactory.getLogger(ValidateAspact.class);

    @Around("execution(* org.themohit.job_application_tracker.service.ApplicationService.getApplication(..)) && args(id)")
    public Object validateAndUpdate(ProceedingJoinPoint pjp,int id) throws Throwable {
        if(id<0){
            LOGGER.info("id is negative");
            id=Math.abs(id);
            LOGGER.info("new value is "+id);
        }
        Object obj=pjp.proceed(new Object[]{id});
        return obj;
    }
}
