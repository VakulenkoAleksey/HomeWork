package allhomework.homeworkenum;

public class User {
    String fulName;
    Position position;

    public User(String fulName, Position position) {
        setFulName(fulName);
        setPosition(position);
    }

    public String getFulName() {
        return fulName;
    }

    public void setFulName(String fulName) {
        this.fulName = fulName;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Сотрудник:\n" +
                "ФИО: " + fulName + "\n" +
                "Должность: " + position.getName() + "\n"+
                "Заработная плата/руб: " + position.getSalary() + "\n";
    }
}




