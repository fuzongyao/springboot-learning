package cn.fuzongyao.learning.springboot.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fuzongyao
 * @date 2020/05/18
 * @since 1.0.0
 */
@Slf4j
@Aspect
@Component
public class WebLogAspect {

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 以 controller 包下定义的所有请求为切入点
     */
    @Pointcut("execution(public * cn.fuzongyao.learning.springboot.controller..*.*(..))")
    public void webLog() {
    }

    /**
     * 在切点之前织入
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

    }

    /**
     * 环绕
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        long startTime = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            throw e;
        } finally {
            // 打印请求相关参数
            log.info("{} {} {}ms 入参:{} 出参：{}", request.getMethod(), request.getRequestURI(), System.currentTimeMillis() - startTime,
                    objectMapper.writeValueAsString(proceedingJoinPoint.getArgs()), objectMapper.writeValueAsString(result));
        }

        return result;
    }

    /**
     * 在切点之后织入
     *
     * @throws Throwable
     */
    @After("webLog()")
    public void doAfter() throws Throwable {
    }

}
