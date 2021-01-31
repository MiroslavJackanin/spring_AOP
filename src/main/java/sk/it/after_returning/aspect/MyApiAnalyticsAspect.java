package sk.it.after_returning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class MyApiAnalyticsAspect {

    @Before("AopExpressions.forDaoPackageNoGetterNoSetter()")
    public void performApiAnalytics() {
        System.out.println("====>>> Executing @Before advice on method => performApiAnalytics()");
    }
}
