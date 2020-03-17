package allhomework.homework1.Task3;

import allhomework.homework5.task3.Entry;

import java.util.Arrays;

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
            sum += value;
        }
        double average = (double) sum / array.length;

//        double d = Arrays.stream(array).average().getAsDouble();
//        System.out.println(d);
        System.out.println("Минимальное число в массиве = " + array[0] + "\n" +
                "Среднее арифметическое всех элементов массива = " + average + "\n" +
                "Максимальное число в массиве = " + array[array.length - 1]);

        int[] i = new int[5];
        System.out.println(Arrays.toString(i));
        for (int j = 0; j < i.length; j++) {
            if (Arrays.binarySearch(i, j)<0){
                i[j]=j;
            }
        }
        System.out.println(Arrays.toString(i));
    }
}
