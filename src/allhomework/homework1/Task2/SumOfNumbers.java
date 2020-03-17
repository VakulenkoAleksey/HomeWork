package allhomework.homework1.Task2;
//Дан массив целых чисел. Массив не отсортирован, числа могут повторяться.
//Необходимо найти в данном массиве такие два числа n и m, чтобы их сумма была равна 7.
//Например, 2 + 5 = 7, 6 + 1 = 7, -2 + 9 = 7. Постарайтесь решить задачу наиболее оптимальным способом
import java.util.Arrays;

public class SumOfNumbers {
    public static void main(String[] args) {
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = (-10 + (int) (Math.random() * 21));
        }
        System.out.println(Arrays.toString(array) +"\n" +
                "*********");
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] + array[j] == 7){
                    System.out.println(array[i] + " + " + array[j] + " = 7");
                }
            }
        }
    }
}
