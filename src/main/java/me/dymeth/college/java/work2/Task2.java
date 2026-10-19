package me.dymeth.college.java.work2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первую оценку: ");
        double a = scanner.nextDouble();
        System.out.print("Введите вторую оценку: ");
        double b = scanner.nextDouble();
        System.out.print("Введите третью оценку: ");
        double c = scanner.nextDouble();

        double avg = average(a, b, c);
        String result = classify(avg);

        System.out.printf("Средний балл: %.2f — %s%n", avg, result);

        scanner.close();
    }

    public static double average(double a, double b, double c) {
        return (a + b + c) / 3;
    }

    public static String classify(double avg) {
        if (avg >= 7) {
            return "Высокий средний балл";
        } else {
            return "Низкий средний балл";
        }
    }
}
