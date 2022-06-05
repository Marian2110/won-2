package ro.fasttrackit.session4.homework.ex3;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public record LogicalSwitch(Map<Predicate<Person>, Function<Person, String>> cases) {
    public String testCases(Person person) {
        for (Map.Entry<Predicate<Person>, Function<Person, String>> entry : cases.entrySet()) {
            if (entry.getKey().test(person)) {
                return entry.getValue().apply(person);
            }
        }
        return "No match";
    }
}
