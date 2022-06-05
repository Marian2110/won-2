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

    private final List<Course> courses = new ArrayList<>(List.of(
            new Course("Java", 1),
            new Course("JavaScript", 1),
            new Course("C++", 2)
    ));

    public String getStudentNamesAndAverageGrades() {
        return students.stream()
                .collect(
                        Collectors.teeing(
                                mapping(Student::name, joining(", ")),
                                averagingDouble(Student::grade),
                                (names, averageGrade) -> String.format("%s have an average grade of %.2f", names, averageGrade)
                        )
                );
    }

    public void randomlyAllocateCourseToStudent() {
        String studentsCourses = students.stream()
                .collect(
                        toMap(
                                student -> student,
                                student -> courses.get(new Random().nextInt(courses.size()))
                        ))
                .entrySet()
                .stream()
                .map(studentCourseEntry -> {
                    Student student = studentCourseEntry.getKey();
                    Course course = studentCourseEntry.getValue();
                    return """
                            %s is enrolled in
                            {
                                "course": "%s",
                                "semester": %s
                            }
                            """.formatted(student.name(), course.name(), course.semester());
                }).collect(
                        Collectors.joining("\n")
                );
        System.out.println(studentsCourses);
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
