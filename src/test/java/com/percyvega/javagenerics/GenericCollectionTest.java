package com.percyvega.javagenerics;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class GenericCollectionTest {

    static <T> String getCollectionOfObjects(Collection<T> c) {
        return Arrays.toString(c.toArray());
    }

    static <T extends Number> String getCollectionOfNumbers(Collection<T> c) {
        return Arrays.toString(c.toArray());
    }

    static <T> int getCount(Collection<T> c) {
        return c.size();
    }

    @Test
    void testCollections1() {
        Set setOfRawType = new HashSet();

        setOfRawType.add(5);
        setOfRawType.add(3.0f);

        assertThat(getCollectionOfObjects(setOfRawType)).isEqualTo("[3.0, 5]");
        assertThat(getCount(setOfRawType)).isEqualTo(02);
    }

    @Test
    void testCollections2() {
        Set<Object> setOfAnyType = new HashSet<>();

        setOfAnyType.add("abc");
        setOfAnyType.add(3.0f);

        assertThat(getCollectionOfObjects(setOfAnyType)).isEqualTo("[3.0, abc]");
        assertThat(getCount(setOfAnyType)).isEqualTo(2);
    }

    @Test
    void testCollections4() {
        Set<String> setOfString = new LinkedHashSet<>();

        setOfString.add("abc");
        setOfString.add("def");

        assertThat(getCollectionOfObjects(setOfString)).isEqualTo("[abc, def]");
        assertThat(getCount(setOfString)).isEqualTo(2);
    }

    @Test
    void testCollections5() {
        List<Float> setOfAllSubTypeOfNumber = new LinkedList<>();

        setOfAllSubTypeOfNumber.add(5f);
        setOfAllSubTypeOfNumber.add(4f);
        setOfAllSubTypeOfNumber.add(3f);

        assertThat(getCollectionOfNumbers(setOfAllSubTypeOfNumber)).isEqualTo("[5.0, 4.0, 3.0]");
        assertThat(getCount(setOfAllSubTypeOfNumber)).isEqualTo(3);
    }

    @Test
    void testCollections6() {
        Set<? super TreeMap> setOfAllSuperTypeOfTreeMap;

        setOfAllSuperTypeOfTreeMap = new LinkedHashSet<>(); //legal because TreeMap is superType of itself
        HashMap m = new HashMap();
        m.put("1", 1);
        setOfAllSuperTypeOfTreeMap.add(new TreeMap(m));
        assertThat(getCollectionOfObjects(setOfAllSuperTypeOfTreeMap)).isEqualTo("[{1=1}]");

        setOfAllSuperTypeOfTreeMap = new HashSet<SortedMap>(); //legal because SortedMap is super class of TreeMap
        LinkedHashMap m1 = new LinkedHashMap();
        m1.put("2", 2);
        setOfAllSuperTypeOfTreeMap.add(new TreeMap(m1));
        assertThat(getCollectionOfObjects(setOfAllSuperTypeOfTreeMap)).isEqualTo("[{2=2}]");

        setOfAllSuperTypeOfTreeMap = new LinkedHashSet<Map>(); //legal since Map is super type of TreeMap
        Hashtable m2 = new Hashtable();
        m2.put("3", 3);
        setOfAllSuperTypeOfTreeMap.add(new TreeMap(m2));
        assertThat(getCollectionOfObjects(setOfAllSuperTypeOfTreeMap)).isEqualTo("[{3=3}]");
    }

    @Test
    void testCollections7() {
        List<?> list = Arrays.asList(4, 2, 10, 18, 10, 16, 36, 34);

        assertThat(getCollectionOfObjects(list)).isEqualTo("[4, 2, 10, 18, 10, 16, 36, 34]");
        assertThat(getCount(list)).isEqualTo(8);
    }

    @Test
    void testCollections8() {
        List<Object> list2 = Arrays.asList(4, 2, 10, 18, 10, 16, 36, 34);

        assertThat(getCollectionOfObjects(list2)).isEqualTo("[4, 2, 10, 18, 10, 16, 36, 34]");
        assertThat(getCount(list2)).isEqualTo(8);
    }

}