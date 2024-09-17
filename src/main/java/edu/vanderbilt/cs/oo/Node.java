package edu.vanderbilt.cs.oo;

import java.util.List;

/**
 * @ToDo
 *
 * This is an interface for a Node in a binary tree.
 *
 * The tree should support the following operations, which are
 * described in detail below.
 *
 * 1. Insert - numbers can be inserted into the tree
 * 2. Contains - checks if any nodes, including the node it
 *          is called on, contains the specified number
 * 3. Sum - returns the sum of numbers including and beneath
 *          the node it is called on
 * 4. Average - returns the average of the numbers, including
 *          and beneath the node it is called on
 * 5. Size - returns the number of nodes including and beneath
 *          the node it is called on
 *
 * @ToDo Step 1: NullNode
 *
 * If you created a NullNode in a prior exercise, reuse and modify
 * it to support these operations. If you did not create one, then
 * do so now to implement this interface.
 *
 * NullNode's behavior on these operations should be as follows:
 *
 * 1. Insert   - A call to insert() on a NullNode should create a
 *               new CompositeNode with the specified value and should
 *               cause the NullNode to ask its parent to replace the
 *               NullNode with the newly created CompositeNode that
 *               contains the value. The NullNode will be "replacing itself on demand"
 *               to create a CompositeNode and add it to the tree.
 * 2. Contains - A NullNode's contains() method always returns false.
 * 3. Sum      - A NullNode's sum() is always 0.
 * 4. Average  - A NullNode's average() is always 0.
 * 5. Size     - A NullNode's size() is always 0.
 * 6. Replace  - A NullNode's replace() method does nothing.
 * 7. Children - A NullNode's getLeftChild() and getRightChild() methods always
 *               return null.
 * 8. Parent   - A NullNode's getParent() method returns the value that the parent
 *               member variable is currently set to.
 * 9. Value    - setValue() in NullNode should throw a java.lang.UnsupportedOperationException
 *               if it is invoked and getValue() should always return 0.0
 *
 *  If you created a CompositeNode in a prior exercise, reuse and modify
 *  it to support these operations. If you did not create one, then
 *  do so now to implement this interface.
 *
 * @ToDo Step 2: Composite Node
 *
 * CompositeNode's behavior should be as follows:
 *
 * 1. Insert   - see the method documentation below
 * 2. Contains - see the method documentation below
 * 3. Average  - see the method documentation below
 * 4. Size     - see the method documentation below
 * 6. Replace  - see the method documentation below
 * 7. Children - A CompositeNodes's getLeftChild() and getRightChild() methods return
 *               the corresponding member variables that should be initialized to
 *               instances of NullNode on construction
 * 8. Parent   - A CompositeNode's getParent() method returns the value that the parent
 *               member variable is currently set to.
 * 9. Value    - The CompositeNode should contain a value member variable that is
 *               read/written by the getValue() / setValue() methods
 *
 * @ToDo Step 3: Update NodeFactory
 *
 * See the NodeFactory class for details.
 *
 * @ToDo Step 4: Pass the Tests
 *
 * Throughout your work, you should run the tests to make sure that you
 * are implementing everything correctly. When you can pass all of the
 * tests, turn the assignment in!
 *
 * Whenever you find ambiguous requirements, see the NodeTest for the
 * concrete expectation of the behavior. If there is no test to cover
 * the expected behavior, you are free to make whatever assumptions you
 * would like.
 *
 */
public interface Node {


    /**
     * Returns the sum of the values stored in this node and
     * all of its children.
     *
     * If this node had the value 10 and its left child was 5 and right
     * child 7, then sum() would return 22.
     *
     * @return
     */
    public Double sum();

    /**
     * Returns the average of the values stored in this node and
     * all of its children.
     *
     *
     * If this node had the value 10 and its left child was 5 and right
     * child 7, then average() would return 22/3.
     *
     * @return
     */
    public Double average();

    /**
     * Returns the total number of nodes, including this one,
     * stored from this point in the tree and below.
     *
     * @return
     */
    public int size();

    /**
     *
     * Inserts a value into the binary tree. If the value is greater
     * than the value stored in this node, insert it into the rightChild.
     * If the value is less than or equal to the value stored in this node,
     * insert it into the leftChild.
     *
     * @param d
     */
    public void insert(Double d);

    /**
     * Returns true if this node or any of its children contain the
     * specified value.
     *
     * @param value
     * @return
     */
    public boolean contains(Double value);

    /**
     * Sets the value that is stored in the current node
     *
     * @param d
     */
    public void setValue(Double d);

    /**
     * Returns the value that is stored in the current node
     *
     * @return
     */
    public Double getValue();

    /**
     * Sets the parent of the current node
     *
     * @param n
     */
    public void setParent(Node n);

    /**
     * Returns the parent of the current node
     *
     */
    public Node getParent();

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
    public void replace(Node child, Node replacement);

    /**
     * Returns the left child of the current node
     *
     * @return
     */
    public Node getLeftChild();

    /**
     * Returns the right child of the current node
     *
     * @return
     */
    public Node getRightChild();

}
