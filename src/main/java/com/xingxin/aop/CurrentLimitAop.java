package com.xingxin.aop;

import com.google.common.util.concurrent.RateLimiter;
import com.xingxin.annotation.XingxinCurrentLimit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liuxh
 * @date 2021/9/12
 */
@Aspect
@Component
public class CurrentLimitAop {

    private ConcurrentHashMap<String, RateLimiter> rateLimiterConcurrentHashMap = new ConcurrentHashMap<>();

    @Before(value = "@annotation(com.xingxin.annotation.XingxinCurrentLimit)")
    public Object before() {
        System.out.println("前置通知");
        return null;
    }

    @After(value = "@annotation(com.xingxin.annotation.XingxinCurrentLimit)")
    public Object after() {
        System.out.println("后置通知");
        return null;
    }

    @AfterReturning(value = "@annotation(com.xingxin.annotation.XingxinCurrentLimit)")
    public Object afterReturning() {
        System.out.println("返回通知");
        return null;
    }


    /**
     * 只要方法上加有XingxinCurrentLimit注解，就会被aop环绕通知
     *
     * @param joinPoint
     * @return
     */
    @Around(value = "@within(xingxinCurrentLimit)")
    public Object around(ProceedingJoinPoint joinPoint, XingxinCurrentLimit xingxinCurrentLimit) {
        try {
            // 获取目标方法
            // Signature signature = joinPoint.getSignature();
            // MethodSignature methodSignature = (MethodSignature) signature;
            // XingxinCurrentLimit xingxinCurrentLimit = methodSignature
            //         .getMethod().getDeclaredAnnotation(XingxinCurrentLimit.class);
            // 获取该注解的name
            String name = xingxinCurrentLimit.name();
            // 获取该注解的token
            double token = xingxinCurrentLimit.token();

            // 判断该name属性下是否有创建rateLimiter
            RateLimiter rateLimiter = rateLimiterConcurrentHashMap.get(name);
            if (rateLimiter == null) {
                rateLimiter = RateLimiter.create(token);
                rateLimiterConcurrentHashMap.put(name, rateLimiter);
            }

            System.out.println("环绕通知开始执行");
            boolean acquire = rateLimiter.tryAcquire();
            if (!acquire) {
                return "outpace limit, please wait...";
            }
            // 执行当前目标方法
            Object proceed = joinPoint.proceed();
            System.out.println("环绕通知结束执行");
            return proceed;
//            return "环绕通知";
        } catch (Throwable e) {
            return "系统错误";
        }
    }
}
