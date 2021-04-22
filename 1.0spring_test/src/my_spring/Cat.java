package my_spring;

public class Cat extends Pet{
    public Cat(String name){
        super(name);
    }

    @Override
    public void voice(){
        System.out.println("Mew-Meo");
    }


}
