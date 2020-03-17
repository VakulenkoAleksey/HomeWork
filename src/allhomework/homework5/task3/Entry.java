package allhomework.homework5.task3;

//Имеются две строки. Найти количество вхождений одной строки в другую.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Entry {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите строку");
        String string1 = reader.readLine();
        System.out.println("Введите подстроку");
        String string2 = reader.readLine();
        Pattern pattern = Pattern.compile(string2.toLowerCase());
        Matcher matcher = pattern.matcher(string1.toLowerCase());
        int count = 0;
        while (matcher.find()){
            count++;
        }
        System.out.println("Количество вхождений подстроки в строку = " + count + ".");
    }
}
