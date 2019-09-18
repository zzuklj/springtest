package com.klj.springtest.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author klj
 * @Title: PrintTime
 * @Description: TODO
 * @date 2018/8/617:25
 */
@Aspect
@Component
public class TimeInterceptor {

    // service层的统计耗时切面，类型必须为final String类型的,注解里要使用的变量只能是静态常量类型的
    public static final String POINT = "execution (* com.klj.springtest.util.file.FileOperate.*(..))";

    @Around(POINT)
    public Object timeAroud(ProceedingJoinPoint pjp){
        Object obj = null;
        // 定义返回对象、得到方法需要的参数
        Object[] args = pjp.getArgs();
        long startTime = System.currentTimeMillis();
        try {
            obj = pjp.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        Signature signature = pjp.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
        long diffTime = endTime - startTime;
        System.out.println(("-----" + methodName + " 方法执行耗时：" + diffTime + " ms"));
        return obj;
    }
}
