package com.percyvega.javagenerics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class UpperBoundedWildcardTest {

    private <T extends Number> Double getSum2(List<T> list) {
        return list.stream()
                .mapToDouble(o -> Double.parseDouble((o.toString())))
                .sum();
    }

    private Double getSum(List<? extends Number> list) {
        return list.stream()
                .mapToDouble(o -> Double.parseDouble((o.toString())))
                .sum();
    }

    @Test
    void useListOfIntegers() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(getSum(list)).isEqualTo(15);
        assertThat(getSum2(list)).isEqualTo(15);
    }

    @Test
    void useListOfFloats() {
        List<Float> list = Arrays.asList(1.1f, 2.1f, 3.1f, 4.1f, 5.1f);
        assertThat(getSum(list)).isEqualTo(15.5);
        assertThat(getSum2(list)).isEqualTo(15.5);
    }

}
