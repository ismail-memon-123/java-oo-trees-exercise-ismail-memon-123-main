package edu.vanderbilt.cs.oo;

public class CompositeNode implements Node {
    
    private Double value;
    private Node parent;
    private Node left;
    private Node right;
    
    public CompositeNode() {
        this.value = 0.0;
        this.parent = null;
        this.left = new NullNode();
        this.right = new NullNode();
    }

    private Double sum_helper(Node n) {
        if (n instanceof NullNode) {
            return 0.0;
        }
        return n.getValue() + sum_helper(n.getLeftChild()) + sum_helper(n.getRightChild());
    }

    public Double sum() {
        return sum_helper(this);
    }

    public Double average() {
        return (sum()/size());
    }

    private int size_helper(Node n) {
        if (n instanceof NullNode) {
            return 0;
        }
        // 1 for current node.
        return 1 + size_helper(n.getLeftChild()) + size_helper(n.getRightChild());
    }
    public int size() {
        return size_helper(this);
    }

    /**
     *
     * Inserts a value into the binary tree. If the value is greater
     * than the value stored in this node, insert it into the rightChild.
     * If the value is less than or equal to the value stored in this node,
     * insert it into the leftChild.
     *
     * @param d
     */
// FIX THIS.
    private void insert_helper(Node n, Double d) {
    	
        if (n.getValue() <= d) {
            if (n.getRightChild() instanceof NullNode) {
                CompositeNode replaced = new CompositeNode();
                replaced.setValue(d);
                n.replace(n.getRightChild(), replaced);
                
            } else {
            	
                insert_helper(n.getRightChild(), d);
            }
        } else {
            if (n.getLeftChild() instanceof NullNode) {   
                CompositeNode replaced = new CompositeNode();
                replaced.setValue(d);
                n.replace(n.getLeftChild(), replaced);
                
            } else {
                insert_helper(n.getLeftChild(), d);
            }
        }
    }

    public void insert(Double d) {
        insert_helper(this, d);
    }

    private boolean contain_helper(Node n, Double value) {
        if (n instanceof NullNode) {
            return false;
        } else if (Math.abs(n.getValue() - value) <= 0.1) {
            return true;
        } else if (n.getValue() < value) {
        	
            return contain_helper(n.getRightChild(), value);
        } else {
        	
        	return contain_helper(n.getLeftChild(), value);
        }
    }

    public boolean contains(Double value) {
        return contain_helper(this, value);
    }
    
    public void setValue(Double d) {
        this.value = d;
    }

    /**
     * Returns the value that is stored in the current node
     *
     * @return
     */
    public Double getValue() {
        return this.value;
    }
    /**
     * Sets the parent of the current node
     *
     * @param n
     */
    public void setParent(Node n) {
        this.parent = n;
    }

    /**
     * Returns the parent of the current node
     *
     */
    public Node getParent() {
        return this.parent;
    }

    /**
     * This method takes one of the current children of the node
     * as the `child` parameter and replaces the corresponding
     * child with the provided `replacement`. The method will
     * call setParent() on the replacement node to update its
     * current parent to this node.
     *
     * For example, the following code would update the rightChild
     * of a Node:
     *
     * Node parent = new CompositeNode();
     * Node newRightChild = new CompositeNode();
     * Node existingRightChild = parent.getRightChild();
     * parent.replace( existingRightChild, newRightChild);
     *
     * assertTrue( parent == newRightChild.getParent() );
     *
     * Similarly, these lines would update the leftChild:
     *
     * Node existingLeftChild = parent.getLeftChild();
     * parent.replace( existingLeftChild, new CompositeNode());
     *
     * Note: if your CompositeNode has a different constructor, this
     * code may not work, but it shows the basic idea...
     *
     * @param child
     * @param replacement
     */
    public void replace(Node child, Node replacement) {
        // compare should work since they should have same address
        if (child == this.left) {
            this.left = replacement;
            // Break parent link too
            if (replacement != null)
            replacement.setParent(this);
        } else if (child == this.right) {
            this.right = replacement;
            replacement.setParent(this);
        }
    }
    public Node getLeftChild() {
        return this.left;
    }
    public Node getRightChild() {
        return this.right;
    }


}
