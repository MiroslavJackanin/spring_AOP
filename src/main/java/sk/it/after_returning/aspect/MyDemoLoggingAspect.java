package sk.it.after_returning.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sk.it.after_returning.Account;

import java.util.List;

@Aspect
@Order(2)
@Component
public class MyDemoLoggingAspect {

    @AfterReturning(
            pointcut = "execution(* sk.it.after_returning.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        System.out.println("\n=====>>> Result: " + result);

        convertAccountNamesToUpperCase(result);

        System.out.println("\n=====>>> Result: " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for (Account account : result) {
            String upperName = account.getName().toUpperCase();
            account.setName(upperName);
        }
    }

    @Before("AopExpressions.forDaoPackageNoGetterNoSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("====>>> Executing @Before advice on method");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();
        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {
                Account account = (Account) tempArg;
                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }
    }
}
