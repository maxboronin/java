package geekbrains;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static StringBuilder charBar = new StringBuilder("###############");

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"
        };

        System.out.println("**********************************************************************");
        System.out.println("** Угадай растение                                                  **");
        System.out.println("**********************************************************************");
        String aiWord = words[new Random().nextInt( words.length )];
        int numberOfAttempts = guessWord(aiWord);
        System.out.printf("Поздравляю! Вы отгадали слово %s, Вам понадобилось попыток: %d", aiWord, numberOfAttempts);
    }

    private static int guessWord(String word){
        int numberOfAttempts = 0;
        Boolean isEquals;

        do{
            String inputWord;

            numberOfAttempts++;

            System.out.printf("\r %s \n Введите слово:", charBar);

            if( !( isEquals = compareWords(word, inputWord = inputWord()) ) ) {
                modifyCharBar(word, inputWord);
            }

        }while(!isEquals);

        return numberOfAttempts;
    }

    private static void modifyCharBar(String word1, String word2){
        for(int i=0;i<(word1.length() > word2.length() ? word2.length() : word1.length());i++){
            if(word1.charAt(i) == word2.charAt(i)){
                charBar.setCharAt(i, word1.charAt(i));
            }
        }
    }

    private static String inputWord(){
        Scanner scanner = new Scanner(System.in);
        String input;
        do{
            input = scanner.nextLine().toLowerCase().trim();
        }while(input.length()  == 0);
        return input;
    }

    private static boolean compareWords(String word1, String word2){
        return word1.toLowerCase().trim().equals( word2.toLowerCase().trim() );
    }

}
