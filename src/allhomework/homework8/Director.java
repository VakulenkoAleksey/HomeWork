package allhomework.homework8;

import org.w3c.dom.ls.LSOutput;

public class Director extends Human {

    public Director(String name, int age) {
        super(name, age);
    }

    public void startOfClasses(){
        System.out.println("Школьный день начался.");
    }
    public void finishOfClasses(){
        System.out.println("Школьный день окончен.");
    }
}
