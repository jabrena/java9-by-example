package org.java9.by.example.streams;

import org.junit.Test;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListFilteringTests extends BaseTest{

    static {
        BaseTest.setupLogger(ListFilteringTests.class);
    }


    private Supplier<Stream<Integer>> list() {
        return () -> List.of(1, 2, 3, 5, 5).stream();
    }

    @Test
    public void listTest() {
        list()
                .get()
                .forEach(trace);
    }

    @Test
    public void listFilterTest() {
        list()
                .get()
                .filter(i -> i > 3)
                .forEach(trace);
    }

    @Test
    public void listFilterCollectTest() {
        list()
                .get()
                .filter(i -> i > 2)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .forEach(trace);
    }

    @Test
    public void listFilteringTest() {
        list()
                .get()
                .collect(Collectors.groupingBy(i -> i,
                        Collectors.filtering(val -> val > 2, Collectors.counting())))
                .entrySet()
                .forEach(trace);
    }
}
