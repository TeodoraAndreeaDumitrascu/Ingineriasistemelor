package Laborator6;

public abstract class ACalculator {
    public Object state;

    public ACalculator(Object state){
        this.state=state;
    }
    public Object result(){
        return state;
    }
    public  ACalculator clear(){
        this.state=0;
    return this;
    }
    protected  abstract void init();
}
