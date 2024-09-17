package edu.vanderbilt.cs.oo;


public class NullNode implements Node {
    private Node parent; 
 
    public NullNode() {
        parent = null;
    }
    public void setValue(Double d) {
        throw new UnsupportedOperationException();
    }
     public Double getValue() {
         return 0.0;
     }
     public void setParent(Node n) {
         this.parent = n;
     }
     public Node getParent() {
         return this.parent;
     }
     public void replace(Node child, Node replacement) {
         int i = 1;
     }
     public Node getLeftChild() {
         return null;
     }
     public Node getRightChild() {
         return null;
     }

    public Double sum() {
        return 0.0;
    }

    public Double average() {
        return 0.0;
    }

    public int size() {
        return 0;
    }

    public void insert(Double d) {
        CompositeNode cnode = new CompositeNode();
        cnode.setValue(d);
        // i think i can use replace method bec it will obviously not be null node.
        this.parent.replace(this, cnode);
    }

    public boolean contains(Double value) {
        return false;
    }

 }