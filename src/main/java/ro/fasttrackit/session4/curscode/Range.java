package ro.fasttrackit.session4.curscode;

public record Range(int min, int max) {

    public boolean contains(int value) {
        return value >= min && value < max;
    }
}
