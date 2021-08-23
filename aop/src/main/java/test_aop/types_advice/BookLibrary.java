package test_aop.types_advice;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookLibrary {
    List<BookL> books = new ArrayList<>();

    public void addBook(BookL book){
        books.add(book);
    }

    public List<BookL> getBooks() {
        return books;
    }

    public void setBooks(List<BookL> books) {
        this.books = books;
    }

    public BookL getBook(int id){ // exception-method
        System.out.println("\nmethod start getBook in class BookLibrary -->");
        return books.get(id);
    }

    public BookL returnBook(BookL book){
        System.out.println("method start returnBook in class BookLibrary -->");
        books.add(book);
        return book;
    }
}
