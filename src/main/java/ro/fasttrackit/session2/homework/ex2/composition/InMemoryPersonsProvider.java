package ro.fasttrackit.session2.homework.ex2.composition;

import ro.fasttrackit.session2.homework.ex2.Person;

import java.util.List;

public class InMemoryPersonsProvider implements PersonsProvider {
    @Override
    public List<Person> getPersons() {
        return List.of(
                new Person("Arvin", "Doe", 21),
                new Person("Jane", "Doe", 22),
                new Person("John", "Smith", 33),
                new Person("Jane", "Smith", 34),
                new Person("John", "Doe", 67)
        );
    }
}
