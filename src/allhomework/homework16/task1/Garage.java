package allhomework.homework16.task1;

import allhomework.homework16.task1.Car;

import java.util.Arrays;

class Garage {
    private String name;
    private Car[] cars = new Car[5];

    public Garage(String name) {
        setName(name);
        createCar();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car car) {
        for (int i = 0; i < 5; i++) {
            if (cars[i] == null) {
                cars[i] = car;
                break;
            }
        }
    }

    private void createCar() {
        setCars(new Car("Toyota Supra", 2000, "Red"));
        setCars(new Car("Toyota Crown", 2019, "White"));
        setCars(new Car("Nissan Skyline", 1999, "Blue"));
        setCars(new Car("Lexus LX570", 2019, "Black"));
        setCars(new Car("UAZ Patriot", 2019, "Orange"));
    }

    @Override
    public String toString() {
        return "Garage{" +
                "name='" + name + '\'' +
                ", cars=" + Arrays.toString(cars) +
                '}';
    }
}
