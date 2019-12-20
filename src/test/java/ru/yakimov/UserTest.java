package ru.yakimov;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class UserTest {
    public User userOne;
    public User userTwo;

    @Before
    public void init(){
        userOne = new User("User1", new HashSet<>(Arrays.asList(
                "yakimovvn@bk.ru"
                ,"asicsvolody@mail.ru"))
        );

        userTwo = new User("User2", new HashSet<>(Arrays.asList(
                "yakimovvn@bk.ru"
                ,"vertifi@mail.ru"))
        );
    }


    @Test
    public void unionTest() {
        userOne.union(userTwo);
        assertSame(3, userOne.getMails().size());

    }

    @Test
    public void testEquals() {
        assertEquals(userOne, userTwo);
    }

    @Test
    public void testToString() {
        assertEquals("User1 -> yakimovvn@bk.ru, asicsvolody@mail.ru",userOne.toString());
    }
}