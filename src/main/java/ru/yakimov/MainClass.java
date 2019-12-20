/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainClass {
    public static void main(String[] args) throws IOException {
        checkUniqUsers(Paths.get(args[0]));
    }

    private static void checkUniqUsers(Path path) throws IOException {
        
    }
}
