package allhomework.homework16.task2;

// 2. если класс аннотирован аннотацией ConfigClass,
// создать объект данного класса (использовать рефлексию!)
// если поле отмечено аннотацией @Required - установить значение
// данного поля (значение любое!)
// значение поля установить через сеттер!!!
// stringData / setStringData
// field.getName()
// field.getType()
// у созданного объекта вызвать метод public String toString(),
// используя рефлексию

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

@ClassConfig(prefix = "test", version = 22)
public class TestAnnotation {
    @Required
    private String stringData;

    public String getStringData() {
        return stringData;
    }

    public void setStringData(String stringData) {
        this.stringData = stringData;
    }

    @Override
    public String toString() {
        return "TestAnnotation{" +
                "stringData='" + stringData + '\'' +
                '}';
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<TestAnnotation> testClass = TestAnnotation.class;
        Constructor<TestAnnotation> constructor = testClass.getDeclaredConstructor();

        if (testClass.isAnnotationPresent(ClassConfig.class)) {
            TestAnnotation reflectTestAnnotation = constructor.newInstance();
            Field[] fields = testClass.getDeclaredFields();

            for (Field field : fields) {
                Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
                System.out.println(Arrays.toString(fieldAnnotations));

                if (field.isAnnotationPresent(Required.class)) {
                    String methodName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                    Method method = null;
                    if (Integer.TYPE.equals(field.getType())) {
                        method = testClass.getDeclaredMethod(methodName, Integer.TYPE);
                        method.setAccessible(true);
                        method.invoke(reflectTestAnnotation, 15);

                    } else if (Double.TYPE.equals(field.getType())) {
                        method = testClass.getDeclaredMethod(methodName, Double.TYPE);
                        method.setAccessible(true);
                        method.invoke(reflectTestAnnotation, 15.00);

                    } else if (Character.TYPE.equals(field.getType())) {
                        method = testClass.getDeclaredMethod(methodName, Character.TYPE);
                        method.setAccessible(true);
                        method.invoke(reflectTestAnnotation, 'C');

                    } else if (Boolean.TYPE.equals(field.getType())) {
                        method = testClass.getDeclaredMethod(methodName, Boolean.TYPE);
                        method.setAccessible(true);
                        method.invoke(reflectTestAnnotation, true);

                    } else if (String.class.equals(field.getType())) {
                        method = testClass.getDeclaredMethod(methodName, String.class);
                        method.setAccessible(true);
                        method.invoke(reflectTestAnnotation, "Рефлексия");
                    }
                }
            }
            System.out.println(reflectTestAnnotation);
        }else {
            System.out.println("Класса с аннотацией ClassConfig не найдено!");
        }
    }
}
