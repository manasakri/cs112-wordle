import java.util.Scanner;
import java.lang.String;
import java.io.* ;


public class Wordle {

    public void run_wordle() throws IOException {

            WordList words = new WordList(); //imports WordList class which determines
            String[] get_words = words.getWords(); //words_total is created with a list of words from words.txt
            String wordle_answer = words.getRandomWord(get_words); // words are randomly generated to get the main wordle word

            int user_guess_count = 1; //creates counter variable
            String user_next_guess; // users input
            String temp_wordle_answer = wordle_answer; //temporary dictionary

            System.out.println("\nWelcome to Wordle!");
            System.out.println("The mystery word is a 5-letter English word.");
            System.out.println("You have 6 chances to guess it.");

            while (user_guess_count <= 6) { // users can only get up to 6 guesses
                System.out.print("\nGuess " + user_guess_count + ":");
                Scanner scan = new Scanner(System.in);
                user_next_guess = scan.next(); //user input for guess
                if (user_next_guess.length() < 5) { //checks for input words that are less than five letters
                    System.out.println("Too Short. Your guess must be 5 letters long");
                    continue;
                } else if (user_next_guess.length() > 5) { //checks for input words that are more than five letters
                    System.out.println("Too Long. Your guess must be 5 letters long");
                    continue;
                } else {
                    if (user_next_guess.equals(temp_wordle_answer)) { //checks to see if the inputed word is exactly the same as the wordle answer
                        System.out.print("Congrats! You guessed it!\n"); //if words are the same, game is over and exits
                        System.exit(0);
                    } else {
                        user_guess_count = user_guess_count + 1; // if inputed word is not the same, user gets additional guesses
                    }
                    for (int i = 0; i < 5; i++) { //checks  each character in inputed word against wordle answer
                        String character = String.valueOf(user_next_guess.charAt(i)); //each character index is represented by i
                        if (user_next_guess.charAt(i) == temp_wordle_answer.charAt(i)) { // if the user guesses a letter at the correct spot in the wordle answer, that letter will print at that spot
                            System.out.print(user_next_guess.charAt(i));
                        } else if (temp_wordle_answer.contains(character)) { // if the user guesses a correct letter in the wordle answer, but at a different spot, the letter will be encased in brackets
                            System.out.print("[" + user_next_guess.charAt(i) + "]");
                        } else {
                            System.out.print("_"); // if the user did not guess a correct letter, an underscore will be used to indicate th empty positions
                        }
                    }

                }
            }
            user_guess_count = user_guess_count + 1; //moves on to the next guess after the last valid one

            while (user_guess_count > 6 ) { // if the user did not get any of the guess right ...
                System.out.println("\nSorry! Better luck next time!\n" + "The word was " + temp_wordle_answer ); //print the correct answer 
                user_guess_count = 0; // change value to less than 6 to end while loop 
            }
            }


    public static void main (String args[]) throws IOException {
        Wordle wordle_obj = new Wordle();
        wordle_obj.run_wordle(); //calls the function that checks user input
    }
}
