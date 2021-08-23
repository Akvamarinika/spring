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
}
