package allhomework.homeworkenum;

public class Store {
    private final String name;
    private User director;
    private final User[] manager = new User[2];
    private final User[] seller = new User[10];
    private final User[] courier = new User[10];

    public Store(String name, User director) {
        this.name = name;
        setDirector(director);
    }

    public String getName() {
        return name;
    }

    private void getInfoDirector() {
        System.out.println(director);
    }

    private void getInfoDirector(String name) {
        if (director.getFulName().toLowerCase().contains(name.toLowerCase())){
            System.out.println(director);
        }
    }

    private void setDirector(User director) {
            this.director = director;
    }

    private void setManager(User manager) {
        for (int i = 0; i < this.manager.length; i++) {
            if (this.manager[i] == null){
                this.manager[i] = manager;
                break;
            }
        }
    }

    private void getInfoManager() {
        for (User user: manager) {
            if (user != null){
                System.out.println(user);
            }
        }
    }

    private void getInfoSeller() {
        for (User user: seller) {
            if (user != null) {
                System.out.println(user);
            }
        }
    }

    private void getInfoCourier() {
        for (User user: courier) {
            if (user != null) {
                System.out.println(user);
            }
        }
    }

    private void getInfoManager(String name) {
        for (User user: manager) {
            if (user != null && user.getFulName().toLowerCase().contains(name.toLowerCase())){
                System.out.println(user);
            }
        }
    }

    private void getInfoSeller(String name) {
        for (User user: seller) {
            if (user != null && user.getFulName().toLowerCase().contains(name.toLowerCase())){
                System.out.println(user);
            }
        }
    }

    private void getInfoCourier(String name) {
        for (User user: courier) {
            if (user != null && user.getFulName().toLowerCase().contains(name.toLowerCase())){
                System.out.println(user);
            }
        }
    }

    private void setSeller(User seller) {
        for (int i = 0; i < this.seller.length; i++) {
            if (this.seller[i] == null){
                this.seller[i] = seller;
                break;
            }
        }
    }

    private void setCourier(User courier) {
        for (int i = 0; i < this.courier.length; i++) {
            if (this.courier[i] == null){
                this.courier[i] = courier;
                break;
            }
        }
    }

    private boolean checkManager(){
        for (User user : manager) {
            if (user == null) {
                return true;
            }
        }
        return false;
    }


    private boolean checkSeller(){
        for (User user : seller) {
            if (user == null) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCourier(){
        for (User user : courier) {
            if (user == null) {
                return true;
            }
        }
        return false;
    }
    private String checkCase(String fullName){ //проверяет регистр первой буквы в каждом слове
        StringBuilder stringBuilder = new StringBuilder();
        fullName = fullName.toLowerCase();
        String[] s = fullName.split("\\s+|-");
        for (int i = 0; i < s.length; i++) {
            String s1 = s[i].substring(0, 1).toUpperCase();
            String s2 = s[i].substring(1);
            s[i] = s1+s2;
        }
        if (s.length == 3){
            stringBuilder.append(s[0]).append(" ").append(s[1]).append(" ").append(s[2]);
        }else {
            stringBuilder.append(s[0]).append("-").append(s[1]).append(" ").append(s[2]).append(" ").append(s[3]);
        }
        return stringBuilder.toString();
    }

    public void newStaff(String fullName, String position){
        if (fullName.matches("^[А-я\\-А-я]+\\s[А-я]+\\s[А-я]+?$")) {
            addStaff(new User(checkCase(fullName), position));
        }else {
            System.out.println(fullName+ " не корректно введено ФИО\n");
        }
    }

    public void newStaff(String fullName, Position position){
        if (fullName.matches("^[А-я\\-А-я]+\\s[А-я]+\\s[А-я]+?$")) {
            addStaff(new User(checkCase(fullName), position));
        }else {
            System.out.println(fullName+ " не корректно введено ФИО\n");
        }
    }

    public void getAllInfoStaff () {
        System.out.println("Информация о всех сотридниках:\n");
        getInfoDirector();
        getInfoManager();
        getInfoSeller();
        getInfoCourier();
        System.out.println("*************************************\n");
    }

    public void getInfoStaff(String name){
        System.out.println("Информация о сотриднике:\n");
        getInfoDirector(name);
        getInfoManager(name);
        getInfoSeller(name);
        getInfoCourier(name);
        System.out.println("*************************************\n");
    }

    public void getInfoStaff(Position position) {
        System.out.println("Сотрудник(и) с должностью " + position.getName().toLowerCase() + ":\n");
        if (position.equals(Position.DIRECTOR)){
            getInfoDirector();
        }else if (position.equals(Position.MANAGER)){
            getInfoManager();
        }else if (position.equals(Position.SELLER)){
            getInfoSeller();
        }else if (position.equals(Position.COURIER)){
            getInfoCourier();
        }
        System.out.println("*************************************\n");
    }

    private void addStaff(User... user){
        for (User us: user) {
            if (us.position.equals(Position.MANAGER) && checkManager()) {
                setManager(us);
            } else if (us.position.equals(Position.SELLER) && checkSeller()) {
                setSeller(us);
            } else if (us.position.equals(Position.COURIER) && checkCourier()) {
                setCourier(us);
            }else {
                System.out.println("Извените, но на должность \""+us.position.getName()+"\" сотрудник не требуется.\n");
            }
        }
    }
}

enum Position {
    DIRECTOR( "Директор",150000),
    MANAGER("Менеджер", 100000),
    SELLER("Продавец", 70000),
    COURIER("Курьер", 40000);
    private final int salary;
    private final String name;

    Position(String name, int salary) {
        this.salary = salary;
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}
