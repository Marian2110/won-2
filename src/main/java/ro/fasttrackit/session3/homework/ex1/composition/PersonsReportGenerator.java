package ro.fasttrackit.session3.homework.ex1.composition;

import lombok.RequiredArgsConstructor;
import ro.fasttrackit.session3.homework.ex1.AgeCategory;
import ro.fasttrackit.session3.homework.ex1.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

@RequiredArgsConstructor
public class PersonsReportGenerator {
    private final PersonsProvider personProvider;

    public void generateReport(String outputFileName, List<AgeCategory> ageCategories) throws IOException {

        List<Person> persons = personProvider.getPersons();
        generateReport(persons, outputFileName, ageCategories);
    }

    private void generateReport(List<Person> persons, String outputFileName, List<AgeCategory> ageCategories) throws IOException {
        Map<String, List<String>> personsByAgeCategory = groupPersonsByAgeCategory(ageCategories, persons);
        StringBuilder report = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : personsByAgeCategory.entrySet()) {
            report.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
        writeLine(writer, report.toString());
        writer.close();
    }
    private Map<String, List<String>> groupPersonsByAgeCategory(List<AgeCategory> ageCategories, List<Person> persons) {
        return persons.stream()
                .collect(
                        groupingBy(
                                person -> ageCategories.stream()
                                        .filter(ageCategory -> ageCategory.isBetween(person.age())).findFirst()
                                        .map(ageCategory -> ageCategory.minAge() + "-" + ageCategory.maxAge())
                                        .orElse("Unknown")
                                , mapping(person -> person.firstName() + " " + person.lastName(), toList())
                        )
                );
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
