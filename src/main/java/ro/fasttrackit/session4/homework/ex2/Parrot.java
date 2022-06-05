package ro.fasttrackit.session4.homework.ex2;

public final class Parrot implements Bird {
    @Override
    public void eat() {
        System.out.println("Parrot eats seeds");
    }

    @Override
    public void fly() {
        System.out.println("Parrot flies");
    }
}
