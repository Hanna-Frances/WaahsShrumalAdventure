/**
 * Project: WaahsShrumalAdventure
 * Programmer: Hanna Bobis
 * Class: SortGame
 * Description: Info for the sorting game.
 */
package waahsshrumaladventure;

public class SortGame extends MultiGame {
    
    //Field
    private int[] listNum = new int[5];
    
    //Constructor
    SortGame() {
        //Fill listNum array with random numbers between 0-100.
        for(int i = 0; i < listNum.length; i++) 
            listNum[i] = ranNum.nextInt(101);
    }
    
    //Getter
    public int[] getListNum() {
        return listNum;
    }
    
    //Setter
    public void setListNum(int[] l) {
        listNum = l;
    }
    
    //Unique methods
    
    /**
     * Method Name: askQuestion
     * Description: Asks the question.
     */
    @Override
    public void askQuestion() {
        
        //Print instructions.
        System.out.println("Five numbers appear in front of Waah.");
        System.out.println("\"Subtract the smallest number from the largest "
                + "number.\" The voice says.");
        
        //Print list of numbers.
        for(int i : listNum)
            System.out.print(i + " ");
        System.out.println("");
    }//End askQuestion
    
    /**
     * Method Name: solve
     * Description: Solves the question and returns the answer.
     * @return int - The answer.
     */
    @Override
    public int solve() {
        
        //Use selection sort to sort the list of numbers from least to greatest.
        int minValue, minIndex;

        for(int i = 0; i < listNum.length - 1; i++){
            
            minValue = listNum[i];
            minIndex = i;
            
            for(int j = i + 1; j < listNum.length; j++){
                if(listNum[j] < minValue){
                    minValue = listNum[j];
                    minIndex = j;
                }
            }
            listNum[minIndex] = listNum[i];
            listNum[i] = minValue;
        }
        
        //Return the difference between the last number with the first.
        return listNum[4] - listNum[0];
        
    }//End solve.
}//End class.
