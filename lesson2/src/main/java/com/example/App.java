package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа
 * (типа float), и возвращает введенное значение. Ввод текста вместо числа не
 * должно приводить к падению приложения, вместо этого, необходимо повторно
 * запросить у пользователя ввод данных.
 *
 */
public class App {
    public static void main(String[] args) {
        // task1();
        // task2();
        // task3();
        task4();
    }

    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        System.out.println("Введите число");
        while (true) {
            try {
                index = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введено не число, попробуйте ещё раз");
            }
            scanner.next();
        }
        System.out.println("Вы ввели " + index);

    }

    // Задание 2
    public static void task2() {
        int[] intArray = new int[3];
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    // Задание 3

    public static void task3() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException e) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable e) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }

    // Задание 3

    public static void task4() {
        InputStream inputStream;
        try {
            String[] strings = { "apple", "orange" };
            String strings1 = strings[2];
            test();
            int a = 1 / 0;
            inputStream = new FileInputStream("/broken_reference");
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("На ноль делить нельзя");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println("Я все равно выполнился");
        }
        System.out.println("Я жив!");
    }

    private static void test() throws IOException {
        File file = new File("1");
        file.createNewFile();
        FileReader reader = new FileReader(file);
        reader.read();
        test();
    }

}
