package test_aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
class LoggingAspect {
    @Pointcut("execution( * get*())")
    private void allGetMethods(){}

    @Before("allGetMethods()")
    public void beforeGetBookAdvice(){
       System.out.println("beforeGetBookAdvice: use method getBook / getMagazine");
       }

   /* @Before("execution(public int returnBook())")
    public void beforeReturnBookAdvice(){
        System.out.println("beforeGetBookAdvice: use method returnBook");
    }*/
}