package sk.it.pointcut_expressions.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Before("execution(* sk.it.pointcut_expressions.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("====>>> Executing @Before advice on method");
    }
}
