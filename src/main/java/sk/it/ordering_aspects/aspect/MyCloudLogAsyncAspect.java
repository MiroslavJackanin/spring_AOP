package sk.it.ordering_aspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MyCloudLogAsyncAspect {

    @Before("AopExpressions.forDaoPackageNoGetterNoSetter()")
    public void logToCloudAsync() {
        System.out.println("====>>> Executing @Before advice on method => logToCloudAsync()");
    }
}
