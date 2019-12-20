/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov;

import java.io.IOException;
import java.nio.file.Paths;

public class MainClass {
    public static void main(String[] args) throws IOException {
        new UsersReWriter()
                .rewriteSameUsers(
                        Paths.get(args[0])
                );
    }
}
