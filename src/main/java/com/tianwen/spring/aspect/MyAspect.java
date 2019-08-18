package com.tianwen.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * wangjq
 * 2019年07月30日  23:37
 */
@Aspect
@Component
@EnableAspectJAutoProxy
public class MyAspect {

//     * 任意返回值
//     com.tianwen.spring.service.. .当前包 ..当前包及子包
//     * 任意类名
//     *d1 任意方法名后缀为d1的方法
//     (..) 任意方法参数
    @Pointcut(value = "execution(* com.tianwen.spring.service..*.*d1(..))")
//    @Pointcut(value = "execution(* com.tianwen.spring.service..*A.*d1(..))")
//    @Pointcut(value = "execution(* com.tianwen.spring.service..*.*(..))")
    public void pointcut() {}

    @Around(value = "pointcut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before...");
        proceedingJoinPoint.proceed();
        System.out.println("after...");
    }
}
