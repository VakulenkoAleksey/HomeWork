package allhomework.homework16.task1;

 class Car {
    private String modelName;
    private int modelYear;
    private String color;

    public Car(String modelName, int modelYear, String color) {
        setModelName(modelName);
        setModelYear(modelYear);
        setColor(color);
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "modelName='" + modelName + '\'' +
                ", modelYear=" + modelYear +
                ", color='" + color + '\'' +
                '}';
    }
}
