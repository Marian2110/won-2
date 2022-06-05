package ro.fasttrackit.session4.homework.ex2;

public record Ladybug() implements Insect {
    @Override
    public void eat() {
        System.out.println("Ladybug eats insects");
    }

    @Override
    public void move() {
        System.out.println("Ladybug can fly and walk");
    }
}
