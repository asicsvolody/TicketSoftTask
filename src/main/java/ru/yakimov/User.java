/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {
    private String name;
    private Set<String> eMails;

    public User(String name, Set<String> eMails) {
        this.name = name;
        this.eMails = eMails;
    }

    public String getName() {
        return name;
    }

    public Set<String> getMails() {
        return eMails;
    }

    public void union(User user){
        this.eMails.addAll(user.eMails);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;

        Set<String> eqSet = new HashSet<>(this.eMails);
        return eqSet.removeAll(user.eMails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, eMails);
    }

    @Override
    public String toString() {
        return name + " -> " + String.join(", ", this.eMails);
    }
}
