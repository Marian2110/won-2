package ro.fasttrackit.session4.homework.ex1;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@AllArgsConstructor
public class StudentService {

    private final List<Student> students;

    private final List<String> courses = new ArrayList<>(List.of(
            """
                    {
                        "course":"Math 101",
                        "semester":2
                    }""",
            """
                    {
                        "course":"Math 102",
                        "semester":2
                    }""",
            """
                    {
                        "course":"Math 103",
                        "semester":2
                    }"""
    ));

    public String getStudentNamesAndAverageGrades() {
        return students.stream()
                .collect(
                        Collectors.teeing(
                                mapping(Student::name, joining(", ")),
                                averagingInt(Student::grade),
                                (names, averageGrade) -> String.format("%s have an average grade of %.2f", names, averageGrade)
                        )
                );
    }

    public void randomlyAllocateCourseToStudent() {
        students.forEach(student -> {
            int randomIndex = new Random().nextInt(courses.size());
            System.out.printf("%s will participate to course %s%n", student.name(), courses.get(randomIndex));
        });
    }

    public String getStudentGrade(Student student) {
        int index = students.indexOf(student);
        return switch (index) {
            case 0, 1, 2 -> "1st grade";
            case 3 -> "5nd grade";
            default -> "7th grade";
        };
    }
}
