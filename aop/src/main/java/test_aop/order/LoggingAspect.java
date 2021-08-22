package test_aop.order;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import test_aop.library.Book;

@Aspect
@Order(-1)
@Component
public class LoggingAspect {
    @Before("test_aop.order.MyPointcuts.allGetMethodsFromUniversityLibrary()")
    private void loggingGetMethods(JoinPoint joinPoint){
        System.out.println("logging get Book/Magazine");
        System.out.println("----------------------------");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("getSignature(): " + methodSignature);
        System.out.println("getMethod(): " + methodSignature.getMethod());
        System.out.println("getReturnType(): " + methodSignature.getReturnType());
        System.out.println("----------------------------");
        Object[] args = joinPoint.getArgs();
        for (Object obj : args){
            if (obj instanceof Book){
                Book book = (Book) obj;
                System.out.println("Name book: " + book.getName());
                System.out.println("Author book: " + book.getAuthor());
                System.out.println("Year book: " + book.getYear());
            } else if(obj instanceof String) {
                System.out.println("Wants to take a book: " + obj);
            }
        }
        System.out.println("----------------------------");
    }
}
