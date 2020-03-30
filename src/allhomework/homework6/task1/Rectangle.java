package allhomework.homework6.task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Rectangle {
private double a;
private double b;
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

public Rectangle(double a, double b){
    if (a != b) {
        setA(a);
        setB(b);
    }else {
        System.out.println();
    }
}

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}
