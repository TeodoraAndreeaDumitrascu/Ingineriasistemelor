package ro.ulbs.paradigme.lab2.simplechained;
import ro.ulbs.paradigme.lab2.api.Node;
public class SimpleChainedNode implements Node {
    private int value;
    private SimpleChainedNode nextNode;

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    public void setNextNode(SimpleChainedNode nextNode) {
        this.nextNode = nextNode;
    }

    public SimpleChainedNode getNextNode() {
        return nextNode;
    }
}
