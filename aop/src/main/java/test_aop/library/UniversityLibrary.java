package test_aop.library;

import org.springframework.stereotype.Component;
import test_aop.library.AbstractLibrary;

@Component
public class UniversityLibrary extends AbstractLibrary {
    @Override
    public void getBook(){
        System.out.println("getBook from UniversityLibrary");
    }

    public void getMagazine(){
        System.out.println("getMagazine from UniversityLibrary");
    }

    public void addBook(){
        System.out.println("addMagazine from UniversityLibrary");
    }

    public void addMagazine(){
        System.out.println("addMagazine from UniversityLibrary");
    }

    public void returnBook(){
        System.out.println("returnMagazine from UniversityLibrary");
    }

    public void returnMagazine(){
        System.out.println("returnMagazine from UniversityLibrary");
    }
}
