package Laborator6;

public class NewIntCalculator extends  ACalculator {

    public NewIntCalculator(int state) {
        super(state);
    }
    public NewIntCalculator add(int a){
        this.state=(int)this.state + a;
        return this;
    }

    public NewIntCalculator substract(int a){
        this.state=(int)this.state - a;
        return this;
    }

    public NewIntCalculator multiply(int a){
        this.state=(int)this.state * a;
        return this;
    }

    public NewIntCalculator divide(int a){
        this.state=(int)this.state / a;
        return this;
    }

    @Override
    protected void init() {
        this.state=0;

    }
}
