package allhomework.homework6.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Triangle {
    private double a;
    private double b;
    private double c;


    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public double perimeterTriangle() {
        return a + b + c;
    }

    public double areaOfTriangle() {
        return (double) 1 / 2 * (a * heightTriangle());
    }

    public Triangle(double a, double b, double c) throws IOException {
        this.a = a;
        this.b = b;
        this.c = c;
        while (true) {
            if (checkTriangle(this.a, this.b, this.c)) {
                break;
            } else {
                System.out.println("Введите сторону А");
                this.a = Integer.parseInt(reader.readLine());
                System.out.println("Введите сторону B");
                this.b = Integer.parseInt(reader.readLine());
                System.out.println("Введите сторону C");
                this.c = Integer.parseInt(reader.readLine());
            }
        }
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    private boolean checkTriangle(double a, double b, double c) throws IOException {
        if (a + b > c && b + c > a && a + c > b) {
            System.out.println("Заданы новые длины сторон треугольника.\n" +
                    "A = " + a + "; B = " + b + "; C = " + c);
            return true;
        } else {
            System.out.println("Такого треугольника не существует! \n" +
                    "Введите стороны сторон так, что бы сумма длин 2-х сторон превышала длину третьей! ");
            return false;
        }
    }


    private double heightTriangle() {
        double s = perimeterTriangle() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
