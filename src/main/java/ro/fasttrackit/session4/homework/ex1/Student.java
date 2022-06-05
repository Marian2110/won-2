package ro.fasttrackit.session4.homework.ex1;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public record Student(String name, LocalDate birthDate, int grade) {

    public Student(String name, long age, int grade) {
        this(name, generateRandomBirthDate(age), grade);
    }

    private static LocalDate generateRandomBirthDate(long age) {
        int yearOfBirth = LocalDate.now().minusYears(age).getYear();
        var randomMonth = Month.of(new Random().nextInt(1, 13));
        var randomDay = new Random().nextInt(1, randomMonth.maxLength() + 1);
        return LocalDate.of(yearOfBirth, randomMonth, randomDay);
    }

    public long age() {
        return Period.between(birthDate, LocalDate.now()).get(ChronoUnit.YEARS);
    }
}
