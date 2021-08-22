package test_aop.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(20)
@Component
public class SecurityAspect {
    @Before("test_aop.order.MyPointcuts.allGetMethodsFromUniversityLibrary()")
    private void checkingRightsWhenGetBookOrMagazine(){
        System.out.println("verification of rights when trying to take a book/magazine ...");
    }
}
