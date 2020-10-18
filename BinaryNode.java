/**
 * Class that represents a node in the tree.
 * @param <T> The data stored in the node.
 */
public class BinaryNode<T> {
    
    /**
     * The data for this node.
     */
    private T data;

    /**
     * The left child of this node.
     */
    private BinaryNode<T> leftChild;

    /**
     * The right child of this node.
     */
    private BinaryNode<T> rightChild;

    /**
     * Constructor that initializes a node with all attributes set to null.
     */
    public BinaryNode() {
        this.data = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * Constructor that initializes a node with data and sets the other attributes to null.
     * @param data The data to be stored in the node.
     */
    public BinaryNode(T data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * Sets the data in the node.
     * @param data The data to be stored in the node.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Gets the data from the node.
     * @return The data stored in the node.
     */
    public T getData() {
        return this.data;
    }

    /**
     * Setter for the left child node.
     * @param leftChild The left child node.
     */
    public void setLeftChild(BinaryNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Getter for the left child node.
     * @return The left child node.
     */
    public BinaryNode<T> getLeftChild() {
        return this.leftChild;
    }

    /**
     * Setter for the right child node.
     * @param rightChild The right child node.
     */
    public void setRightChild(BinaryNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * Getter for the right child node.
     * @return The right child node.
     */
    public BinaryNode<T> getRightChild() {
        return this.rightChild;
    }

    /**
     * Checks to see if the node has a left child.
     * @return Boolean stating whether or not the node has a left child.
     */
    public boolean hasLeftChild() {
        return leftChild != null;
    }

    /**
     * Checks to see if the node has a right child.
     * @return Boolean stating whether or not the node has a right child.
     */
    public boolean hasRightChild() {
        return rightChild != null;
    }

    /**
     * Checks to see if the node is a leaf.
     * @return Boolean stating whether or not the node is a leaf.
     */
    public boolean isLeaf() {
        return !hasLeftChild() && !hasRightChild();
    }

    /**
     * Gets the height of a tree with this node as its root.
     * @return The height of the tree.
     * @throws EmptyTreeException exception that states the tree is empty.
     */
    public int getHeight() throws EmptyTreeException{
        return getHeight(this) - 1; //To adjust to the heights starting at 0
    }

    /**
     * Calculates the height of a given node.
     * @param node The node whose height is to be calculated.
     * @return The height of the node.
     */
    private int getHeight(BinaryNode<T> node) {
        if (node == null) {
            return 0; 
        }
        else { 
            int leftChildHeight = getHeight(node.leftChild); 
            int rightChildHeight = getHeight(node.rightChild); 
            if (leftChildHeight > rightChildHeight){
                return (leftChildHeight + 1); 
            } 
            else {
                return (rightChildHeight + 1); 
            } 
        } 
    }

    /**
     * Returns the number of nodes in a tree rooted at this node.
     * @return The number of nodes.
     */
    public int getNumberOfNodes() {
        return getNumberOfNodes(this);
    }

    /**
     * Takes in a tree root and calculates the number of nodes in the tree.
     * @param root The root of the tree.
     * @return The number of nodes in the tree.
     */
    private int getNumberOfNodes(BinaryNode<T> root) {
        if (root == null) {
            return 0; 
        } 
        if (root.leftChild == null && root.rightChild == null) {
            return 1;
        } 
        else {
            return  1 + getNumberOfNodes(root.leftChild) + getNumberOfNodes(root.rightChild); 
        }
    }

    /**
     * Copys and returns a tree rooted at the current node.
     * @return The duplicate tree.
     */
    public BinaryNode<T> copy() {
        BinaryNode<T> root = new BinaryNode<>(this.data);
        if(leftChild != null) {
            root.leftChild = leftChild.copy();
        }
        if(rightChild != null) {
            root.rightChild = rightChild.copy();
        }
        return root;
    }


}
