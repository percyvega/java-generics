package com.percyvega.javagenerics;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;

import static com.percyvega.javagenerics.GenericCollection.*;

/*
    You can use anything, but these are the conventions:
        E - Element
        K - Key
        N - Number
        T - Type
        V - Value
        ? - unknown - where the type of objects are irrelevant (e.g. counting list elements)
 */
@Log4j2
class GenericCollection {

    static <T> void printCollectionOfObjects(Collection<T> c) {
        log.info(Arrays.toString(c.toArray()));
    }

    static void printCollectionOfNumbers(Collection<? extends Number> c) {
        log.info(Arrays.toString(c.toArray()));
    }

    static void printCount(Collection<?> c) {
        log.info(c.size());
    }
}

@Log4j2
class GenericCollectionTest {

    @Test
    void testCollections1() {
        Set setOfRawType = new HashSet<Number>();

        setOfRawType.add(5);
        setOfRawType.add(3.0f);

        printCount(setOfRawType);
    }

    @Test
    void testCollections2() {
        Set<Object> setOfAnyType = new HashSet<>();

        setOfAnyType.add("abc");
        setOfAnyType.add(3.0f);

        printCount(setOfAnyType);
    }

    @Test
    void testCollections4() {
        Set<String> setOfString = new LinkedHashSet<>();

        setOfString.add("abc");
        setOfString.add("def");

        printCollectionOfObjects(setOfString);
        printCount(setOfString);
    }

    @Test
    void testCollections5() {
        List<Float> setOfAllSubTypeOfNumber = new LinkedList<>();

        setOfAllSubTypeOfNumber.add(5f);
        setOfAllSubTypeOfNumber.add(4f);
        setOfAllSubTypeOfNumber.add(3f);

        printCollectionOfNumbers(setOfAllSubTypeOfNumber);
        printCount(setOfAllSubTypeOfNumber);
    }

    @Test
    void testCollections6() {
        Set<? super TreeMap> setOfAllSuperTypeOfTreeMap;

        setOfAllSuperTypeOfTreeMap = new LinkedHashSet<>(); //legal because TreeMap is superType of itself
        HashMap m = new HashMap();
        m.put("1", 1);
        setOfAllSuperTypeOfTreeMap.add(new TreeMap(m));
        printCollectionOfObjects(setOfAllSuperTypeOfTreeMap);

        setOfAllSuperTypeOfTreeMap = new HashSet<SortedMap>(); //legal because SortedMap is super class of TreeMap
        LinkedHashMap m1 = new LinkedHashMap();
        m1.put("2", 2);
        setOfAllSuperTypeOfTreeMap.add(new TreeMap(m1));
        printCollectionOfObjects(setOfAllSuperTypeOfTreeMap);

        setOfAllSuperTypeOfTreeMap = new LinkedHashSet<Map>(); //legal since Map is super type of TreeMap
        Hashtable m2 = new Hashtable();
        m2.put("3", 3);
        setOfAllSuperTypeOfTreeMap.add(new TreeMap(m2));
        printCollectionOfObjects(setOfAllSuperTypeOfTreeMap);
    }

    @Test
    void testCollections7() {
        List<?> list = Arrays.asList(4, 2, 10, 18, 10, 16, 36, 34);

        printCollectionOfObjects(list);
        printCount(list);
    }

    @Test
    void testCollections8() {
        List<Object> list2 = Arrays.asList(4, 2, 10, 18, 10, 16, 36, 34);

        printCollectionOfObjects(list2);
        printCount(list2);
    }

}