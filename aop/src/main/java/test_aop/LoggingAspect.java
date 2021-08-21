package test_aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
class LoggingAspect {
    @Before("execution( * *())")
    public void beforeGetBookAdvice(){
       System.out.println("beforeGetBookAdvice: use method getBook");
       }

   /* @Before("execution(public int returnBook())")
    public void beforeReturnBookAdvice(){
        System.out.println("beforeGetBookAdvice: use method returnBook");
    }*/
}