package com.percyvega.javagenerics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class UpperBoundedWildcardAfterTypeErasureTest {

    // This works too
//    private <T extends Number> void logSum(List<T> list) {
//        double sum = list.stream()
//                .mapToDouble(o -> Double.parseDouble((o.toString())))
//                .sum();
//    }

    private Double getSum(List<Number> list) {
        return list.stream()
                .mapToDouble(o -> Double.parseDouble((o.toString())))
                .sum();
    }

    @Test
    void useListOfIntegers() {
        List<Number> list = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(getSum(list)).isEqualTo(15);
    }

    @Test
    void useListOfFloats() {
        List<Number> list = Arrays.asList(1.1f, 2.1f, 3.1f, 4.1f, 5.1f);
        assertThat(getSum(list)).isEqualTo(15.5);
    }

}
