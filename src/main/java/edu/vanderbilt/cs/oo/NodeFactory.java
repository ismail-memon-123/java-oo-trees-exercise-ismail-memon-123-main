package edu.vanderbilt.cs.oo;

public class NodeFactory {

    public Node newNode(Double v){
        return newCompositeNode(v);
    }

    /**
     * @ToDo
     *
     * Update this to return an instance of your CompositeNode
     *
     * @return
     */
    public Node newCompositeNode(Double v){
        CompositeNode cd = new CompositeNode();
        cd.setValue(v);
        return cd;
    }

    /**
     * @ToDo
     *
     * Update this to return an instance of your NullNode
     *
     * @return
     */
    public Node newNullNode(){
        return new NullNode();
    }


}
