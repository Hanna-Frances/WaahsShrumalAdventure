/**
 * Project: WaahsShrumalAdventure
 * Programmer: Hanna Bobis
 * Class: Stones
 * Description: Info for the stones game.
 */
package waahsshrumaladventure;

import java.util.Random;

public class Stones {
    
    //Fields
    private int numStones;
    private boolean waahTurn;
    private Random ranNum = new Random();
    
    //Constructor
    Stones() {
        numStones = 15; //Start with 15 stones.
        waahTurn = true; //Start on player's turn.
    }
    
    //Getters
    public int getNumStones() {
        return numStones;
    }
    
    public boolean getWaahTurn() {
        return waahTurn;
    }
    
    //Setters
    public void setnumStones(int n) {
        numStones = n;
    }
    
    public void setWaahTurn(boolean w) {
        waahTurn = w;
    }
    
    //Unique methods
    
    /**
     * Method Name: userTakeStones
     * Description: Subtracts the stones the player took from the pile of
     * stones.
     */
    public void userTakeStones() {
        int takeStones;
        
        /*
        If the player chooses a number lower than 1 or greater than 3, the
        loop will run again.
        */
        do {
            System.out.println("It is Waah's turn! How many stones will "
                    + "Waah take? (1, 2, 3)");
            
            //Use the getUserNum method to error trap any number format exceptions
            takeStones = WaahsShrumalAdventure.getUserNum();
        }
        while((takeStones < 1) || (takeStones > 3));
        
        numStones -= takeStones; //Subtract stones taken.
        waahTurn = false; //Switch to computer's turn.
    }//End userTakeStones.
    
    /**
     * Method Name: compTakeStones
     * Description: Computer takes a random number of stones from the pile 
     * (with exceptions)
     */
    public void compTakeStones() {
        
        /*
        Choose a random number from 1-3 for the number of stones the computer 
        will take.
        */
        int takeStones;
        
        if(numStones == 2)
            takeStones = 1; //Don't lose if there are two stones remaining.
        else
            takeStones = ranNum.nextInt(3) + 1;
        
        //Print number of stones the computer takes.
        System.out.println("Radiant Shrumal Ogre takes " + takeStones 
                + " stones!");
        
        numStones -= takeStones; //Subtract stones taken.
        waahTurn = true; //Switch to player's turn
    }//End compTakeStones
}//End class.
