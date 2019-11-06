package com.percyvega.javagenerics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@Log4j2
class UpperBoundedWildcardTest {

    // This works too
//    private <T extends Number> void logSum(List<T> list) {
//        double sum = list.stream()
//                .mapToDouble(o -> Double.parseDouble((o.toString())))
//                .sum();
//        log.info(sum);
//    }

    private void logSum(List<? extends Number> list) {
        double sum = list.stream()
                .mapToDouble(o -> Double.parseDouble((o.toString())))
                .sum();
        log.info(sum);
    }

    @Test
    void useListOfIntegers() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        logSum(list);
    }

    @Test
    void useListOfFloats() {
        List<Float> list = Arrays.asList(1.1f, 2.1f, 3.1f, 4.1f, 5.1f);
        logSum(list);
    }

}
