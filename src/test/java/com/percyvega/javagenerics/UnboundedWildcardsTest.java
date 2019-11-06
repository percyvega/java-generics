package com.percyvega.javagenerics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@Log4j2
class UnboundedWildcardsTest {

    // Does NOT work
//    private void printList(List<Object> list) {
//        log.info(Arrays.toString(list.toArray()));
//    }

    private void printList(List<?> list) {
        log.info(Arrays.toString(list.toArray()));
    }

    @Test
    void useListOfIntegers() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        printList(list);
    }

    @Test
    void useListOfStrings() {
        List<String> list = Arrays.asList("January", "February", "March");
        printList(list);
    }

}
