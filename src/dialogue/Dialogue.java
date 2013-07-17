package dialogue;
import java.util.ArrayList;
import Utils.Pair;

public class Dialogue{

   /*
   * The id of the dialogue
   */
   private int id;
   /*
   * List of the different pages of the cutscene
   */
   private ArrayList<String> pages;
   /*
   * A list of the options/routes to the next
   * dialogue, represented as a pair of String and Dialogue
   */
   private ArrayList<Pair<String,Dialogue>> options;
   
   /**
     * Constructs a new Dialogue with the given values.
     *
     * @param id  the id of the Dialogue
     */
   public Dialogue(int id){
       this.id=id;
       pages = new ArrayList<String>();
       options = new ArrayList<Pair<String,Dialogue>>();
   }
   
   /**
     * Adds a string of text to the pages ArrayList
     *
     * @param page  the string to be added to the list
     */
   public void addPage(String page){
       pages.add(page);
   }
   
   /**
     * Adds an String, Dialogue Pair option to the list
     *
     * @param option the text of the option
     * @param nextDialogue the dialogue next in the story
     */
   public void addOption(String option, Dialogue nextDialogue){
       options.add(new Pair<String,Dialogue>(option,nextDialogue));
   }
}