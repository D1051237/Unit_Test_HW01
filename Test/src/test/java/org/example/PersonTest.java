package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void test() throws Exception {
        System.out.println("    Person test begin ...");
        String err_meg = "";
        Person Joe = new Person("Joe", 1998);
        try {
            Joe.setHW(222,100);
        } catch (Exception e){
            err_meg = e.getMessage();
        }
        String finalErr_meg = err_meg;
        Person finalJoe = Joe;
        assertAll("Person Testing",
                () -> assertEquals("Joe", Joe.Name),
                () -> assertEquals(25,Joe.getAge()),
                () -> assertEquals("invalid height", finalErr_meg));
        System.out.println("    Person test end ...");
    }
}