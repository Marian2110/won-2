package ro.fasttrackit.session4.homework.ex3;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Person myPerson = new Person("John", 30, "Rome");
        Map<Predicate<Person>, Function<Person, String>> cases = Map.of(
                p -> p.age() > 18, p -> "major",
                p -> p.age() < 18, p -> "minor",
                p -> p.address().equals("Rome"), p -> "From Rome",
                p -> true, p -> "default"
        );
        LogicalSwitch logicalSwitch = new LogicalSwitch(cases);
        System.out.println(logicalSwitch.testCases(myPerson));
    }
}




