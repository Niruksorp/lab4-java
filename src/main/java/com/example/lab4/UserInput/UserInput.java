package com.example.lab4.UserInput;

import java.util.Scanner;

public class UserInput {
    public int getInt(final Scanner scanner) {
        System.out.println("Введити число");
        boolean flag = false;
        while (!flag) {
            if (scanner.hasNextInt()) return scanner.nextInt();
            scanner.next();
            System.out.println("Введите значение");
        }
        return -1;
    }
}
