package ro.fasttrackit.session2.homework.ex2.composition;

import ro.fasttrackit.session2.homework.ex2.Person;

import java.util.List;

public interface PersonsProvider {

    List<Person> getPersons();
}
