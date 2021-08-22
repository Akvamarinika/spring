package test_aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
class TestAspect {
 /*   @Pointcut("execution( * test_aop.library.UniversityLibrary.*(..))")
    private void allMethodsInUniversity(){}

    @Pointcut("execution( public void test_aop.library.UniversityLibrary.return*(..))")
    private void allMethodsReturn(){}

    @Pointcut("allMethodsInUniversity() && !allMethodsReturn()")
    private void allMethodsUniversityButNotReturn(){
    }

    @Before("allMethodsInUniversity()")
    public void beforeAllMethodsAdvice(){
       System.out.println("beforeAllMethods LOG#1");
       }

    @Before("allMethodsReturn()")
    public void beforeReturnMethodsAdvice(){
        System.out.println("beforeReturnBookAdvice LOG#2: use method returnBook / returnMagazine");
    }

    @Before("allMethodsUniversityButNotReturn()")
    public void beforeAllMethodsExceptMethodReturnAdvice(){
        System.out.println("beforeAllMethodsExceptMethodReturnAdvice LOG#3");
    }

*/

   /* @Before("execution(public int returnBook())")
    public void beforeReturnBookAdvice(){
        System.out.println("beforeGetBookAdvice: use method returnBook");
    }*/
}