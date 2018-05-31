package com.epam.lab.task.agency.service.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Services layer logger. Writes logs about a methods execution.
 */
@Aspect
public class ServiceLogger {
    private static final Logger Log = LoggerFactory.getLogger(ServiceLogger.class);

    /**
     * Writes log information before methods execution where methods satisfy particular pattern.
     *
     * @param joinPoint Before method execution point
     */
    @Before("execution(* com.epam.lab.task.agency.service.impl.*ServiceImpl.*(..))")
    public void logBeforeExecution(JoinPoint joinPoint) {
        Log.info("Method has been invoked : " + joinPoint.getSignature().getName());
        Log.info("Transferred parameters : " + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * Writes log information after methods return execution where methods satisfy particular pattern.
     *
     * @param joinPoint After method execution point
     * @param result    Value returned by method
     */
    @AfterReturning(
            pointcut = "execution(* com.epam.lab.task.agency.service.impl.*ServiceImpl.*(..)))",
            returning = "result"
    )
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        Log.info("Executed method : " + joinPoint.getSignature().getName());
        Log.info("Transferred parameters : " + Arrays.toString(joinPoint.getArgs()));
        Log.info("Method returned value : " + result);
    }

    /**
     * Writes log information after methods exception throwing where methods satisfy particular pattern.
     *
     * @param joinPoint After method execution point
     * @param error     Particular exception has been thrown by method
     */
    @AfterThrowing(
            pointcut = "execution(* com.epam.lab.task.agency.service.impl.*ServiceImpl.*(..)))",
            throwing = "error"
    )
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        Log.error("Exception during method execution!");
        Log.error("Exception has been thrown within method : " + joinPoint.getSignature().getName());
        Log.error("Exception name : " + error);
        Log.error("Exception message : " + error.getMessage());
    }
}
