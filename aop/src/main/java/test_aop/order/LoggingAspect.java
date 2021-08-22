package test_aop.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-1)
@Component
public class LoggingAspect {
    @Before("test_aop.order.MyPointcuts.allGetMethodsFromUniversityLibrary()")
    private void loggingGetMethods(){
        System.out.println("logging get Book/Magazine");
    }
}
