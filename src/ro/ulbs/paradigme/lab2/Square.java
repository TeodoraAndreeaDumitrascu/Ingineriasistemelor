package ro.ulbs.paradigme.lab2;

public class Square extends Form {
    private float side;

    // Constructor without parameters
    public Square() {
        super(); // Call the parent constructor
        this.side = 0;
    }

    // Constructor with parameters
    public Square(float side, String color) {
        super(color); // Reuse parent constructor code
        this.side = side;
    }

    // Override getArea method to calculate square area
    @Override
    public float getArea() {
        return side * side;
    }

    // Override toString method using parent's implementation
    @Override
    public String toString() {
        return super.toString() + ", side = " + side;
    }
}