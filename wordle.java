import java.util.Scanner;
import java.lang.String;
import java.io.* ;


public class Wordle {

    public void run_wordle() throws IOException {

            WordList words = new WordList(); 
            String[] get_words = words.getWords(); 
            String wordle_answer = words.getRandomWord(get_words); 
        
            int user_guess_count = 1; //creates counter variable
            String user_next_guess; // users input
            String temp_wordle_answer = wordle_answer; 

            System.out.println("\nWelcome to Wordle!");
            System.out.println("The mystery word is a 5-letter English word.");
            System.out.println("You have 6 chances to guess it.");

            while (user_guess_count <= 6) { // users can only get up to 6 guesses
                System.out.print("\nGuess " + user_guess_count + ":");
                Scanner scan = new Scanner(System.in);
                user_next_guess = scan.next(); 
                if (user_next_guess.length() < 5) { //checks for input words that are less than five letters
                    System.out.println("Too Short. Your guess must be 5 letters long");
                    continue;
                } else if (user_next_guess.length() > 5) { //checks for input words that are more than five letters
                    System.out.println("Too Long. Your guess must be 5 letters long");
                    continue;
                } else {
                    //checks to see if the inputed word equals the wordle answer
                    if (user_next_guess.equals(temp_wordle_answer)) { 
                        System.out.print("Congrats! You guessed it!\n");  
                        System.exit(0);
                    } else {
                        user_guess_count = user_guess_count + 1; 
                    }
                    
                    for (int i = 0; i < 5; i++) { 
                        String character = String.valueOf(user_next_guess.charAt(i));  
                        if (user_next_guess.charAt(i) == temp_wordle_answer.charAt(i)) {  
                            System.out.print(user_next_guess.charAt(i));
                        } else if (temp_wordle_answer.contains(character)) { 
                            // if the user guesses a correct letter in the wordle answer, but at a different spot, the letter will be encased in brackets
                            System.out.print("[" + user_next_guess.charAt(i) + "]");
                        } else {
                            System.out.print("_"); // if the user did not guess a correct letter, an underscore will be used to indicate th empty positions
                        }
                    }

                }
            }
            user_guess_count = user_guess_count + 1; \

            while (user_guess_count > 6 ) { // 
                System.out.println("\nSorry! Better luck next time!\n" + "The word was " + temp_wordle_answer );  
                user_guess_count = 0; // change value to less than 6 to end while loop 
            }
            }


    public static void main (String args[]) throws IOException {
        Wordle wordle_obj = new Wordle();
        wordle_obj.run_wordle(); 
    }
}
