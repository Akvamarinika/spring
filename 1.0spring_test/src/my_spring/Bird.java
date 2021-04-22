package my_spring;

public class Bird  implements Flyable{
   /* Bird(String name){
        super(name);
    }

    @Override
    public void voice() {
        System.out.println("I'm parrot!");
    }*/

    @Override
    public void fly(){
        System.out.println("Летит...");
    }
}
