package me.dymeth.college.java.work2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            System.out.print("Введите число №" + i + ": ");
            int number = scanner.nextInt();
            System.out.println("Квадрат числа " + number + " = " + square(number));
        }

        scanner.close();
    }

    public static int square(int number) {
        return number * number;
    }
}

