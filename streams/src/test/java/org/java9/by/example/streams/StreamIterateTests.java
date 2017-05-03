package org.java9.by.example.streams;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamIterateTests {

    private final static Logger logger = LoggerFactory.getLogger(StreamIterateTests.class);

    @Test
    public void noStreamTest() {
        for (int i = 0; i < 10; i++) {
            logger.trace(Integer.toString(i));
        }
    }

    @Test
    public void streamIterateTest() {
        Stream.iterate(0, i -> i < 10, i -> i + 1).forEach(
                integer -> {
                    logger.trace(integer.toString());
                }
        );
    }

    private static Consumer<Object> trace = o -> logger.trace(o.toString());

    @Test
    public void streamIterateLambdaTest() {
        Stream.iterate(0, i -> i < 10, i -> i + 1).forEach(trace);
    }

    private static class NumberGenerator {

        private int total;

        NumberGenerator() {
            this.total = 0;
        }

        int getTotal() {
            return this.total;
        }

        void addRandom(int min, int max) {
            this.total += (int) (Math.random() * max) + min;
        }

        @Override
        public String toString() {
            return Integer.toString(this.total);
        }
    }

    @Test
    public void numberGeneratorTest() {
        Stream.iterate(new NumberGenerator(),
                (numberGenerator -> numberGenerator.getTotal() < 50),
                numberGenerator -> {
                    numberGenerator.addRandom(5, 5);
                    return numberGenerator;
                })
                .forEach(trace);
    }


    private NumberGenerator with(Supplier<NumberGenerator> generator) {
        return generator.get();
    }

    private Predicate<NumberGenerator> toSum(int total) {
        return numberGenerator -> numberGenerator.getTotal() < total;
    }

    private UnaryOperator<NumberGenerator> addRandom(int min, int max) {
        return numberGenerator -> {
            numberGenerator.addRandom(min, max);
            return numberGenerator;
        };
    }

    @Test
    public void numberGeneratorLambdaTest() {
        Stream.iterate(
                with(NumberGenerator::new),
                toSum(50),
                addRandom(5, 5))
                .forEach(trace);
    }

    Predicate<NumberGenerator> isSmallerThan(int number) {
        return numberGenerator -> numberGenerator.getTotal() < number;
    }

    @Test
    public void takeWhileTest() {
        Stream.iterate(
                with(NumberGenerator::new),
                toSum(50),
                addRandom(5, 5))
                .takeWhile(isSmallerThan(20))
                .forEach(trace);
    }

    @Test
    public void dropWhileTest() {
        Stream.iterate(
                with(NumberGenerator::new),
                toSum(50),
                addRandom(5, 5))
                .dropWhile(isSmallerThan(20))
                .forEach(trace);
    }
}
