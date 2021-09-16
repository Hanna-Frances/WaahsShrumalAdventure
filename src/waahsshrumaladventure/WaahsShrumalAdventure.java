/**
 * Program: WaahsShrumalAdventure
 * Programmer: Hanna Bobis
 * Date: June 16, 2020
 * Description: A text adventure about the shrumal warrior, Waah.
 */
package waahsshrumaladventure;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class WaahsShrumalAdventure {

    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        
        //Welcome message.
        System.out.println("WELCOME TO WAAH'S SHRUMAL ADVENTURE");
        
        //Print instructions for controlling the text speed.
        System.out.println("When you see ^^, enter anything to continue. "
                + "\n^^");
        scan.nextLine();
        
        /*
        Ask if the user wants to read the long version or the short version of 
        the story (the long version is really long)
        */
        String ver;
        
        do{
            
            System.out.println("There are two versions of the story you can read. "
                    + "Type \"long\" for the full version or \"short\" for the "
                    + "summarized version. (Warning: the full version is very, "
                    + "very long)");

            ver = scan.nextLine();
        }
        while(!ver.equalsIgnoreCase("long") && !ver.equalsIgnoreCase("short"));
        
        System.out.println("THE STORY BEGINS...\n");
        
        //Specify in the player object the user's choice of story length.
        
        Player player;
        
        if(ver.equalsIgnoreCase("long")) {
            player = new Player(true);
            dialogue("intro-long");
        }
        else {
            player = new Player(false);
            dialogue("intro-short");
        }
        
        //Go through each day.
        for(int i = 1; i < 7; i ++) {
            
            //Print dialogue for the appropriate day.
            dialogue(makeFileName(i, player, 0));
            playGame(player, i);
            
        }
        
        //Check if boss battle can be done.
        if(player.getNumFails() < 3) {
            dialogue("sunPass");
            bossBattle(player);
        }
        else {
            dialogue("sunFail");
            dialogue("end");
        }
    }//End main.
    
    /**
     * Method Name: dialogue
     * Description: Prints out the dialogue for the specified section.
     * @param fileName String - The name of the file to be read from.
     * @throws IOException 
     */
    public static void dialogue(String fileName) throws IOException{
        
        //Make a file of the appropriate section of text.
        File file = new File("C:\\Users\\hanna\\Documents\\Programming\\"
                + "NetBeansProjects\\Java\\Gr 12 Computer Science\\"
                + "WaahsShrumalAdventure\\dialogue\\" + fileName + ".txt");
        
        //Make scanner for file.
        Scanner readFile = new Scanner(file);
        
        /*
        Print out the file but allow the user to control how fast the text 
        moves based on their input.
        */
        while(readFile.hasNext()) {
            
            System.out.println(readFile.nextLine() + "\n^^");
            scan.nextLine();
            
        }//End while loop
    }//End dialogue.
    
    /**
     * Method Name: makeFileName
     * Description: Makes the file name which will be later passed on to the 
     * dialogue method, used for text during each day and for text after the
     * player attempts a minigame question.
     * @param dayNum - day number
     * @param player - player object
     * @param type - what type of dialogue is needed.
     * @return String - file name
     */
    public static String makeFileName(int dayNum, Player player, int type) {
        
        /*
        The number of question represents whether the dialogue for the day is
        needed or if the dialogue for getting a correct/incorrect question is 
        needed.
        */
        switch(type) {
            case 1: {
                //Correct answer
                return "day" + dayNum + "-correct";
            }
            case 2: {
                //Wrong answer
                return "day" + dayNum + "-incorrect";
            }
            default: {
                //General dialogue for the day
                return "day" + dayNum + "-" + player.getLongVer();
            }
        }//End switch
        
    }//End makeFileName
    
    /**
     * Method Name: playGame
     * Description: Plays a random minigame.
     * @param player - player object.
     * @param dayNum - day number the player is on.
     * @throws IOException 
     */
    public static void playGame(Player player, int dayNum) throws IOException{
        
        int ans, num;
        
        //Pick a random integer between 1-3
        Random ranNum = new Random();
        num = ranNum.nextInt(3) + 1;
        
        //Make game object
        Minigame game;
        
        //Make appropriate game object based on random number chosen.
        switch(num) {
            case 1: {
                game = new MultiGame();
                break;
            }
            case 2: {
                game = new RemainderGame();
                break;
            }
            case 3: {
                game = new SortGame();
                break;
            }
            default: {
                game = new Minigame();
            }
        }//End switch.
        
        game.askQuestion();
        
        ans = getUserNum();
        
        //Do appropriate action if player fails/passes the question.
        if(ans == game.solve())
            dialogue(makeFileName(dayNum, player, 1));
        else {
            dialogue(makeFileName(dayNum, player, 2));
            player.addFail();
        }
        
        //Print number of fails and an appropriate message based on fails.
        System.out.println("Waah's Fails so far: " + player.getNumFails());
        
        if(player.getNumFails() < 3)
            System.out.println("So far so good!");
        else
            System.out.println("...");
        
        System.out.println("^^");
        scan.nextLine();
    }//End playGame.
    
    /**
     * Method Name: bossBattle
     * Description: The boss battle of the game.
     * @param player - player object.
     * @throws IOException 
     */
    public static void bossBattle(Player player) throws IOException {
        
        //Make stones object.
        Stones stone = new Stones();
        
        while(stone.getNumStones() > 0) {
            
            //Display number of stones left.
            System.out.println("There are " + stone.getNumStones() + " stones "
                    + "left!"
                + "\n^^");
            scan.nextLine();
            
            /*
            If it is the player's turn then invoke the method for player in 
            the stones class. Otherwise, invoke the computer's method.
            */
            if(stone.getWaahTurn()) 
                stone.userTakeStones();
            else 
                stone.compTakeStones();
            
        }//End while loop.
        
        //Print the appropriate dialogue if player wins/loses.
        if(stone.getWaahTurn()) 
            dialogue("bossPass");
        else
            dialogue("bossFail");
        
        dialogue("end");
    }//End bossBattle
    
    /**
     * Method Name: getUserNum
     * Description: Receives user input for a number and catches if the user
     * does not input a number.
     * @return int - user input
     */
    public static int getUserNum() {
        boolean repeat;
        int ans = 0;
        
        /*
        Obtain user's answer, used a try catch in case the user does not
        type in a number. The boolean is used to loop it until the
        user enters a number.
        */
        do{
            repeat = false;
            
            try {
                ans = Integer.parseInt(scan.nextLine());
            }
            
            //If the user does not enter a number, loop again.
            catch (NumberFormatException e) {
                System.out.println("Invalid response... Did you even enter a "
                        + "number?");
                repeat = true;
            }
            
        }//End do while loop.
        while (repeat);
        
        return ans;
    }//End getUserNum
    
}//End class.
