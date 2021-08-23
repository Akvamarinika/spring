package test_aop.types_advice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test_aop.config.MyConfig;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        BookL.BookLibrary bookLibrary = context.getBean("bookLibrary", BookL.BookLibrary.class);
        bookLibrary.addBook(new BookL("Book name", "Author surname", 2000));
        bookLibrary.addBook(new BookL("Ветер в ивах", "Кеннет Грэм", 1968));
        bookLibrary.addBook(new BookL("Кэтрин", "Ани Сэтон", 1970));
        System.out.println(bookLibrary.getBooks());

        context.close();

    }

}
