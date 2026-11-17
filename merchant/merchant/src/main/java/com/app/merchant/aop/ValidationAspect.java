package com.app.merchant.aop;

import com.app.merchant.exception.InvalidMobileNoException;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {
    @Before("execution(* com.app.merchant.service.Service.getNameAndAge(..))")
    public void excuteValidation(JoinPoint joinPoint) throws Throwable {
        String mobileNo = (String) joinPoint.getArgs()[0];
        if(mobileNo.length()!=10)
        {
            throw new InvalidMobileNoException("Mobile is number should contain 10 digits only!");
        }

    }
}
