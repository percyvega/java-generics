package com.percyvega.javagenerics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

interface MythologicalCharacter {
    String getOrigin();
}
interface Superhero {
    String getPublisher();
}

class ComicCharacter {
    boolean isFicticious() {
        return true;
    }
}

abstract class CharacterWithGender {
    abstract String getGender();
}

class Thor extends ComicCharacter implements MythologicalCharacter, Superhero {
    @Override
    public String getOrigin() {
        return "Germanic";
    }

    @Override
    public String getPublisher() {
        return "DC";
    }
}
class Superman extends CharacterWithGender implements Superhero {
    @Override
    public String getPublisher() {
        return "Marvel";
    }

    @Override
    String getGender() {
        return "Male";
    }
}

@Log4j2
class ComicsUtil {
    static <T extends MythologicalCharacter & Superhero> void printOriginAndPublisher(T t) {
        log.info(t.getOrigin());
        log.info(t.getPublisher());
    }

    static <T extends Superhero> void printPublisher(T t) {
        log.info(t.getPublisher());
    }

    static <T extends ComicCharacter> void printIsFictitious(T t) {
        log.info(t.isFicticious());
    }

    static <T extends CharacterWithGender> void printGender(T t) {
        log.info(t.getGender());
    }
}


@Log4j2
public class BoundedTypeParameterTest {

    @Test
    void test() {
        Thor thor = new Thor();

        ComicsUtil.printOriginAndPublisher(thor);
        ComicsUtil.printPublisher(thor);
        ComicsUtil.printIsFictitious(thor);

        Superman superman = new Superman();

        ComicsUtil.printPublisher(superman);
        ComicsUtil.printGender(superman);
    }
}
