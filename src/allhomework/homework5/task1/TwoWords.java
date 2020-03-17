package allhomework.homework5.task1;

//Даны 2 слова, состоящие из четного числа букв.
// Получить слово состоящее из первой половины первого слова и второй половины второго слова.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word1;
        String word2;
        while (true) {
            System.out.println("Введите первое слово состоящее исключительно из четного числа букв:");
            word1 = reader.readLine();
            if (!(word1.isEmpty()) && word1.length() % 2 == 0) {
                break;
            } else {
                System.out.println("Введено не корректное слово!");
            }
        }
        while (true) {
            System.out.println("Введите второе слово состоящее исключительно из четного числа бкув:");
            word2 = reader.readLine();
            if (!(word2.isEmpty()) && word2.length() % 2 == 0) {
                break;
            } else {
                System.out.println("Введено не корректное слово!");
            }
        }
        String string = word1.substring(0, word1.length() / 2);
        String string2 = word2.substring(word2.length() / 2);

        System.out.println(string + string2);
//      Или так, как будет правельнее не знаю, мне кажется без изпользования StringBuilder,
//      т.к. выделяется доп. память.

//        StringBuilder sb = new StringBuilder();
//        sb.append(string).append(string2);
//        System.out.println(sb);
    }
}
