package ro.fasttrackit.session4.homework.ex2;

public sealed interface Animal permits Dog, Cat, Bird, Insect {
    void eat();
}
