package com.percyvega.javagenerics;


import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

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
public class AppGenericArrays {

    static <AA> void print(AA[] elements) {
        log.info("Array: " + Arrays.toString(elements));
        StringBuilder stringBuilder = new StringBuilder();
        for (AA element : elements) {
            stringBuilder.append(element.toString() + " ");
        }
        log.info("Elements: " + stringBuilder.toString());
    }

    //  A super      Number: A or any of its superclasses
    //  A extends    Number: A or any type that extends Number
    //  A implements Number: A or any type that implements Number
    static <A extends Number> void printLargestNumber(A[] elements) {
        A largestNumber = elements[0];

        for (A element : elements) {
            if (element.doubleValue() > largestNumber.doubleValue()) {
                largestNumber = element;
            }
        }

        log.info("Largest: " + largestNumber.toString());
    }

    static <A extends Number> A getLargestNumber(A[] elements) {
        A largestNumber = elements[0];

        for (A element : elements) {
            if (element.doubleValue() > largestNumber.doubleValue()) {
                largestNumber = element;
            }
        }

        return largestNumber;
    }

}