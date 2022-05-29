package ro.fasttrackit.session3.homework.ex1;

public record AgeCategory(int minAge, int maxAge) implements Comparable<AgeCategory> {

    public boolean isBetween(int age) {
        return age >= minAge() && age <= maxAge();
    }

    @Override
    public int compareTo(AgeCategory o) {
        return Integer.compare(minAge(), o.minAge());
    }
}
