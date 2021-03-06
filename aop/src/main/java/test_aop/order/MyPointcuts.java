package test_aop.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyPointcuts {
    @Pointcut("execution(* test_aop.library.UniversityLibrary.get*(..))")
    public void allGetMethodsFromUniversityLibrary(){}
}
