package ro.ulbs.paradigme.lab2;

public class Form {
    private String color;

    public Form() {
        this.color="white"; // initializare culoare cu white
    }
    public Form(String color){
        this.color=color;
    }
    public void setColor(String color){
        this.color=color;
    }

    public String getColor() {
        return color;
    }
    public float getArea(){
        return 0;
    }
    @Override
    public String toString(){
        return "This form has the color" + color;
    }
}


