package test_aop.types_advice.after_trowing;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterTrowingAspect {
    @AfterThrowing(pointcut = "execution(* getBook(..))", throwing = "exception")
    private void afterTrowingGetBookAdvice(Throwable exception){
        System.out.println("logging Exception AfterThrowing....");
    }
}
