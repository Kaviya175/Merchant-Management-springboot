package com.app.merchant.aop;

import com.app.merchant.model.Merchant;
import com.app.merchant.util.CacheUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MerchantAspect {
    @Autowired
    CacheUtil cacheUtil;
    @Around("execution(* com.app.merchant.service.Service.getMerchantsByMob(..))")
    public Object excuteCache(ProceedingJoinPoint joinPoint) throws Throwable {
        String mobNo = (String) joinPoint.getArgs()[0];
        if(cacheUtil.containsMerchant(mobNo)){
            System.out.println("from cache ");
            return cacheUtil.getMerchant(mobNo);

        }
        Merchant merchant = (Merchant) joinPoint.proceed();
        if(merchant != null){
            cacheUtil.putMerchant(mobNo, merchant);
        }
        System.out.println("from cache ");
        return merchant;
    }
}
