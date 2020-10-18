/**
 * Exception class that is thrown when a tree is empty.
 */
public class EmptyTreeException extends RuntimeException{

    /**
     * Constructor for the EmptyTreeException class. Prints out the error message
     * for an empty tree.
     */
    public EmptyTreeException() {
        System.err.println("This operation cannot be performed because the tree cannot be empty.");
    }
}
