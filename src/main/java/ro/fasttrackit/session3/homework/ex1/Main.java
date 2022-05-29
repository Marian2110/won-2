package ro.fasttrackit.session3.homework.ex1;


import ro.fasttrackit.session2.homework.ex2.inheritance.FilePersonsReportGenerator;
import ro.fasttrackit.session2.homework.ex2.inheritance.InMemoryPersonsReportGenerator;
import ro.fasttrackit.session3.homework.ex1.composition.FilePersonsProvider;
import ro.fasttrackit.session3.homework.ex1.composition.PersonsReportGenerator;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        PersonsReportGenerator personsReportGenerator2 = new PersonsReportGenerator(new FilePersonsProvider("people.txt"));
        personsReportGenerator2.generateReport("dynamic.txt", List.of(
                new AgeCategory(0, 30),
                new AgeCategory(31, 60),
                new AgeCategory(61, 100)
        ));
    }

}
