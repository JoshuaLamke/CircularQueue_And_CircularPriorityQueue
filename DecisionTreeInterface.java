/**
 * Interface that represents the functionalities of the decision tree being used for the covid health checks.
 * @param <T> The data in the tree.
 */
public interface DecisionTreeInterface<T> extends BinaryTreeInterface<T> {

    /**
     * Evaluates whether the current node contains the final answer or not.
     * @return Boolean stating whether this node contains the final answer or not.
     */
    boolean isAnswer();

    /**
     * Moves the current node to its left child. The current node should not be null.
     */
    void moveToNo();

    /**
     * Moves the current node to its right child. The current node should not be null.
     */
    void moveToYes();

    /**
     * Sets the current node to the root of the tree.
     */
    void resetCurrentNode();

    /**
     * Returns the reference to the current node.
     * @return The reference to the current node.
     */
    BinaryNode<T> getCurrentNode();

    /**
     * Gets the data from the current node.
     * @return The data in the current node.
     */
    T getCurrentData();

    /**
     * Sets the data in the children of the current node.
     * @param responseForNo The data for the left child.
     * @param responseForYes The data for the right child.
     */
    void setResponses(T responseForNo, T responseForYes);
}