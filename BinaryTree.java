/**
 * Class representing a binary tree that implements the BinaryTreeInterface.
 * @param <T> Data in a node of the tree.
 */
public class BinaryTree<T> implements BinaryTreeInterface<T> {
       
    /**
     * Node that represents the root of the tree.
     * @param <T> data in the node.
     */
    private BinaryNode<T> root;

    /**
     * Constructor for the BinaryTree class. Initializes the root to null.
     */
    public BinaryTree() {
        this.root = null;
    }

    /**
     * Constructor for the BinaryTree class. Initializes the root data.
     * @param data The data to be stored in the root.
     */
    public BinaryTree(T data) {
        this.root = new BinaryNode<T>(data);
    }

    /**
     * Constructor for the BinaryTree class. Initializes the root with the data and left and right child nodes.
     * @param data The data to be put in the root node.
     * @param leftTree The tree to be set as the left child.
     * @param rightTree The tree to be set as the right child.
     */
    public BinaryTree(T data, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        BinaryNode<T> root = new BinaryNode<T>(data);
        if(leftTree != null){
            root.setLeftChild(leftTree.getRootNode());
        }
        if(rightTree != null) {
            root.setRightChild(rightTree.getRootNode());
        }
        this.root = root;
    }

    /**
     * Sets the root of the tree with data. Also sets the left and right children equal to leftTree and rightTree.
     * @param data The data to be stored in the root.
     * @param leftTree The tree that will be the left child of the root.
     * @param rightTree The tree that will be the right child of the root.
     */
    public void setTree(T data, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        BinaryNode<T> root = new BinaryNode<T>(data);
        if(leftTree != null){
            root.setLeftChild(leftTree.getRootNode());
        }
        if(rightTree != null) {
            root.setRightChild(rightTree.getRootNode());
        }
        this.root = root;
    }

    /**
     * Prints the data of the nodes in the tree inorder.
     * @throws EmptyTreeException Exception stating that the method cannot be ran because the tree is empty.
     */
    public void inorderTraversal() throws EmptyTreeException{
        if(this.isEmpty()) {
            throw new EmptyTreeException();
        }
        if(this.root.getLeftChild() != null) {
            BinaryTree<T> nextRoot = new BinaryTree<>();
            nextRoot.root = this.root.getLeftChild();
            nextRoot.inorderTraversal();
        }
        System.out.print(this.root.getData());
        if(this.root.getRightChild() != null){
            BinaryTree<T> nextRoot = new BinaryTree<>();
            nextRoot.root = this.root.getRightChild();
            nextRoot.inorderTraversal();
        }
    }

    /**
     * Returns a reference to the root node of the tree.
     * @return The root node of the tree.
     */
    public BinaryNode<T> getRootNode() {
        return this.root;
    }

    /**
     * Gets the data from the root node of the tree.
     * @return The root data.
     */
    public T getRootData() {
        if(this.root == null) {
            throw new EmptyTreeException();
        }
        return this.root.getData();
    }

    /**
     * Sets the root node in the tree to be a specified node.
     * @param root The node that will be set as the root of the tree.
     */
    public void setRootNode(BinaryNode<T> root) {
        this.root = root;
    }

    /**
     * Returns the height of the tree.
     * @return The height of the tree.
     */
    public int getHeight() {
        return root.getHeight();
    }

    /**
     * Gets the number of nodes in the tree.
     * @return The number of nodes in the tree.
     */
    public int getNumberOfNodes() {
        return root.getNumberOfNodes();
    }

    /**
     * Checks to see if the tree is empty.
     * @return Boolean stating whether or not the tree is empty.
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * Clears the tree.
     */
    public void clear() {
        this.root = null;
    }

}
