package ro.fasttrackit.session4.homework.ex2;

public record Cat() implements Animal {
    @Override
    public void eat() {
        System.out.println("Cat eats mice");
    }
}
