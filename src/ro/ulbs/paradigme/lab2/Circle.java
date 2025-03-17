package ro.ulbs.paradigme.lab2;
public class Circle extends Form {
    private float radius;

    // Constructor without parameters
    public Circle() {
        super(); // Call the parent constructor
        this.radius = 0;
    }

    // Constructor with parameters
    public Circle(float radius, String color) {
        super(color); // Reuse parent constructor code
        this.radius = radius;
    }

    // Override getArea method to calculate circle area
    @Override
    public float getArea() {
        return (float) (Math.PI * radius * radius);
    }

    // Override toString method using parent's implementation
    @Override
    public String toString() {
        return super.toString() + ", radius = " + radius;
    }
}