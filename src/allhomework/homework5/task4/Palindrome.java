package allhomework.homework5.task4;

//палиндром

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Введите слово/фразу! Для завершения прогрыммы введите пустую строку!");
            String word = reader.readLine();
            if (word.isEmpty()){
                System.out.println("Программа завершена!");
                break;
            }
            StringBuffer reverseWord = new StringBuffer(word).reverse();
            if (word.equalsIgnoreCase(reverseWord.toString())) {
                System.out.println("Слово\\фраза \"" + word + "\" является палиндромом");
            } else {
                System.out.println("Слово\\фраза \"" + word + "\" не является палиндромом");
            }
            System.out.println("****************");
            Thread.sleep(1000);
        }
    }
}
