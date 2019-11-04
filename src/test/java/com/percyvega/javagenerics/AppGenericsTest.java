package com.percyvega.javagenerics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@Log4j2
class AppGenericsTest {

    @Test
    void collection_factory_without_generics() {
        Map<Integer, String> numbers = new HashMap<>();
        numbers.put(0, "zero");
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");

        for (int i = 0; i < numbers.size(); i++) {
            log.info(numbers.get(i));
        }
    }

    @Test
    void collection_factory_with_generics() {
        Map<Integer, String> numbers = MyHashMap.newInstance();
        numbers.put(0, "zero");
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");

        for (int i = 0; i < numbers.size(); i++) {
            log.info(numbers.get(i));
        }
    }

}