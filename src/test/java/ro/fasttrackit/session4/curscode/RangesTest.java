package ro.fasttrackit.session4.curscode;

import org.junit.jupiter.api.Test;

import static java.lang.Integer.MAX_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

class RangesTest {

    @Test
    void whenNoArgsThen1RangeIsReturned() {
        Ranges ranges = new Ranges();

        assertThat(ranges.geRanges()).containsExactly(new Range(0, MAX_VALUE));
    }

    @Test
    void whenSingleArgsGiverThen2Ranges() {
        Ranges ranges = new Ranges(10);
        assertThat(ranges.geRanges()).containsExactly(
                new Range(0, 10),
                new Range(10, MAX_VALUE)
        );
    }

    @Test
    void testA2rgs() {
        Ranges ranges = new Ranges(10, 30);
        assertThat(ranges.geRanges()).containsExactly(
                new Range(0, 10),
                new Range(10, 30),
                new Range(30, MAX_VALUE)
        );
    }

    @Test
    void testNotSorted() {
        Ranges ranges = new Ranges(30, 18, 100);
        assertThat(ranges.geRanges()).containsExactly(
                new Range(0, 18),
                new Range(18, 30),
                new Range(30, 100),
                new Range(100, MAX_VALUE)
        );
    }

    @Test
    void testContainsMAX() {
        Ranges ranges = new Ranges(7, 10, 20, MAX_VALUE);
        assertThat(ranges.geRanges()).containsExactly(
                new Range(0, 7),
                new Range(7, 10),
                new Range(10, 20),
                new Range(20, MAX_VALUE)
        );
    }

    @Test
    void testNegativeValues() {
        Ranges ranges = new Ranges(-10, 7, 10, 20, MAX_VALUE);
        assertThat(ranges.geRanges()).containsExactly(
                new Range(0, 7),
                new Range(7, 10),
                new Range(10, 20),
                new Range(20, MAX_VALUE)
        );
    }

    @Test
    void testDuplicatesValues() {
        Ranges ranges = new Ranges(0, 7, 10, 10, 20, MAX_VALUE);
        assertThat(ranges.geRanges()).containsExactly(
                new Range(0, 7),
                new Range(7, 10),
                new Range(10, 20),
                new Range(20, MAX_VALUE)
        );
    }

}