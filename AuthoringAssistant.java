package authoringassistant;
import java.util.Scanner;
public class AuthoringAssistant {

    public static Character menu() { //Prints menu and gets input
        Scanner scnr = new Scanner(System.in);
        Character choice = 'b'; //menu choice variable
        
        System.out.println("MENU");
        System.out.println("c - Number of non-whitespace characters");
        System.out.println("w - Number of words");
        System.out.println("f - Find text");
        System.out.println("r - Replace all !\'s");
        System.out.println("s - Shorten spaces");
        System.out.println("o - Output text");
        System.out.println("q - Quit");
        System.out.println();
        System.out.println("Choose an option: ");
        
        choice = scnr.next().charAt(0);  //Get's user input
        
        return choice;
    } //END MENU()
    
    public static int nonWhiteSpace(String text) {
        int total = 0; //Counts whitespace
        
        for(int i = 0; i < text.length(); i++) {
            if(!Character.isWhitespace(text.charAt(i))) { //Checks if character is not whitespace
                total += 1; //Increases total number of non-whitespace
            } //END IF
        } //END FOR
        return total;
    } //END whiteSpace()
    
    public static int numWords(String text) {
        int length = 0; //saves number of words in string
        
        String[] word = text.split("\\s+"); //Splits string into array
        length = word.length; //Gets length of the array
        
        return length;
    }
    
    public static int findText(String locate, String text) {
        int occur = 0;
        text = text.replaceAll("\\p{Punct}", ""); //Removes puncuation
        String[] word = text.split("\\s+"); //Splits into array using spaces
        for(int i = 0; i < word.length; i++) { //Loop to cycle through array
            if(locate.equalsIgnoreCase(word[i])) {
                occur += 1; //if the word in the array is the same as the word to locate then increase the number of occurances
            } //END IF
        }// END FOR
        return occur;
    }
    public static String replaceExcl (String text) {
        text = text.replace('!', '.'); //replaces ! with .
        return text;
    }
    
    public static String shortenSpace(String text) {
        text = text.replaceAll("\\s+", " "); //replaces the extra spaces with a single space
        return text;
    }
    
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String input = ""; //user input
        Character menOpt = 'p';  //saves the menu option chosen
        boolean quit = true; //determines end of program
        boolean tru = false; //check input
        String find; //word to locate in string
        
        while(tru != true) {
            System.out.println("Enter a sample text: "); //Prompts User for input
            input = scnr.nextLine();  //Gets input
            if (input.equals("") || input.equals(" ")) { //If the string is empty
                System.out.println("No input, try again.");
            }//END IF
            else {
                System.out.println();
                System.out.println("You entered: " + input);
                tru = true;
            }//END ELSE
        }
        
        
        while (quit) {
            System.out.println();
            menOpt = menu(); //Runs menu method and gets input
            switch(menOpt) {
                case 'q':  //QUIT
                    quit = false; 
                    break; 
                case 'c':  //Number of non-whitespaces
                    System.out.println();
                    System.out.println("The total number of non-whitespaces is " + nonWhiteSpace(input));
                    System.out.println();
                    break; 
                case 'w':  //Number of words
                    System.out.println();
                    System.out.println("The total number of words is: " + numWords(input));
                    System.out.println();
                    break; 
                case 'f':  //Find text
                    System.out.println();
                    System.out.println("Enter a word to find: ");
                    find = scnr.next(); 
                    System.out.println("The word " + find + " occurs " + findText(find, input) + " times.");
                    System.out.println();
                    break; 
                case 'r':  //Replace !
                    System.out.println();
                    input = replaceExcl(input);
                    System.out.println();
                    break;
                case 's':  //Shorten spaces
                    System.out.println();
                    input = shortenSpace(input);
                    System.out.println();
                    break;
                case 'o': //Output text
                    System.out.println();
                    System.out.println("Your text is: " + input);
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    System.out.println("Enter Option From Menu.");
                    break;
            }
        }
    }
    
}
