package ro.fasttrackit.session4.homework.ex2;

public sealed interface Bird extends Animal permits Canary, Parrot, Chicken {
    void fly();
}
