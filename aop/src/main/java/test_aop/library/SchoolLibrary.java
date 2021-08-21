package test_aop.library;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary{

    @Override
    public void getBook() {
        System.out.println("getBook from SchoolLibrary");
    }

    public void getMagazine() {
        System.out.println("getMagazine from SchoolLibrary");
    }

    public int returnBook(){
        System.out.println("returnBook from SchoolLibrary");
        return 0;
    }

}
