import java.io.*;
import java.util.Random;
import java.util.Scanner;


public class WordList {
    public String[] getWords() throws IOException {
        File file = new File("/Users/manasakrishnan/desktop/words.txt/");  // imports words.txt file with all words
        Scanner scan = new Scanner(file); // reads the words in words.txt
        int counter = 0;  // counter variable to count num of words in words.txt
        while (scan.hasNext()) {    // Loop to count the number of words in the file
            String words_in_file = scan.next();    //reads the next word
            if (words_in_file.length() == 5) {  //words have to be exactly 5 letters long in order for user to guess
                counter = counter+ 1;  //counter var increases by 1 if word is 5 letters long. else the word is ignored
            }
        }
        String[] array_of_words = new String[counter]; // turns words into an array
        scan = new Scanner(file);     // reads the words in txt file again
        int i = 0;
        while (scan.hasNext()) {
            String word = scan.next();    // reads the next word in file
            if (word.length() == 5) { //word must be 5 letters long
                array_of_words[i] = word;    // inputs word into an array
                i = i + 1;
            }
        }
        return array_of_words;
    }

    String getRandomWord(String[] words) {   //generates random 5 letter word from words.txt
        Random random_word = new Random();
        int index = random_word.nextInt(words.length);
        return words[index];
    }
} // doesn't run because it is being imported by Wordle.java
