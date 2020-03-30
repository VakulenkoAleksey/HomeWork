package allhomework.homework6.task1;

public class Circle {
    private double r;

    public Circle(double r) {
        setR(r);
    }

    public void setR(double r) {
        if (r > 0) {
            this.r = r;
        }
    }

    public double circumference() {
        return 2 * Math.PI * this.r;
    }

    public double surface() {
        return Math.PI * r * r;
    }
}
