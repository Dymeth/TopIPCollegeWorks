package me.dymeth.college.java.work2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int n = scanner.nextInt();

        int fact = factorial(n);
        int digits = countDigits(fact);

        System.out.println("Факториал: " + fact + ", количество цифр в нём: " + digits);

        scanner.close();
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }
        number = Math.abs(number);
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }
}
