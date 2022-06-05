package ro.fasttrackit.session4.homework.ex3;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public record LogicalSwitch(Map<Predicate<Person>, Function<Person, String>> cases) {
    public String testCases(Person person, String defaultValue) {
        return cases.entrySet().stream()
                .filter(entry -> entry.getKey().test(person))
                .findFirst()
                .orElse(Map.entry(p -> true, p -> defaultValue))
                .getValue()
                .apply(person);
    }
}
