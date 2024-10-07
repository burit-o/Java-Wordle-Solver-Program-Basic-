import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class WordleSolver {

    public static void main(String[] args) throws Exception {
        String filename = "words.txt";
        File file = new File(filename);
        // Scanner for word file
        Scanner reader = new Scanner(file);
        Scanner scanner = new Scanner(file);
        Scanner sc = new Scanner(System.in);
        int lines = lineCounter(filename);
        // List of all words
        String[] word = new String[lines];
        ArrayList<String> possibleWords = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            word[i] = reader.nextLine().toLowerCase();
        }

        String input = "";
        String ValidLettersStr = new String();
        String AbsentLettersStr = new String();
        System.out.println("Enter Correct Letters (Length of 5)");
        System.out.println("_ _ _ _ _");

        while (input.length() != 5) {
            input = sc.nextLine();
            if (input.length() != 5)
                System.out.println("Must be length of 5");
        }
        System.out.println("Enter Valid Letters");
        ValidLettersStr = sc.nextLine();
        System.out.println("Enter Absent Letters");
        AbsentLettersStr = sc.nextLine();

        String input2 = "";
        int counter = 5;
        for (int i = 0; i < 5; i++) {
            if (input.charAt(i) == ' ') {
                input2 += "_";
                counter--;
            } else
                input2 += input.charAt(i);
        }
        int counter2 = counter;

        String currentWord = "";
        while (scanner.hasNextLine()) {
    
            currentWord = scanner.nextLine();
            counter2 = counter;
            
            for (int i = 0; i < 5; i++) {
                if (input2.charAt(i) == currentWord.charAt(i)) {
                    counter2--;
                }
            }
            int counter3 = 0;
            for(int i = 0; i < 5; i++) {
                for (int j = 0; j < ValidLettersStr.length(); j++) {
                    if (currentWord.indexOf(ValidLettersStr.charAt(j)) == -1)
                        counter3++;
                }
            }
            int counter4 = 0;
            for(int i = 0; i <5; i++) {
                for (int k = 0; k < AbsentLettersStr.length(); k++) {
                    if (currentWord.indexOf(AbsentLettersStr.charAt(k)) != -1)
                        counter4++;
                }
            }
            if(counter2 == 0 && counter3 == 0 && counter4 == 0) {
                possibleWords.add(currentWord);
                System.out.println(currentWord);
            }
        }

    }

    public static int lineCounter(String filename) throws Exception {
        int lines = 0;
        File file = new File("words.txt");
        Scanner reader = new Scanner(file);
        String words = "";
        while (reader.hasNextLine()) {
            reader.nextLine();
            lines++;
        }
        return lines;
    }
}