package test_aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test_aop.config.MyConfig;
import test_aop.library.AbstractLibrary;
import test_aop.library.SchoolLibrary;
import test_aop.library.UniversityLibrary;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        UniversityLibrary universityLibrary = context.getBean("universityLibrary", UniversityLibrary.class);
        universityLibrary.getBook();
        universityLibrary.getMagazine();

        universityLibrary.returnBook();
        universityLibrary.returnMagazine();

        universityLibrary.addBook();
        universityLibrary.addMagazine();

     /*   SchoolLibrary schoolLibrary = context.getBean(SchoolLibrary.class);
        schoolLibrary.getBook();
        schoolLibrary.getMagazine(); */
    }

}
