package org.mindera.user;

import java.util.Scanner;

public class UserPrompt implements Prompt{

    private final Scanner scanner;

    public UserPrompt() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Character getCharacter() {
        return scanner.next().charAt(0);
    }
}
