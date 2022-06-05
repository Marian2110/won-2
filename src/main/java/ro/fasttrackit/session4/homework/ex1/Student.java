package ro.fasttrackit.session4.homework.ex1;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public record Student(String name, LocalDate birthDate, int grade) {

    public Student(long age) {
        this("No Name", generateRandomBirthDate(age), 10);
    }

    private static LocalDate generateRandomBirthDate(long age) {
        int yearOfBirth = (int) (LocalDate.now().getYear() - age);
        var randomMonth = Month.of(new Random().nextInt(1, 13));
        var randomDay = new Random().nextInt(1, randomMonth.maxLength() + 1);
        return LocalDate.of(yearOfBirth, randomMonth, randomDay);
    }

    public long age() {
        return Period.between(birthDate, LocalDate.now()).get(ChronoUnit.YEARS);
    }
}
