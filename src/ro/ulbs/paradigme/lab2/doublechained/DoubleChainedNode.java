package ro.ulbs.paradigme.lab2.doublechained;
import ro.ulbs.paradigme.lab2.api.Node;
public class DoubleChainedNode implements Node {
    private int value;
    private DoubleChainedNode nextNode;
    private DoubleChainedNode prevNode;

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    public void setNextNode(DoubleChainedNode nextNode) {
        this.nextNode = nextNode;
    }

    public DoubleChainedNode getNextNode() {
        return nextNode;
    }

    public void setPrevNode(DoubleChainedNode prevNode) {
        this.prevNode = prevNode;
    }

    public DoubleChainedNode getPrevNode() {
        return prevNode;
    }
}
