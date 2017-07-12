package chapter3.variantb.triangle.entity;
import static java.lang.Math.*;
/**
 *
 * @author Sukhocheva Maryana
 */
public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle() {
        this(0);
    }

    public Triangle(double a) {
        this(a, a, a);
    }

    public Triangle(double a, double b, double c) {
        checkPositive(a, b, c);
        isTriangle(a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private void isTriangle(double a, double b, double c) {
        if ((a > (b + c)) || (b > (a + c)) || (c > (a + b))) {
            throw new IllegalArgumentException("Invalid triangle");
        }
    }

    private void checkPositive(double... num) {
        for (double n : num) {
            if (n < 0) {
                throw new IllegalArgumentException(String.valueOf(n) + " is not a positive number");
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Triangle{");
        sb.append("a=").append(a);
        sb.append(", b=").append(b);
        sb.append(", c=").append(c);
        sb.append('}');
        return sb.toString();
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getArea() {
        double p = (a + b + c) / 2;
        return sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double getPerimeter() {
        return a + b + c;
    }
}
