package ro.fasttrackit.session4.curscode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Integer.MAX_VALUE;
import static java.util.stream.Collectors.toList;

public class Ranges {
    private final List<Range> ranges = new ArrayList<>();

    public Ranges(int... values) {
        this.ranges.addAll(buildRanges(values));
    }

    private List<Range> buildRanges(int[] values) {
        if (values == null || values.length == 0) {
            return List.of(new Range(0, MAX_VALUE));
        }
        List<Integer> internalValues = Arrays.stream(values)
                .boxed()
                .collect(toList());

        internalValues.add(0, 0);
        internalValues.add(MAX_VALUE);

        var finalValues = internalValues.stream()
                .filter(val -> val >= 0)
                .distinct()
                .sorted()
                .toList();

        return IntStream.range(0, finalValues.size() - 1)
                .mapToObj(index -> new Range(finalValues.get(index), finalValues.get(index + 1)))
                .toList();

//        List<Range> result = new ArrayList<>();
//        if (internalValues.get(0) > 0) {
//            result.add(new Range(0, internalValues.get(0)));
//        }
//
//        for (int i = 0; i < internalValues.size() - 1; i++) {
//            result.add(new Range(internalValues.get(i), internalValues.get(i + 1)));
//        }
//
//        if (internalValues.get(internalValues.size() - 1) != MAX_VALUE) {
//            result.add(new Range(internalValues.get(internalValues.size() - 1), MAX_VALUE));
//
//        }
//
//        return result;

    }

    public List<Range> geRanges() {
        return ranges;
    }

    public Range getRange(int value) {
        return ranges.stream()
                .filter(range -> range.contains(value))
                .findFirst()
                .orElseGet(() -> new Range(0, MAX_VALUE));
    }
}
