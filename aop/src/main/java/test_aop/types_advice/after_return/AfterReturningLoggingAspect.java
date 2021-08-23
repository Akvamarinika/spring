package test_aop.types_advice.after_return;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import test_aop.types_advice.BookL;

import java.util.List;

@Component
@Aspect
public class AfterReturningLoggingAspect {
    @Before("execution(* getBooks())")
    private void selectGetBookLibraryLoggingAdvice(){
        System.out.println("logging before: ");
    }


    /**
     * example advice changes book 0
     * */
    @AfterReturning(pointcut = "execution(* getBooks())", returning = "books")
    private void selectGetBookLibraryMethodBefore(List<BookL> books){
        BookL book = books.get(0);
        book.setName("Ребекка");
        book.setAuthor("Дафна Дюморье");
        book.setYear(2005);
    }
}
