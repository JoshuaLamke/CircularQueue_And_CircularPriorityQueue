/**
 * Class that extends the BinaryTree class and implements the DecisionTreeInterface.
 * @param <T> The data in the node.
 */
public class DecisionTree<T> extends BinaryTree<T> implements DecisionTreeInterface<T> {

    /**
     * Node that keeps track of where it is in the tree. 
     * @param <T> The data in the node.
     */
    BinaryNode<T> currentNode;

    /**
     * Constructor for DesicionTree that initializes everything to null.
     */
    public DecisionTree() {
        super();
        currentNode = null;
    }

    /**
     * Contructor for DecisionTree that initializes the root with data and currentNode to null.
     * @param data The data that will be in the root node.
     */
    public DecisionTree(T data) {
        super(data);
        currentNode = null;
    }

    /**
     * Evaluates whether the current node contains the final answer or not.
     * @return Boolean stating whether this node contains the final answer or not.
     */
    public boolean isAnswer() {
        return currentNode.getLeftChild() == null && currentNode.getRightChild() == null;
    }

    /**
     * Moves the current node to its left child. The current node should not be null.
     */
    public void moveToNo() {
        if(currentNode != null) {
            currentNode = currentNode.getLeftChild();
        }
    }

    /**
     * Moves the current node to its right child. The current node should not be null.
     */
    public void moveToYes() {
        if(currentNode != null) {
            currentNode = currentNode.getRightChild();
        }
    }

    /**
     * Sets the current node to the root of the tree.
     */
    public void resetCurrentNode() {
        this.currentNode = getRootNode();
    }

    /**
     * Returns the reference to the current node.
     * @return The reference to the current node.
     */
    public BinaryNode<T> getCurrentNode() {
        return this.currentNode;
    }

    /**
     * Gets the data from the current node.
     * @return The data in the current node.
     */
    public T getCurrentData() {
        return currentNode.getData();
    }

    /**
     * Sets the data in the children of the current node.
     * @param responseForNo The data for the left child.
     * @param responseForYes The data for the right child.
     */
    public void setResponses(T responseForNo, T responseForYes) {
        if(currentNode == null){
            return;
        }
        if(currentNode.getLeftChild() != null && currentNode.getRightChild() != null){
            currentNode.getLeftChild().setData(responseForNo);
            currentNode.getRightChild().setData(responseForYes);
        }
        else{
            if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null){
                BinaryNode<T> no = new BinaryNode<>(responseForNo);
                BinaryNode<T> yes = new BinaryNode<>(responseForYes);
                currentNode.setLeftChild(no);
                currentNode.setRightChild(yes);
            }
            else if(currentNode.getLeftChild() == null){
                BinaryNode<T> no = new BinaryNode<>(responseForNo);
                currentNode.setLeftChild(no);
                currentNode.getRightChild().setData(responseForYes);
            }
            else{
                BinaryNode<T> yes = new BinaryNode<>(responseForYes);
                currentNode.getLeftChild().setData(responseForNo);
                currentNode.setRightChild(yes);

            }
        }        
    }
    
}
