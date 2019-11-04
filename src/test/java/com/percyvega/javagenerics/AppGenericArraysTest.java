package com.percyvega.javagenerics;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static com.percyvega.javagenerics.AppGenericArrays.*;

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
class AppGenericArraysTest {

    @Test
    void printArrayInts() {
        Integer[] integers = new Integer[]{4, 2, 10, 18, 10, 16, 36, 34};
        print(integers);
        printLargestNumber(integers);

        Integer largestNumber = getLargestNumber(integers);
        log.info(largestNumber);
    }

    @Test
    void printArrayIntegers() {
        Integer[] integerArray = {1, 2, 3, 4, 5};
        print(integerArray);
        printLargestNumber(integerArray);
    }

    @Test
    void printArrayDoubles() {
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        print(doubleArray);
        printLargestNumber(doubleArray);
    }

    @Test
    void printArrayChars() {
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        print(charArray);
    }

    @Test
    void printArrayStrings() {
        String[] strings = {"Matthew", "Mark", "Luke", "John"};
        print(strings);
    }

}