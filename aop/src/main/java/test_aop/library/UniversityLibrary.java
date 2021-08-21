package test_aop.library;

import org.springframework.stereotype.Component;
import test_aop.library.AbstractLibrary;

@Component
public class UniversityLibrary extends AbstractLibrary {
    @Override
    public void getBook(){
        System.out.println("getBook from UniversityLibrary");
    }
}
