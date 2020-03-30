package allhomework.homework8;

public class Child extends Human implements CanLearn{
    private String subject;
    private int skill;
    private boolean goesToSchool;



    public Child(String name, int age, String subject, int skill) {
        super(name, age);
        setSubject(subject);
        setSkill(skill);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }



    public boolean isGoesToSchool() {
        return goesToSchool;
    }

    public void setGoesToSchool(boolean goesToSchool) {
        this.goesToSchool = goesToSchool;
    }


    @Override
    public int learn() {
        return skill++;
    }
}
