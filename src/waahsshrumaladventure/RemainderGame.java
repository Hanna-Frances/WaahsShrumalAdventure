/**
 * Project: WaahsShrumalAdventure
 * Programmer: Hanna Bobis
 * Class: RemainderGame
 * Description: Info for the remainder game.
 */
package waahsshrumaladventure;

public class RemainderGame extends MultiGame {
    
    //Constructor
    RemainderGame() {
        
        /*
        Fill num1 and num2 with random numbers. num2 adds 1 to avoid dividing
        by zero.
        */
        num1 = ranNum.nextInt(101);
        num2 = ranNum.nextInt(15) + 1;
    }
    
    //Unique Methods
    
    /**
     * Method Name: askQuestion
     * Description: Asks the question.
     */
    @Override
    public void askQuestion() {
        
        //Print instructions.
        System.out.println("Two numbers appear with a % sign between them.");
        System.out.println("\"Divide them.\" The voice says, \""
                + "Don't answer with the quotient, but with the remainder.\"");
        
        //Print remainder question
        System.out.println(num1 + " % " + num2);
    }//End askQuestion
    
    /**
     * Method Name: solve
     * Description: Solves the question and returns the answer.
     * @return int - The answer to the remainder question.
     */
    @Override
    public int solve() {
        return num1 % num2; //Return the remainder of num1 % num2.
    }//End solve.
    
}//End class.
