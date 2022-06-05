package ro.fasttrackit.session4.curscode;

import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

public class PersonService {
    private final List<Person> persons;

    public PersonService(List<Person> persons) {
        this.persons = ofNullable(persons)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
    }

    public List<Person> getPersons() {
        return new ArrayList<>(persons);
    }
}
