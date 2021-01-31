package sk.it.join_points.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* sk.it.join_points.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* sk.it.join_points.dao.*.get*(..))")
    public void forGetter() {}

    @Pointcut("execution(* sk.it.join_points.dao.*.set*(..))")
    public void forSetter() {}

    @Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
    public void forDaoPackageNoGetterNoSetter() {}
}
