package allhomework.homeworkenum;

public class User {
    String fulName;
    Position position;

    public User(String fulName, String position) {
        setFulName(fulName);
        setPosition(position);
    }

    public User(String fulName, Position position){
        setFulName(fulName);
        setPosition(position);
    }


    public String getFulName() {
        return fulName;
    }

    private void setFulName(String fulName) {
        this.fulName = fulName;
    }


    public Position getPosition() {
        return position;
    }

    private void setPosition(Position position){
        this.position = position;
    }



    public void setPosition(String position) {
        if (position.toLowerCase().startsWith("д")){
            this.position = Position.DIRECTOR;
        }else if (position.toLowerCase().startsWith("м")){
            this.position = Position.MANAGER;
        }else if (position.toLowerCase().startsWith("п")){
            this.position = Position.SELLER;
        }else if (position.toLowerCase().startsWith("к")){
            this.position = Position.COURIER;
        }
    }

    @Override
    public String toString() {
        return "Сотрудник:\n" +
                "ФИО: " + fulName + "\n" +
                "Должность: " + position.getName() + "\n"+
                "Заработная плата/руб: " + position.getSalary() + "\n";
    }
}




