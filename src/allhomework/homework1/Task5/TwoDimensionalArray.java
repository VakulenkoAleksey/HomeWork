package allhomework.homework1.Task5;
//Создать двумерный массив из 5 строк по 8 столбцов в каждой из случайных целых чисел из отрезка [-99;99].
//Вывести массив в консоль.
//После на отдельной строке вывести в консоль значение максимального элемента этого массива.

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int max = Integer.MIN_VALUE;
        int[][] array = new int[5][8];
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (-99 + (int) (Math.random() * 199));
                System.out.print(array[i][j] + "  ");
                if (array[i][j] > max){
                    max = array[i][j];
                }
            }
        }
        System.out.println();
        System.out.print("Значение максимального элемента = " + max);
    }
}
