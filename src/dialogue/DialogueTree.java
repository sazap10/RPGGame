package dialogue;
import java.util.HashMap;

public class DialogueTree{
    /*
    * The root of the tree
    */
    private Dialogue root;
    
    /*
    * The current dialogue
    */
    private Dialogue current;
    
    /*
    * A HashMap of all the ids and Dialogue currently
    * in the tree
    */
    private HashMap<Integer,Dialogue> currentIds;
    
    /**
     * Constructs a new DialogueTree
     */
    public DialogueTree(){
        currentIds = new HashMap<Integer, Dialogue>();
        root = null;
        current = null;
    }
    
    /**
     * Constructs the tree by reading the file
     *
     * @param file File containing the text
     */
    public void constructTree(File file){
        
    }
    
}