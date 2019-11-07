package com.percyvega.javagenerics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class MyHashMap extends HashMap {
    static <K, V> HashMap<K, V> newInstance() {
        return new HashMap<>();
    }
}

@Log4j2
class CollectionsTest {

    @Test
    void collection_instantiation_without_generics() {
        addItemsAndLog(new HashMap<>());
    }

    @Test
    void collection_factory_with_generics() {
        addItemsAndLog(MyHashMap.newInstance());
    }

    private void addItemsAndLog(HashMap<Integer, String> numbers) {
        numbers.put(0, "zero");
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");

        for (int i = 0; i < numbers.size(); i++) {
            log.info(numbers.get(i));
        }
    }

}