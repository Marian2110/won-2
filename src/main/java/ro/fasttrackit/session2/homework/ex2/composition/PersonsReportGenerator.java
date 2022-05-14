package ro.fasttrackit.session2.homework.ex2.composition;

import lombok.RequiredArgsConstructor;
import ro.fasttrackit.session2.homework.ex2.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class PersonsReportGenerator {
    private final PersonsProvider personProvider;


    public void generateReport(String outputFileName) throws IOException {
        List<Person> persons = personProvider.getPersons();
        generateReport(persons, outputFileName);
    }

    private void generateReport(List<Person> persons, String outputFileName) throws IOException {
        List<String> groupedByAgePersonsStrings = new ArrayList<>();
        groupedByAgePersonsStrings.add("1-30: ");
        groupedByAgePersonsStrings.add("30-60: ");
        groupedByAgePersonsStrings.add("60+: ");

        persons.forEach(person -> {
            String personInfo = person.firstName() + " " + person.lastName();
            if (person.age() > 0 && person.age() < 30) {
                groupedByAgePersonsStrings.set(0, groupedByAgePersonsStrings.get(0) + personInfo + ", ");
            } else if (person.age() <= 60) {
                groupedByAgePersonsStrings.set(1, groupedByAgePersonsStrings.get(1) + personInfo + ", ");
            } else {
                groupedByAgePersonsStrings.set(2, groupedByAgePersonsStrings.get(2) + personInfo + ", ");
            }
        });
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            groupedByAgePersonsStrings.forEach(line -> writeLine(writer, line));
        }
    }

    private void writeLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
