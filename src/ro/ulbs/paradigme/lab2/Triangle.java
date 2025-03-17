package ro.ulbs.paradigme.lab2;
public class Triangle extends Form {
    private float height;
    private float base;

    // Constructor without parameters
    public Triangle() {
        super(); // Call the parent constructor
        this.height = 0;
        this.base = 0;
    }

    // Constructor with parameters
    public Triangle(float height, float base, String color) {
        super(color); // Reuse parent constructor code
        this.height = height;
        this.base = base;
    }

    // Override getArea method to calculate triangle area
    @Override
    public float getArea() {
        return (base * height) / 2;
    }

    // Override toString method using parent's implementation
    @Override
    public String toString() {
        return super.toString() + ", base = " + base + ", height = " + height;
    }

    // Implement equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Triangle triangle = (Triangle) obj;

        if (Float.compare(triangle.height, height) != 0) return false;
        if (Float.compare(triangle.base, base) != 0) return false;
        return getColor().equals(triangle.getColor());
    }
}