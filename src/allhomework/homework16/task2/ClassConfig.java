package allhomework.homework16.task2;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassConfig {
    //в качестве параметров можно использовать строки, примитивы, enum
    // обязательно указать при использовании аннотации
    String prefix();
    long version() default 1;
}
