package allhomework.homework8;



import java.util.Arrays;

public class School {
    private final String title;
    private Director director;
    Teacher[] teachers = new Teacher[10];
    Child[] children = new Child[10];

    public School(String title, Director director) {
        this.title = title;
        setDirector(director);
    }

    public String getTitle() {
        return title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher teacher) {
        if (!(teacher.isWorksAtSchool())) {
            for (int i = 0; i < teachers.length; i++) {
                if (teachers[i] == (null)) {
                    teachers[i] = teacher;
                    teacher.setWorksAtSchool(true);
                    return;
                }
            }
            System.out.println("Учителя не требуютя");
        }
    }

    public String getChildren() {
        return Arrays.toString(children);
    }

    public void setChildren(Child child) {
        if (!(child.isGoesToSchool())) {
            for (int i = 0; i < children.length; i++) {
                if (children[i] == null) {
                    children[i] = child;
                    child.setGoesToSchool(true);
                    return;
                }
            }
            System.out.println("В школе максимальное количестово учеников");
        }
    }

    public void schoolDay() {
        director.startOfClasses();
        for (Teacher teacher : teachers) {
            if (teacher != null) {
                for (Child child : children) {
                    if (child != null) {
                        if (teacher.getTaughtSubject().equalsIgnoreCase(child.getSubject())) {
                            teacher.teach(child);
                            System.out.println(teacher.getName() + " учит " + child.getName() +
                                    " уроку " + teacher.getTaughtSubject());
                        }
                    }
                }
            }
        }
        director.finishOfClasses();
    }
}
