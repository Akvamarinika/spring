package test_aop.types_advice.after;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterAspect {
    @After("execution(* getBook(..))")
    private void afterGetBookAdvice(){
        System.out.println("\n ---afterGetBookAdvice---");
    }
}
