package com.percyvega.javagenerics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
class Holder<T> {

    private T[] array;
    private int index = 0;

    Holder(int count) {
        array = (T[]) new Object[count];
    }

    void add(T element) {
        array[index++] = element;
    }

    T get(int position) {
        return array[position];
    }

    int size() {
        return array.length;
    }
}

@Log4j2
class HolderTest {

    @Test
    void testInstantiation() {
        Holder<Integer> holder = new Holder<>(4);
        holder.add(3);
        holder.add(2);
        holder.add(6);

        for (int i = 0; i < holder.size(); i++) {
            log.info(holder.get(i));
        }
    }

}
