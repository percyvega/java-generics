package com.percyvega.javagenerics;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Holder<T> {

    private T[] array;
    private int index = 0;

    Holder(int count) {
//        array = new T[10];
        array = (T[]) new Object[count];
    }

    void add(T element) {
        array[index++] = element;
    }

    T get(int position) {
        return array[position];
    }


}
