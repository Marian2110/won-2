package ro.fasttrackit.session2.homework.ex2;

import ro.fasttrackit.session2.homework.ex2.composition.FilePersonsProvider;
import ro.fasttrackit.session2.homework.ex2.composition.InMemoryPersonsProvider;
import ro.fasttrackit.session2.homework.ex2.composition.PersonsReportGenerator;
import ro.fasttrackit.session2.homework.ex2.inheritance.FilePersonsReportGenerator;
import ro.fasttrackit.session2.homework.ex2.inheritance.InMemoryPersonsReportGenerator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        InMemoryPersonsReportGenerator inMemoryPersonsReportGenerator = new InMemoryPersonsReportGenerator();
        inMemoryPersonsReportGenerator.generateReport("inheritance_in_memory.txt");

        FilePersonsReportGenerator filePersonsReportGenerator = new FilePersonsReportGenerator("people.txt");
        filePersonsReportGenerator.generateReport("inheritance_source_file.txt");

        PersonsReportGenerator personsReportGenerator = new PersonsReportGenerator(new InMemoryPersonsProvider());
        personsReportGenerator.generateReport("composition_in_memory.txt");

        PersonsReportGenerator personsReportGenerator2 = new PersonsReportGenerator(new FilePersonsProvider("people.txt"));
        personsReportGenerator2.generateReport("composition_source_file.txt");
    }

}
