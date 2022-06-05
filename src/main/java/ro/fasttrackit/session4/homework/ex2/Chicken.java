package ro.fasttrackit.session4.homework.ex2;

public non-sealed class Chicken implements Bird {
    @Override
    public void eat() {
        System.out.println("Chicken eats seeds");
    }

    @Override
    public void fly() {
        System.out.println("Chicken can't fly but can walk");
    }
}
