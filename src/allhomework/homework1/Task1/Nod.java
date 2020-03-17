package allhomework.homework1.Task1;
// Найти наибольший общий делитель (НОД) двух чисел

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Nod {
    public static void main(String[] args) throws IOException, InterruptedException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        System.out.println("Введите первое целое число: ");
        int n;
        int m;
        n = Integer.parseInt(reader.readLine());
        if (n == 0) {
            while (true) {
                System.out.println("Введено число равное нулю.");
                Thread.sleep(1000);
                System.out.println("Введите число не равное нулю:");
                n = Integer.parseInt(reader.readLine());
                if (n != 0) {
                    break;
                }
            }
        }
        System.out.println("Введите второе целое число: ");
        m = Integer.parseInt(reader.readLine());
        if (m == 0) {
            while (true) {
                System.out.println("Введено число равное нулю.");
                Thread.sleep(1000);
                System.out.println("Введите число не равное нулю:");
                m = Integer.parseInt(reader.readLine());
                if (m != 0) {
                    break;
                }
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        int nod = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                arrayList.add(i);
            }
        }
        for (int i = 1; i <= m; i++) {
            if (m % i == 0) {
                arrayList1.add(i);
            }
        }
        if (arrayList.size() < arrayList1.size()) {
            for (Integer i : arrayList) {
                if (arrayList1.indexOf(i) != -1) {
                    nod = i;
                }
            }
        } else {
            for (Integer i : arrayList1) {
                if (arrayList.indexOf(i) != -1) {
                    nod = i;
                }
            }
        }
        System.out.println("Наибольший общий делитель равен " + nod + ".");
    }
}