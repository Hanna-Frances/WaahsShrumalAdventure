/**
 * Project: WaahsShrumalAdventure
 * Programmer: Hanna Bobis
 * Class: MultiGame
 * Description: Info for the multiplying game.
 */
package waahsshrumaladventure;

public class MultiGame extends Minigame {
    
    //Fields
    protected int num1;
    protected int num2;
    
    //Constructor
    MultiGame() {
        //Random numbers used for the question.
        num1 = ranNum.nextInt(50);
        num2 = ranNum.nextInt(50);
    }
    
    //Getters
    public int gerNum1() {
        return num1;
    }
    
    public int getNum2() {
        return num2;
    }
    
    //Setters
    public void setNum1(int n) {
        num1 = n;
    }
    
    public void setNum2(int n) {
        num2 = n;
    }
    
    //Unique methods
    
    /**
     * Method Name: askQuestion
     * Description: Asks the question.
     */
    @Override
    public void askQuestion() {
        
        //Print instructions
        System.out.println("Two numbers appear.");
        System.out.println("\"Multiply them together.\" The voice says, \""
                + "Then state your answer\"");
        
        //Print multiplication question.
        System.out.println(num1 + " * " + num2);
    }//End askQuestion
    
    /**
     * Method Name: solve
     * Description: Solves the question and returns the answer.
     * @return int - The answer.
     */
    @Override
    public int solve() {
        return num1 * num2; //Return the product of num1 * num2.
    }//End solve.
}//End class.
