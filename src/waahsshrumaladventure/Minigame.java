/**
 * Project: WaahsShrumalAdventure
 * Programmer: Hanna Bobis
 * Class: Minigame
 * Description: Template for the minigames.
 */
package waahsshrumaladventure;

import java.util.Random;

public class Minigame {
    
    //Field
    protected Random ranNum = new Random();
    
    //Unique methods 
    
    /**
     * Method Name: askQuestion
     * Description: Prints out the question.
     */
    public void askQuestion() {
        System.out.println("I think you did something wrong");
    }//End askQuestion.
    
    /**
     * Method Name: solve
     * Description: Solves the question and returns the answer (no solution 
     * code because this is only the Minigame class)
     * @return 
     */
    public int solve() {
        return -9999;
    }//End solve.
}//End class. 
