/**
 * Project: WaahsShrumalAdventure
 * Programmer: Hanna Bobis
 * Class: Player
 * Description: Info for the player.
 */
package waahsshrumaladventure;

public class Player {
    
    //Fields
    private int numFails;
    private String longVer;
    
    //Constructor
    Player(boolean l) {
        numFails = 0;
        
        /*
        Make longVer the name of the word at the end of the file name. This will
        make it easier to open the right files depending on if the user wants
        the full story or the summarized version.
        */
        if(l)
            longVer = "long";
        else
            longVer = "short";
    }
    
    //Getters
    public int getNumFails() {
        return numFails;
    }
    
    public String getLongVer() {
        return longVer;
    }
    
    //Setter
    public void setNumFails(int n) {
        numFails = n;
    }
    
    public void setlongVer(String l) {
        longVer = l;
    }
    
    //Unique methods
    
    /**
     * Method Name: addFail
     * Description: Adds 1 to numFails.
     */
    public void addFail() {
        numFails++;
    }//End addFail.
    
}//End class.
