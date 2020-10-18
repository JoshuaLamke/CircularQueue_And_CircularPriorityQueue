import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class that builds the desicionTree for the application.
 */
public class CovidHealthBuilder {

    /**
     * The desicionTree that will contain the data.
     */
    DecisionTreeInterface<String> healthTree;

    /**
     * Constructor for CovidHealthBuilder. Takes in a file name and initializes a
     * decisionTree based on the contents of the file.
     * 
     * @param fileName The name of the file.
     */
    public CovidHealthBuilder(String fileName) {
        ArrayList<String> nodesList = readData(fileName);
        if(nodesList.size() == 0) {
            throw new EmptyTreeException();
        }
        healthTree = new DecisionTree<>();
        BinaryNode<String> root =  new BinaryNode<>(nodesList.get(0));
        healthTree.setRootNode(buildTree(nodesList, root, 0));
    }

    /**
     * Accepts the filename and returns an arraylist of the contents in the file.
     * 
     * @param fileName The name of the file to be read.
     * @return An arraylist containing the contents of the file.
     * @throws FileNotFoundException Exception saying file is not found.
     */
    public ArrayList<String> readData(String fileName) {
        ArrayList<String> nodesList = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(fileName));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] nodes = line.split(",");
                for(int i = 0; i < nodes.length; i++){
                    nodesList.add(nodes[i].trim());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return nodesList;
    }

    /**
     * Builds a decision tree from the arraylist returned by readData.
     * @param nodesList Arraylist that was returned by readData.
     * @param root The node to be returned to initialize the decisionTree.
     * @param index The index in the arraylist.
     * @return The root node of the decisionTree.
     */
    public BinaryNode<String> buildTree(ArrayList<String> nodesList, BinaryNode<String> root, int index) { 
        while(index * 2 + 1 < nodesList.size() && root != null) {
            BinaryNode<String> leftChild = new BinaryNode<String>();
            leftChild.setData(nodesList.get(index * 2 + 1));
            BinaryNode<String> rightChild = new BinaryNode<String>();
            rightChild.setData(nodesList.get(index * 2 + 2));
            if(leftChild.getData().trim().equals("null") && rightChild.getData().trim().equals("null")) {
                leftChild = null;
                rightChild = null;
                root.setLeftChild(leftChild);
                root.setRightChild(rightChild);
                return root;
            }
            root.setLeftChild(leftChild);
            root.setRightChild(rightChild);
            buildTree(nodesList, root.getLeftChild(), index * 2 + 1); 
            buildTree(nodesList, root.getRightChild(), index * 2 + 2);
            return root;
        }
        return root;
    }

    /**
     * Goes through the decisionTree asking the questions until it reaches a decision.
     */
    public void decide() {
        Scanner keyboard = new Scanner(System.in);
        healthTree.resetCurrentNode();
        while(!healthTree.isAnswer()) {
            System.out.println(healthTree.getCurrentData());
            String response = keyboard.next();
            if(response.toLowerCase().equals("no")) {
                healthTree.moveToNo();
            }
            else {
                healthTree.moveToYes();
            }
        }
        System.out.println(healthTree.getCurrentData() + "\n");
        System.out.println("Satisfied by my intelligence?\n");
        String response = keyboard.next();
        if(response.toLowerCase().equals("no")) {
            learn();
        }
    }

    /**
     * Updates the tree with the newly learned information.
     */
    public void learn() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What should be the answer?");
        String answer = keyboard.nextLine();
        System.out.println("Give me a question that is yes for " + answer + " but no for " + healthTree.getCurrentData());
        String question = keyboard.nextLine();
        updateTree(question, healthTree.getCurrentData(), answer);
    }

    /**
     * Updates the tree with the new node and its yes and no answers.
     * @param question The newly added question.
     * @param noAnswer The no answer to the question.
     * @param yesAnswer The yes answer to the question.
     */
    public void updateTree(String question, String noAnswer, String yesAnswer) {
        healthTree.setResponses(noAnswer, yesAnswer);
        healthTree.getCurrentNode().setData(question);
    }

    /**
     * Returns the health tree.
     * @return the health tree.
     */
    public DecisionTreeInterface<String> getHealthTree() {
        return this.healthTree;
    }
}

    
