package com.percyvega.javagenerics;


import lombok.extern.log4j.Log4j2;

import java.util.Collection;
import java.util.Iterator;

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
public class AppGenericCollections {

    static void printCollection(Collection c) {
        Iterator i = c.iterator();
        for (int k = 0; k < c.size(); k++) {
            log.info(i.next().toString());
        }
    }

    static void printCollectionOfObjects(Collection<Object> c) {
        for (Object e : c) {
            log.info(e.toString());
        }
    }

    static void printCollectionOfUnknowns(Collection<?> c) {
        for (Object e : c) {
            log.info(e.toString());
        }
    }

}