package sk.it.ordering_aspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* sk.it.ordering_aspects.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* sk.it.ordering_aspects.dao.*.get*(..))")
    public void forGetter() {}

    @Pointcut("execution(* sk.it.ordering_aspects.dao.*.set*(..))")
    public void forSetter() {}

    @Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
    public void forDaoPackageNoGetterNoSetter() {}
}
