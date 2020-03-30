package allhomework.homework6.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Triangle triangle = new Triangle(6,14,7);
        System.out.println(triangle.perimeterTriangle());
        System.out.println(triangle.areaOfTriangle());

        System.out.println("***********");

        Circle circle = new Circle(6);
        System.out.println(circle.circumference());
        System.out.println(circle.surface());



    }
}
