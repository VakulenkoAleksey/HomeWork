package allhomework.homework14.comparing;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparingExample {
    public static void main(String[] args) {
        // Дополнительное домашнее задание
        Car blackOpel = new Car("black", "opel", 2000);
        Car redOpel = new Car("red", "opel", 2500);
        Car yellowMazda = new Car("yellow", "mazda", 3000);
        Car greenMazda = new Car("green", "mazda", 3000);

        // Объекты добавить в ArrayList cars
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(blackOpel);
        cars.add(redOpel);
        cars.add(yellowMazda);
        cars.add(greenMazda);

        Comparator<Car> comparator = new CarBrandComparator().thenComparing(new CarPriceComparator().thenComparing(
                new CarColorComparator()));
        // отсортировать объекты в cars сначала по brand, price, color
         cars.sort(comparator);
         cars.forEach(System.out::println);
    }
}

