package ru.yakimov;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UsersReWriterTest {

    private UsersReWriter usersReWriter;
    @Before
    public void init(){
        usersReWriter = new UsersReWriter();
    }

    @Test
    public void rewriteSameUsersTest() throws IOException {
        List<String> lines = Arrays.asList("user1 -> xxx@ya.ru, foo@gmail.com, lol@mail.ru",
                "user2 -> foo@gmail.com, ups@pisem.net",
                "user3 -> xyz@pisem.net, vasya@pupkin.com",
                "user4 -> ups@pisem.net, aaa@bbb.ru",
                "user5 -> xyz@pisem.net");

        Path path = Paths.get("ticketSoftTask.txt");
        Files.write(path, lines);

        usersReWriter.rewriteSameUsers(path);

        assertArrayEquals(new String[]{
                "user5 -> vasya@pupkin.com, xyz@pisem.net",
                "user4 -> aaa@bbb.ru, ups@pisem.net, lol@mail.ru, xxx@ya.ru, foo@gmail.com"
        }, Files.readAllLines(path).toArray());

        Files.delete(path);
    }
}