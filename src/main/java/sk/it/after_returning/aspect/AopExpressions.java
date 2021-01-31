package sk.it.after_returning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* sk.it.after_returning.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* sk.it.after_returning.dao.*.get*(..))")
    public void forGetter() {}

    @Pointcut("execution(* sk.it.after_returning.dao.*.set*(..))")
    public void forSetter() {}

    @Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
    public void forDaoPackageNoGetterNoSetter() {}
}
