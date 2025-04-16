package Laborator6;
public class DoubleCalculator extends ACalculator {

    public DoubleCalculator(double state) {
        super(state);
    }

    public DoubleCalculator add(double a) {
        this.state = (double)this.state + a;
        return this;
    }

    public DoubleCalculator substract(double a) {
        this.state = (double)this.state - a;
        return this;
    }

    public DoubleCalculator multiply(double a) {
        this.state = (double)this.state * a;
        return this;
    }

    public DoubleCalculator divide(double a) {
        this.state = (double)this.state / a;
        return this;
    }

    @Override
    protected void init() {
        this.state = 0.0;
    }
}