package ro.ulbs.paradigme.lab2;

public class Form {
    private String color;
    private static int counter = 0; // Contor static pentru a urmări instanțele create

    public Form() {
        this.color = "white"; // inițializare culoare cu white, constructor fără parametri
        counter++; // Incrementare contor pentru fiecare instanță creată
    }

    public Form(String color) {
        this.color = color; // constructor cu parametri
        counter++; // Incrementare contor pentru fiecare instanță creată
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public float getArea() {
        return 0;
    }

    // Getter static pentru contor
    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "Această formă are culoarea " + color;
    }
}