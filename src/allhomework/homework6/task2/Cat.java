package allhomework.homework6.task2;

public class Cat {
    String name;
    int weight;
    int age;
    String color;
    String ownerAddress;
    int heath;
    int power;

    public Cat(){}

    public Cat(String name, String color){
        setName(name);
        setColor(color);
    }

    public Cat(int heath, String ownerAddress, int power){
        setHeath(heath);
        setOwnerAddress(ownerAddress);
        setPower(power);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isEmpty())
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if(weight > 0) {
            this.weight = weight;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0) {
            this.age = age;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public int getHeath() {
        return heath;
    }

    public void setHeath(int heath) {
        this.heath = heath;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void printInfo(){
        System.out.println("Нашего кота зовут " + getName() + ";");


    }

    public void fightCat(Cat enemyCat){
        heath -= enemyCat.getPower();
    }
}
