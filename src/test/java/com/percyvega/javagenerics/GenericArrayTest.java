package com.percyvega.javagenerics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static com.percyvega.javagenerics.GenericArray.getLargest;
import static com.percyvega.javagenerics.GenericArray.print;

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
class GenericArray {

    static <AA> void print(AA[] elements) {
        log.info("Array: " + Arrays.toString(elements));
        StringBuilder stringBuilder = new StringBuilder();
        for (AA element : elements) {
            stringBuilder.append(element.toString());
            stringBuilder.append(" ");
        }
        log.info("Elements: " + stringBuilder.toString());
    }

    //  A super      Number: A or any of its superclasses
    //  A extends    Number: A or any type that extends Number
    static <A extends Comparable<A>> A getLargest(A[] elements) {
        Arrays.sort(elements, Comparator.reverseOrder());

        return elements[0];
    }
}

@Log4j2
class GenericArrayTest {

    @Test
    void printArrayInts() {
        Integer[] integers = new Integer[]{4, 2, 10, 18, 10, 16, 36, 34};
        print(integers);

        log.info(getLargest(integers));
    }

    @Test
    void printArrayIntegers() {
        Integer[] integerArray = {1, 2, 3, 4, 5};
        print(integerArray);

        log.info(getLargest(integerArray));
    }

    @Test
    void printArrayDoubles() {
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        print(doubleArray);

        log.info(getLargest(doubleArray));
    }

    @Test
    void printArrayChars() {
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        print(charArray);

        log.info(getLargest(charArray));
    }

    @Test
    void printArrayStrings() {
        String[] strings = {"Matthew", "Mark", "Luke", "John"};
        print(strings);

        log.info(getLargest(strings));
    }

}
