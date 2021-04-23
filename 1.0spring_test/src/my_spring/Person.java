package my_spring;

public class Person {
    private Pet pet;
    private Pet pet2;

    public Person(Pet pet){
        this.pet = pet;
    }

   // public Person(){}

    public void setPet(Pet pet2){
        this.pet2 = pet2;
        System.out.println("Set pet2!");
    }

    public void callYourPet(){
        System.out.println("Hello, my lovely " + pet.getName());
        pet.voice();
    }
}
