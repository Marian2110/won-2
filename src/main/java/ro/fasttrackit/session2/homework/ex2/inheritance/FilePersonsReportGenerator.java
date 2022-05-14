package ro.fasttrackit.session2.homework.ex2.inheritance;

import lombok.RequiredArgsConstructor;
import ro.fasttrackit.session2.homework.ex2.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RequiredArgsConstructor
public class FilePersonsReportGenerator extends PersonsReportGenerator {
    private final String sourceFile;

    @Override
    List<Person> getPersons() {
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
