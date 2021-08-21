package test_aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test_aop.config.MyConfig;
import test_aop.library.AbstractLibrary;
import test_aop.library.SchoolLibrary;
import test_aop.library.UniversityLibrary;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        AbstractLibrary universityLibrary = context.getBean("universityLibrary", UniversityLibrary.class);
        universityLibrary.getBook();

        SchoolLibrary schoolLibrary = context.getBean(SchoolLibrary.class);
        schoolLibrary.getBook();
        schoolLibrary.getMagazine();
    }

}
