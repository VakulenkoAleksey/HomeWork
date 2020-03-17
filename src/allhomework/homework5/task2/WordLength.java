package allhomework.homework5.task2;

//Найдите самое длинное слово в предложении, при условии, что в предложении все слова разной длины.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class WordLength {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String word = "";
        String[] words = str.split("\\s");
        for (String string: words) {
            if (string.length() > word.length()){
                word = string;
            }
        }
        System.out.println(word);
    }
}
