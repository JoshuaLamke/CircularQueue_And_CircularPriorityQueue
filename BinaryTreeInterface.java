/**
 * Interface that defines the functionality of a generic binary tree.
 * @param <T> The data in the tree.
 */
public interface BinaryTreeInterface<T> {
    
    /**
     * Gets the data at the root of the tree.
     * @return The data at the root of the tree if the tree is not empty.
     */
    T getRootData();

    /**
     * Returns the reference to the root node of the tree.
     * @return The reference to the root node.
     */
    BinaryNode<T> getRootNode();

    /**
     * Sets the root node of the tree.
     * @param root The node to be set as the root of the tree.
     */
    void setRootNode(BinaryNode<T> root);

    /**
     * Returns the height of the tree.
     * @return The height of the tree.
     */
    int getHeight();
    /**
     * Gets the number of nodes in the tree.
     * @return The number of nodes in the tree.
     */
    int getNumberOfNodes();

    /**
     * Checks to see if the tree is empty.
     * @return Boolean stating whether or not the tree is empty.
     */
    boolean isEmpty();

    /**
     * Clears the tree.
     */
    void clear();
}
