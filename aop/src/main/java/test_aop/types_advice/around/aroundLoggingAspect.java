package test_aop.types_advice.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class aroundLoggingAspect {
    @Around("execution(test_aop.types_advice.BookL returnBook(test_aop.types_advice.BookL))")
    private Object aroundReturnBookAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("\nlogging: попытка вернуть книгу...");
        long start = System.currentTimeMillis();
        Object resultMethodReturnBook;

        try {
            resultMethodReturnBook = proceedingJoinPoint.proceed();
        } catch (Exception ex) {
            System.out.println("logging: было поймано исключение " + ex);
           // BookL nonameBook = new BookL("No name", "No name", 0000);
           // resultMethodReturnBook = nonameBook;
            throw ex;
        }

        long end = System.currentTimeMillis();
        System.out.println("logging: книга была возвращена...");

        System.out.println("Время работы метода " + proceedingJoinPoint.getSignature().getName() + ": " + (end - start) + " mc");
        return resultMethodReturnBook;
    }
}
