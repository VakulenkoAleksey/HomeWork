package allhomework.exception.task2;

import java.util.*;

public class ThrowsException {
    public static void main(String[] args) {
        List<Exception> exceptions = new ArrayList<>();
        try {
            int i = 5 / 0;
        } catch (ArithmeticException e) {
            exceptions.add(e);
        }

        try {
            String s = null;
            s.length();
        } catch (NullPointerException e) {
            exceptions.add(e);
        }

        try {
            int[] i = new int[-1];
        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }

        try {
            int[] i = new int[1];
            i[2] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            Object[] s = new String[1];
            s[0] = 1;
        } catch (ArrayStoreException e) {
            exceptions.add(e);
        }

        try {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.get(1);
        } catch (IndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            Object o = "123";
            Integer y = (Integer) o;
        } catch (ClassCastException e) {
            exceptions.add(e);
        }

        try {
            String s = "object";
            s = s.substring(-1);
        } catch (StringIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("Cat");
            for (String s : arrayList) {
                arrayList.add("Dog");
            }
        } catch (ConcurrentModificationException e) {
            exceptions.add(e);
        }

        for (Exception e : exceptions) {
            System.out.println(e);
        }
    }
}
