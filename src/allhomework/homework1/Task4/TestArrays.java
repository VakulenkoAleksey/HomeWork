package allhomework.homework1.Task4;
//Пользователь вводит с клавиатуры натуральное число большее 3, которое сохраняется в переменную n.
//Если пользователь ввёл не подходящее число, то программа должна просить пользователя повторить ввод.
// Создать массив из n случайных целых чисел из отрезка [0;n] и вывести его на экран.
// Создать второй массив только из чётных элементов первого массива, если они там есть, и вывести его в консоль

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TestArrays {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        while (true) {
            System.out.println("Введите число больше 3:");
            n = Integer.parseInt(reader.readLine());
            if (n > 3) {
                break;
            } else {
                System.out.println("Введенное число меньше 3.");
                Thread.sleep(1000);
            }
        }
        int arrayLength = 0;
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int) (Math.random() * n));
            if (array[i] % 2 == 0) {
                arrayLength++;
            }
        }
        System.out.println("Массив array \n" + Arrays.toString(array));
        if (arrayLength > 0) {
            int index = 0;
            int[] evenArray = new int[arrayLength];
            for (int i : array) {
                if (i % 2 == 0) {
                    evenArray[index] = i;
                    index++;
                }
            }
            System.out.println("Четные числа массива array \n" + Arrays.toString(evenArray));
        }
    }
}
