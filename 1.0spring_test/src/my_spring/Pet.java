package my_spring;

public abstract class Pet {
    private String name;

    Pet(String name){
        this.name = name;
    }
    Pet(){ }

    public String getName() {
        return name;
    }

    public void voice(){
        System.out.println("Voice!");
    }
}
