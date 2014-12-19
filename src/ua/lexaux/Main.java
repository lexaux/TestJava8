package ua.lexaux;

import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * Created by lexaux on 12/18/14.
 */
public class Main {
    public static void main(String[] args) {
        long count = Stream.of("a", "b", "cd", "c")
                .limit(5)
                .filter(s -> s.length() < 2)
                .sorted(comparing(String::length).reversed())
                .count();
        System.out.println("Count " + count);
    }
}
