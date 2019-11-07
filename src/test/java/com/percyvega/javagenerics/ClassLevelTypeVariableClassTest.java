package com.percyvega.javagenerics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
class ClassLevelTypeVariableClass<T> {

    private T[] array;
    private int index = 0;

    ClassLevelTypeVariableClass(int count) {
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

    // This method's T has nothing to do with the class' T.
    // I could have used for this method any other method level type letter (instead of T)
    public static <T> T echoParam(T t) {
        return t;
    }
}

@Log4j2
class ClassLevelTypeVariableClassTest {

    @Test
    void testInstantiation() {
        ClassLevelTypeVariableClass<Integer> classLevelTypeVariableClass = new ClassLevelTypeVariableClass<>(6);
        classLevelTypeVariableClass.add(3);
        classLevelTypeVariableClass.add(2);
        classLevelTypeVariableClass.add(6);

        for (int i = 0; i < classLevelTypeVariableClass.size(); i++) {
            log.info(classLevelTypeVariableClass.get(i));
        }

        String s = classLevelTypeVariableClass.echoParam("Percy");
        log.info(s);
    }

}
