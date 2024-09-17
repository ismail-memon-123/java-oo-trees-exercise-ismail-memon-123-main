package edu.vanderbilt.cs.oo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    private NodeFactory factory = new NodeFactory();


    @Test
    public void testCompositeNodeCreation(){
        assertNotNull( factory.newCompositeNode(0.0) );
        assertEquals("edu.vanderbilt.cs.oo.CompositeNode",
                factory.newCompositeNode(0.0).getClass().getName());
        assertEquals(0.0, factory.newCompositeNode(0.0).getValue());
        assertEquals(10.0, factory.newCompositeNode(10.0).getValue());
        assertEquals("edu.vanderbilt.cs.oo.NullNode",
                factory.newCompositeNode(0.0).getLeftChild().getClass().getName());
        assertEquals("edu.vanderbilt.cs.oo.NullNode",
                factory.newCompositeNode(0.0).getRightChild().getClass().getName());
        assertEquals(null, factory.newCompositeNode(0.0).getParent());
    }

    @Test
    public void testCompositeNodeSetValue(){
        Node node = factory.newCompositeNode(0.0);
        assertEquals(0.0, node.getValue());
        Double v = Math.random() * 100;
        node.setValue(v);
        assertEquals(v, node.getValue(), 0.0001);

        v = Math.random() * 100;
        node.setValue(v);
        assertEquals(v, node.getValue(), 0.0001);

        v = Math.random() * 100;
        node.setValue(v);
        assertEquals(v, node.getValue(), 0.0001);
    }

    @Test
    public void testCompositeNodeReplace(){
        Node node = factory.newCompositeNode(0.0);
        Node leftChild = node.getLeftChild();
        Node rightChild = node.getRightChild();

        // Test leftChild updates
        Node newLeftChild = factory.newCompositeNode(0.1);
        node.replace(leftChild, newLeftChild);
        assertEquals(newLeftChild, node.getLeftChild());
        assertEquals(node, newLeftChild.getParent());

        // Test rightChild updates
        Node newRightChild = factory.newCompositeNode(0.01);
        node.replace(rightChild, newRightChild);
        assertEquals(newRightChild, node.getRightChild());
        assertEquals(node, newRightChild.getParent());

        // Shouldn't have changed leftChild
        assertEquals(newRightChild, node.getRightChild());
        assertEquals(newLeftChild, node.getLeftChild());

        // Shouldn't update if the child argument is wrong
        node.replace(rightChild, rightChild);
        node.replace(leftChild, leftChild);
        assertEquals(newRightChild, node.getRightChild());
        assertEquals(newLeftChild, node.getLeftChild());

        // Should be able to go back to the start state
        node.replace(newRightChild, rightChild);
        node.replace(newLeftChild, leftChild);
        assertEquals(rightChild, node.getRightChild());
        assertEquals(leftChild, node.getLeftChild());
    }

    @Test
    public void testNullNodeCreation(){
        assertNotNull( factory.newNullNode() );
        assertEquals("edu.vanderbilt.cs.oo.NullNode",
                factory.newNullNode().getClass().getName());
        assertEquals(0.0, factory.newNullNode().getValue());
        assertEquals(null,
                factory.newNullNode().getLeftChild());
        assertEquals(null,
                factory.newNullNode().getRightChild());
        assertEquals(null, factory.newNullNode().getParent());
    }

    @Test
    public void testNullNodeGetSetValue(){
        Node node = factory.newNullNode();
        assertEquals(0.0, node.getValue());

        try{
            node.setValue(10.0);
            fail("NullNode should not allow its value to be set and should throw " +
                    "a java.lang.UnsupportedOperation exception.");
        }catch (UnsupportedOperationException ex){
            // Good, the correct exception was thrown, let's make sure nothing was set
            assertEquals(0.0, node.getValue());
            assertEquals(null, node.getParent());
            assertEquals(null, node.getLeftChild());
            assertEquals(null, node.getRightChild());
        }
    }

    @Test
    public void testNullNodeReplace(){
        Node node = factory.newNullNode();
        Node leftChild = node.getLeftChild();
        Node rightChild = node.getRightChild();

        // Test leftChild updates
        Node newLeftChild = factory.newNullNode();
        node.replace(leftChild, newLeftChild);
        assertEquals(null, node.getLeftChild());
        assertEquals(null, newLeftChild.getParent());

        // Test rightChild updates
        Node newRightChild = factory.newCompositeNode(0.01);
        node.replace(rightChild, newRightChild);
        assertEquals(null, node.getRightChild());
        assertEquals(null, newRightChild.getParent());

        // Shouldn't have changed leftChild
        assertEquals(null, node.getRightChild());
        assertEquals(null, node.getLeftChild());

        // Shouldn't update if the child argument is wrong
        node.replace(rightChild, rightChild);
        node.replace(leftChild, leftChild);
        assertEquals(null, node.getRightChild());
        assertEquals(null, node.getLeftChild());

        // Should be able to go back to the start state
        node.replace(newRightChild, rightChild);
        node.replace(newLeftChild, leftChild);
        assertEquals(null, node.getRightChild());
        assertEquals(null, node.getLeftChild());
    }


    @Test
    public void testNodeCreation(){
        assertNotNull( factory.newNode(0.0) );
    }

    @Test
    public void testInsertContains(){
        int total = 100;

        Node root = factory.newNode(0.0 + total / 2);

        for(int i = 0; i < total; i++){
            root.insert(0.0 + i);
            assertTrue(root.contains(0.0 + i));
        }

        for(int i = 0; i < total; i++){
            assertTrue(root.contains(0.0 + i));
        }
    }

    @Test
    public void testSum(){
        int total = 1 + (int)Math.rint(Math.random() * 100);
        double midpoint = 50;
        double sum = midpoint;

        Node root = factory.newNode(midpoint);

        for(int i = 0; i < total; i++){
            double v = Math.rint(Math.random() * 100);
            sum += v;
            root.insert(v);
        }

        assertEquals(sum, root.sum(), 0.1);
        assertEquals(sum / (total + 1), root.average(), 0.1);
    }

    @Test
    public void testSize(){
        int total = 1 + (int)Math.rint(Math.random() * 100);
        double midpoint = 50;

        Node root = factory.newNode(midpoint);

        for(int i = 0; i < total; i++){
            double v = Math.rint(Math.random() * 100);
            root.insert(v);
        }

        assertEquals(total + 1, root.size());
    }


}
