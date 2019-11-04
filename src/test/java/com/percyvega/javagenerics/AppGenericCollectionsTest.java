package com.percyvega.javagenerics;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.percyvega.javagenerics.AppGenericCollections.*;

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
class AppGenericCollectionsTest {

    @Test
    void testCollections1() {
        Set setOfRawType = new HashSet<Integer>();

        printCollection(setOfRawType);
        printCollectionOfUnknowns(setOfRawType);
    }

    @Test
    void testCollections2() {
        Set<Object> setOfAnyType = new HashSet<>();
        setOfAnyType.add("abc"); //legal
        setOfAnyType.add(3.0f);

        printCollection(setOfAnyType);
        printCollectionOfUnknowns(setOfAnyType);
    }

    @Test
    void testCollections3() {
        Set<?> setOfUnknownType = new LinkedHashSet<Integer>();

        printCollection(setOfUnknownType);
        printCollectionOfUnknowns(setOfUnknownType);
    }

    @Test
    void testCollections4() {
        Set<String> setOfString = new LinkedHashSet<>(); // Ok

        printCollection(setOfString);
        printCollectionOfUnknowns(setOfString);
    }

    @Test
    void testCollections5() {
        Set<? extends Number> setOfAllSubTypeOfNumber = new HashSet<Float>(); //legal - because Float extends Number

        printCollection(setOfAllSubTypeOfNumber);
        printCollectionOfUnknowns(setOfAllSubTypeOfNumber);
    }

    @Test
    void testCollections6() {
        Set<? super TreeMap> setOfAllSuperTypeOfTreeMap;

        setOfAllSuperTypeOfTreeMap = new LinkedHashSet<>(); //legal because TreeMap is superType of itself
        printCollection(setOfAllSuperTypeOfTreeMap);
        printCollectionOfUnknowns(setOfAllSuperTypeOfTreeMap);

        setOfAllSuperTypeOfTreeMap = new HashSet<SortedMap>(); //legal because SortedMap is super class of TreeMap
        printCollection(setOfAllSuperTypeOfTreeMap);
        printCollectionOfUnknowns(setOfAllSuperTypeOfTreeMap);

        setOfAllSuperTypeOfTreeMap = new LinkedHashSet<Map>(); //legal since Map is super type of TreeMap

        printCollection(setOfAllSuperTypeOfTreeMap);
        printCollectionOfUnknowns(setOfAllSuperTypeOfTreeMap);
    }

    @Test
    void testCollections7() {
        List<?> list = Arrays.asList(4, 2, 10, 18, 10, 16, 36, 34);
        printCollection(list);
        printCollectionOfUnknowns(list);
    }

    @Test
    void testCollections8() {
        List<Object> list2 = Arrays.asList(4, 2, 10, 18, 10, 16, 36, 34);
        printCollectionOfObjects(list2);
    }

}