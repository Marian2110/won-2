package ro.fasttrackit.session4.curscode;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        PersonService personService = new PersonService(
                List.of(
                        new Person("Maria", 13),
                        new Person("Ion", 23),
                        new Person("Mihai", 55),
                        new Person("Margareta", 24),
                        new Person("Corina", 3),
                        new Person("Costel", 7),
                        new Person("Mirabela", 43)
                )
        );

        Map<Range, List<Person>> personsByRange = personService.groupByAgeRange(7,20,40);
    }
}

