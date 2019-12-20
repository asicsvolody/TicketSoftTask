/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsersReWriter {
    public void rewriteSameUsers(Path path) throws IOException {


        List<User> userList = unionUsers(
                getUsersFromFile(path)
        );


        Files.write(path,
                getLinesFromUsersList(userList)
        );

    }

    private List<String> getLinesFromUsersList(List<User> userList){
        return userList
                .stream()
                .map(User::toString)
                .collect(Collectors.toList());
    }

    private List<User> getUsersFromFile(Path path) throws IOException {
        return Files.readAllLines(path)
                .stream()
                .map(this::lineToUser)
                .collect(Collectors.toList());
    }

    private List<User> unionUsers(List<User> userList){
        Stack<User> stack = new Stack<>();
        stack.addAll(userList);
        userList = new ArrayList<>();
        userList.add(stack.pop());
        while(!stack.isEmpty()){
            User newUser = stack.pop();
            boolean isSentOut = false;
            for (User user : userList) {
                if(user.equals(newUser)){
                    user.union(newUser);
                    isSentOut = true;
                    break;
                }
            }

            if(!isSentOut)
                userList.add(newUser);
        }
        return userList;

    }


    private User lineToUser(String line){
        String[] nameAndEmails = line.toLowerCase().split("->", 2);
        String userName = nameAndEmails[0].trim();

        Set<String> eMils = Stream.
                of(nameAndEmails[1].split(","))
                .map(String::trim)
                .collect(Collectors.toSet());

        return new User(userName, eMils);
    }
}
