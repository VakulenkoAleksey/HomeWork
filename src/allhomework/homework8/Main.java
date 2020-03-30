package allhomework.homework8;

import java.util.Arrays;

import static allhomework.homework8.SchoolSubject.*;

public class Main {
    public static void main(String[] args) {
        Director director = new Director("Директор", (int) (25 + Math.random() * 30));
        School school = new School("School #21", director);

        for (int i = 0; i < 10; i++) {
            school.setTeachers(new Teacher("Учитель" + i, (int) (25 + Math.random() * 30), randomSubject()));
            school.setChildren(new Child("ученик"+i, (int) (7 + (Math.random() * 10)),
                                                randomSubject(), (int) (Math.random() * 10)));
        }
        school.schoolDay();
    }
}
