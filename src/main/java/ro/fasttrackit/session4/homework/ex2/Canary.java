package ro.fasttrackit.session4.homework.ex2;

public record Canary() implements Bird {
    @Override
    public void eat() {
        System.out.println("Canary eats seeds");
    }

    @Override
    public void fly() {
        System.out.println("Canary flies");
    }
}
