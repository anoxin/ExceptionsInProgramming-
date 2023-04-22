package com.example;

/**
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив
 * размером 4х4, при подаче массива другого размера необходимо бросить
 * исключение MyArraySizeException.
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в
 * int, и просуммировать. Если в каком-то элементе массива преобразование не
 * удалось (например, в ячейке лежит символ или текст вместо числа), должно быть
 * брошено исключение MyArrayDataException, с детализацией в какой именно ячейке
 * лежат неверные данные.
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения
 * MyArraySizeException и MyArrayDataException и вывести результат расчета
 * (сумму элементов, при условии что подали на вход корректный массив).
 *
 */
public class App {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] array = new String[][] { { "1", "2", "3", "4" }, { "1", "2", "3", "4" }, { "1", "2", "3", "4" },
                { "1", "2", "3", "4" } };
        checkArray(array);
    }

    private static void checkArray(String[][] array) throws MyArraySizeException {
        int sum = 0;
        boolean check = true;

        for (int i = 0; i < array.length; i++) {
            if (array.length != 4 || array[i].length != 4) {
                try {
                    throw new MyArraySizeException();
                } catch (MyArraySizeException e) {
                    check = false;
                    System.out.println(e);
                }
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    try {
                        sum = sum + Integer.parseInt(array[i][j]);

                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException();
                    }
                } catch (MyArrayDataException e) {
                    check = false;
                    System.out.println(e + "Ячейку " + i + " " + j + " невозможно преобразовать в строку");

                }
            }

        }
        if (check) {
            System.out.println("sum = " + sum);
            System.out.println("Все ок");
        } else {

            System.out.println("Возникла ошибка");
        }

    }
}
