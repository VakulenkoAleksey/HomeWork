package allhomework.homework16.task1;


// 1. написать рефлексивный статический static toString(Object o)
// вывести информацию по полям объекта, используя рефлексию:
// название поля: значение поля
// примитивы / строки
// age: 67
// login: qwe
// User user
// user : @hashCode
// int[] data
// data: @hashCode

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;


public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Garage> garageClass = Garage.class;

        Constructor<Garage> constructor = garageClass.getDeclaredConstructor(String.class);
        Garage reflectGarage = constructor.newInstance("Гараж №1");
        toString(reflectGarage);
    }


    public static void toString(Object o) throws IllegalAccessException {
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getType().isArray()) {
                for (int i = 0; i < Array.getLength(field.get(o)); i++) { //Array.getLength(field.get(o))-длина массива
                    if (Array.get(field.get(o), i) != null) {
                        toString(Array.get(field.get(o), i));//передаем элемент массива field(объект) с индексом i
                        System.out.println("-------------");
                    }
                }
            } else {
                System.out.println(field.getName() + ": " + field.get(o).toString());
            }
        }
    }
}