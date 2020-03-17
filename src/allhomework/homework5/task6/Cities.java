package allhomework.homework5.task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//Пользователь вводит названия городов через пробел. Вы их присваиваете переменной.
// Переставьте названия так, чтобы они были упорядочены по алфавиту.
public class Cities {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> cities = new ArrayList<>();
        System.out.println("Введите название города, по окончанию ввода нажмите \"Enter\"");
        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) {
                break;
            }
            cities.add(city);
        }
        cities.sort(String::compareToIgnoreCase);
        System.out.println(cities);
    }
}
