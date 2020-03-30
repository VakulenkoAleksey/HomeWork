package allhomework.homework8;

public class Teacher extends Human implements CanTeach {
    private String taughtSubject;
    private boolean worksAtSchool;

    public Teacher(String name, int age, String taughtSubject) {
        super(name, age);
        setTaughtSubject(taughtSubject);
    }

    @Override
    public void setAge(int age) {
        if (age > 25) this.age = age;
    }

    public String getTaughtSubject() {
        return taughtSubject;
    }

    public void setTaughtSubject(String taughtSubject) {
        this.taughtSubject = taughtSubject;
    }



    public boolean isWorksAtSchool() {
        return worksAtSchool;
    }

    public void setWorksAtSchool(boolean worksAtSchool) {
        this.worksAtSchool = worksAtSchool;
    }


    @Override
    public void teach(Child child) {
        child.learn();
    }

}

