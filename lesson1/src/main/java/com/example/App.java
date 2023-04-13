package com.example;

import java.util.Random;

/**
 * 1. Реализуйте метод checkArray(Integer[] arr), принимающий в качестве
 * аргумента целочисленный одномерный массив. Метод должен пройтись по каждому
 * элементу и проверить что он не равен null.
 * А теперь реализуйте следующую логику:
 * Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом
 * пользователя
 * Если null’ы встретились в нескольких ячейках, то идеально было бы все их
 * “подсветить”
 * 
 * 2. Реализуйте метод, принимающий в качестве аргументов два целочисленных
 * массива, и возвращающий новый массив, каждый элемент которого равен сумме
 * элементов двух входящих массивов в той же ячейке. Если длины массивов не
 * равны, необходимо как-то оповестить пользователя.
 * 
 * 3*. Реализуйте метод, принимающий в качестве аргументов двумерный массив.
 * Метод должен проверить что длина строк и столбцов с одинаковым индексом
 * одинакова, детализировать какие строки со столбцами не требуется.
 *
 */
public class App {
    public static void main(String[] args) {
        // task1();
        // task2();
        task3();
    }

    private static void task1() {
        Integer[] arr = { 4, 2, 6, 7, 8, null, 2, null, 7 };
        printTask1Arr(arr);
        System.out.println(checkArray(arr));
    }

    private static void task2() {
        int[] arr1 = { 4, 2, 6, 7, 8, 7, 2, 3, 5 };
        int[] arr2 = { 2, 6, 3, 9, 0, 3, 1, 9, 8 };
        if (arr1.length != arr2.length) {
            System.out.println("Длины массивов неравны");
        } else {
            printTask2Arr(newArr(arr1, arr2));
        }

    }

    private static void task3() {
        Random rnd = new Random();
        int matrix[][] = { { 1, 1, 1 }, { 1, 0 }, { 1, 0, 0 } };

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rnd.nextInt(2);
            }
        }
        System.out.println(checksLengthArrayStrings(matrix));

    }

    public static String checksLengthArrayStrings(int array[][]) {
        for (int[] row : array) {
            int i = 0;
            int count = 0;
            for (int[] rowCheck : array) {
                if (rowCheck.length >= i) {
                    count++;
                }
            }
            if (row.length != count) {
                return "Длина строк и столбцов с одинаковым индексом разная";
            }

        }
        return "Все ок";

    }

    private static String checkArray(Integer[] arr) {
        String info = "Найден null в ячейках: ";
        boolean check = true;

        if (arr == null) {
            return "Массив не может быть null";
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                info = info + i + ", ";
                check = false;
            }
            if (i == arr.length - 1 && check) {
                return "null в массиве не найден";

            }
        }
        return info;
    }

    private static void printTask1Arr(Integer[] arr) {
        String info = "";
        for (int i = 0; i < arr.length; i++) {
            info = info + arr[i] + " ";
        }
        System.out.println(info);
    }

    private static void printTask2Arr(int[] arr) {
        String info = "";
        for (int i = 0; i < arr.length; i++) {
            info = info + arr[i] + " ";
        }
        System.out.println(info);
    }

    private static int[] newArr(int[] arr1, int[] arr2) {
        int[] newArr = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            newArr[i] = arr1[i] + arr2[i];
        }
        return newArr;
    }
}
