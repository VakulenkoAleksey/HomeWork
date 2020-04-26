package allhomework.homework14.comparing;


import java.util.Comparator;

public class Car {
    private String color;
    private String brand;
    private int price;

    public Car(String color, String brand, int price) {
        this.color = color;
        this.brand = brand;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cars: " +
                "brand: " + brand +
                ", price = " + price +
                ", color: " + color + ".";
    }
}

class CarBrandComparator implements Comparator<Car>{

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getBrand().compareTo(o2.getBrand());
    }
}

class CarColorComparator implements Comparator<Car>{
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getColor().compareTo(o2.getColor());
    }
}

class CarPriceComparator implements Comparator<Car>{
    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }
}
