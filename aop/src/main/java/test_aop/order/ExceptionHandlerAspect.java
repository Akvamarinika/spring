package test_aop.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(30)
@Component
public class ExceptionHandlerAspect {
    @Before("test_aop.order.MyPointcuts.allGetMethodsFromUniversityLibrary()")
    private void catchExceptionWhenVerificationOfRightsFailed(){
        System.out.println("exception handling...");
    }
}
