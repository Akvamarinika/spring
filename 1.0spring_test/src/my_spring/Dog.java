package my_spring;

public class Dog extends Pet{
    Dog(String name){
        super(name);
    }

    @Override
    public void voice() {
        System.out.println("Bow-wow!");
    }
}
