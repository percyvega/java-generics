package com.percyvega.javagenerics;

import java.util.HashMap;

public class MyHashMap<K, V> extends HashMap<K, V> {

    static <K, V> HashMap<K, V> newInstance() {
        return new HashMap<>();
    }

}
