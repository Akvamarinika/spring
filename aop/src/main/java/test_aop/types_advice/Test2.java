package test_aop.types_advice;
import test_aop.types_advice.BookLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test_aop.config.MyConfig;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        BookLibrary bookLibrary = context.getBean("bookLibrary", BookLibrary.class);
        bookLibrary.addBook(new BookL("Book name", "Author surname", 2000));
        bookLibrary.addBook(new BookL("Ветер в ивах", "Кеннет Грэм", 1968));
        bookLibrary.addBook(new BookL("Кэтрин", "Ани Сэтон", 1970));
        System.out.println(bookLibrary.getBooks());

        try {
            bookLibrary.getBook(5);
        } catch (Exception ex){
            System.out.println("Catch exception: " + ex);
        }

        BookL book = new BookL("Book name", "Author surname", 1999);
        bookLibrary.returnBook(book);

        context.close();

    }

}
