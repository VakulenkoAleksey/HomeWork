package allhomework.homework15map;


import org.w3c.dom.ls.LSOutput;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapTask {
    private static List<String> getPeopleByCity(HashMap<String, String> map, String city) {
        List<String> logins = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(city)) {
                logins.add(entry.getKey());
            }
        }
        return logins;
    }

    //Второе задание
    private static Map<String, Integer> getIdenticalWords(List<String> words) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        return map;
    }

    //Третье задание
    private static Map<String, Customer> getAgeFromAndTo(Map<String, Customer> map, int from, int to) {
        Map<String, Customer> newMap = new HashMap<>();
        for (Map.Entry<String, Customer> pair : map.entrySet()) {
            int i = pair.getValue().getAge();
            if (i >= from && i < to) {
                newMap.put(pair.getKey(), pair.getValue());
            }
        }
        return newMap;
    }

    //Четвертое задание
    public static int getWordCount(String text, String word) {
        int count = 0;
        Pattern pattern = Pattern.compile(word);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static Map<Integer, ArrayList<String>> getGroupOfWords(String text) {
        Map<Integer, ArrayList<String>> map = new HashMap<>();
        Pattern pattern = Pattern.compile("\\s|-");
        String[] str = pattern.split(text);
        for (String s : str) {
            int l = s.length();
            if (map.size() == 0 || (!(map.containsKey(l)))) {
                map.put(l, new ArrayList<String>(Collections.singleton(s)));
            } else {
                map.get(l).add(s);
            }
        }
        return map;
    }

    public static void getRepeatingWords(String text) {
        Map<String, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("[\\W]");
        String[] str = pattern.split(text);
        int maxCount = 0;
        for (int i = 0; i < str.length - 1; i++) {
            int count = 1;
            if (str[i] != null) {
                for (int j = i + 1; j < str.length; j++) {
                    if (str[j] != null) {
                        if (str[i].equals(str[j])) {
                            count++;
                            str[j] = null;
                            if (count > maxCount) {
                                maxCount = count;
                            }
                        }
                    }
                }
                map.put(str[i], count);
                str[i] = null;
            }
        }
        for (int i = 0; i < 10; ) {
            for (Map.Entry<String, Integer> mp : map.entrySet()) {
                if (mp.getValue() == maxCount) {
                    System.out.println(mp.getKey());
                    i++;
                    if (i == 10) {
                        break;
                    }
                }
            }
            maxCount--;
        }
//        boolean bl = true;
//        int i = 0;
//        while (bl){
//            for (Map.Entry<String, Integer> mp : map.entrySet()) {
//                if (mp.getValue() == maxCount){
//                    System.out.println(mp.getKey());
//                    i++;
//                    if (i == 10){
//                        bl = false;
//                        break;
//                    }
//                }
//            }
//            maxCount--;
//        }
    }

    public static void getNumberOfLetters(String text) {
        Map<String, Integer> map = new TreeMap<>();
        List<String> arrayList = new ArrayList<>();
        Pattern pattern = Pattern.compile("[\\W]");
        String[] str = pattern.split(text.toLowerCase());
        pattern = Pattern.compile("");
        for (String s : str) {
            arrayList.addAll(Arrays.asList(pattern.split(s)));
        }
        int allCount = arrayList.size();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            int count = 1;
            for (int j = i + 1; j < arrayList.size(); ) {
                if (arrayList.get(i).equals(arrayList.get(j))) {
                    count++;
                    arrayList.remove(j);
                    continue;
                }
                j++;
            }
            map.put(arrayList.get(i), count);
        }
        for (Map.Entry<String, Integer> mp: map.entrySet()) {
            String formattedDouble = String.format("%.2f", mp.getValue() / (double)allCount * 100);
            System.out.println(mp.getKey() + " " + mp.getValue() + " шт, " + formattedDouble + "% от текста!");
        }
    }


    public static void main(String[] args) {
        // TODO:: написать статический метод, который приннимает на вход
        //  мапу (firstTaskMap) и город (city)
        //  и формирует список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";

//        System.out.println(getPeopleByCity(firstTaskMap, city));


        // TODO:: дан список слов (words). Написать метод, который будет возвращать количество одинаковых слов с списке
        //  в виде Map<String, Integer>, где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");
//        System.out.println(getIdenticalWords(words));

        // TODO:: дана мапа (customerMap).
        //  Написать метод, который принимает на вход агрументы int from и int to и возвращает новую мапу,
        //  в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));
//        System.out.println(getAgeFromAndTo(customerMap, 18, 50));


        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод:
        //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов
        //  4. Вывести частоту встречаемости букв анг алфавита в данном тексте. Вывести в процентах для каждой буквы

        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like"; // !!! в тексте содержатся только буквы и пробельные символы !!!
//        System.out.println(getWordCount(text, "a"));
//        for (Map.Entry<Integer, ArrayList<String>> map: getGroupOfWords(text).entrySet()){
//            System.out.println(map);
//        }
        getRepeatingWords(text);
//        getNumberOfLetters(text);

    }

}
