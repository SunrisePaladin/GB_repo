package Exceptions;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        System.out.println(metod1(new int[] { 1, 2, 3, 993423, 10331, 55 }, 1));
        System.out.println(getElemIndexInArray(new int[] { 1, 2, 3, 993423, 10331, 55 }, 10331, 1));
    }

    public static String expr(char a) throws Exception {
        // Введите свое решение ниже
        if (a == ' ') throw new Exception("Пустая строка введена.");
        else {
            String res = "Ваш ввод - " + a;
            return res;
        }
    }

    public static double expr(int[] intArray, int d) {
        // Введите свое решение ниже
        if (intArray.length < 8) {
            System.out.println(
                    "It's not possible to evaluate the expression - intArray[8] / d as there is no 8th element in the given array.");
            return Double.NaN;
        } else if (d == 0) {
            return Double.NaN;
        }
    }

    public static float isFloat(String input) {
        // Введите свое решение ниже
        float f = 0.f;
        try {
            f = Float.parseFloat(input);
        } catch (NumberFormatException e) {
            System.out.println("Your input is not a float number. Please, try again.");
            return Float.NaN;
        } finally {
            return f;
        }
    }

    public static int metod1(int[] array, int min) {
        if (array.length < min)
            return -1;
        return array.length;
    }

    public static int getElemIndexInArray(int[] array, int elem, int min) {
        if (array == null)
            return -3;
        if (array.length < min)
            return -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elem) {
                return i;
            }
        }
        return -2;
    }

    public static int[] subArrays(int[] a, int[] b) {
        // Введите свое решение ниже
        if (a.length == b.length) {
            int[] result = new int[a.length];
            for (int i = 0; i < a.length; i++)
                result[i] = a[i] - b[i];
            return result;
        } else
            return new int[] { 0 };
    }
}
