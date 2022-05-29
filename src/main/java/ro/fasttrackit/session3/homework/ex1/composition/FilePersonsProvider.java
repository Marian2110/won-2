package ro.fasttrackit.session3.homework.ex1.composition;

import lombok.RequiredArgsConstructor;
import ro.fasttrackit.session3.homework.ex1.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RequiredArgsConstructor
public class FilePersonsProvider implements PersonsProvider {
    private final String sourceFile;

    @Override
    public List<Person> getPersons() {
        try {
            return Files.lines(Path.of(sourceFile))
                    .map(this::toCountry)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Person toCountry(String line) {
        String[] tokens = line.split(",");
        return new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
    }
}
