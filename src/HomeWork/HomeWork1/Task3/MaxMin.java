package HomeWork.HomeWork1.Task3;

import java.util.Arrays;
import java.util.OptionalDouble;

// Заполните массив на N элементов случайным числами.
// Выведете максимальное, минимальное и среднее значение.
public class MaxMin {
    public static void main(String[] args) {
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = (-100 + (int) (Math.random() * 200));
        }
        Arrays.sort(array);
        int sum = 0;
        for (int value : array) {
            System.out.println("Test");
            sum += value;
        }
        double average = (double) sum / array.length;

        double d = Arrays.stream(array).average().getAsDouble();

        System.out.println("Минимальное число в массиве = " + array[0] + "\n" +
                "Среднее арифметическое всех элементов массива = " + average + "\n" +
                "Максимальное число в массиве = " + array[array.length - 1]);
        System.out.println(d);
    }
}
