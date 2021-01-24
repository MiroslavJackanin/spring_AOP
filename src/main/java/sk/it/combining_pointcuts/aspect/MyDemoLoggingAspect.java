package sk.it.combining_pointcuts.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* sk.it.combining_pointcuts.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution(* sk.it.combining_pointcuts.dao.*.get*(..))")
    private void forGetter() {}

    @Pointcut("execution(* sk.it.combining_pointcuts.dao.*.set*(..))")
    private void forSetter() {}

    @Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
    private void forDaoPackageNoGetterNoSetter() {}

    @Before("forDaoPackageNoGetterNoSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("====>>> Executing @Before advice on method");
    }

    @Before("forDaoPackageNoGetterNoSetter()")
    public void performApiAnalytics() {
        System.out.println("====>>> Executing @Before advice on method => performApiAnalytics()");
    }
}
