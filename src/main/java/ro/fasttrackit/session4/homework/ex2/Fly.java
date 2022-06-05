package ro.fasttrackit.session4.homework.ex2;

public class Fly implements Insect {
    @Override
    public void eat() {
        System.out.println("Fly eats insects");
    }

    @Override
    public void move() {
        System.out.println("Fly can fly and walk");
    }
}
