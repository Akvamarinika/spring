package my_spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Flyable bird = context.getBean("myPet", Flyable.class);
        bird.fly();
        context.close();
    }
}
