package my_spring;

public class Bird extends Pet implements Flyable{
    public Bird(String name){
        super(name);
    }

    public Bird(){ }

    @Override
    public void voice() {
        System.out.println("I'm parrot!");
    }

    @Override
    public void fly(){
        System.out.println("Летит...");
    }
}
