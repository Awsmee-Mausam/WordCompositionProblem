import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CompoundedWords_02 {
    private static Set<String> wordsSet = new HashSet<>();
    private static List<String> sortedWords = new ArrayList<>();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        readWordsFromFile("Input_02.txt");
        Collections.sort(sortedWords, Comparator.comparingInt(String::length).reversed());

        String longest = findLongestCompoundWord();
        String secondLongest = findSecondLongestCompoundWord();

        long endTime = System.currentTimeMillis();

        System.out.println("Longest Compound Word: " + longest);
        System.out.println("Second Longest Compound Word: " + secondLongest);
        System.out.println("Time taken to process the input file: " + (endTime - startTime) + " milliseconds");
    }

    private static void readWordsFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordsSet.add(line.trim());
                sortedWords.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isCompoundWord(String word) {
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (wordsSet.contains(prefix) && (wordsSet.contains(suffix) || isCompoundWord(suffix))) {
                return true;
            }
        }
        return false;
    }

    private static String findLongestCompoundWord() {
        for (String word : sortedWords) {
            if (isCompoundWord(word)) {
                return word;
            }
        }
        return "";
    }

    private static String findSecondLongestCompoundWord() {
        String longest = findLongestCompoundWord();
        wordsSet.remove(longest);
        sortedWords.remove(longest);
        return findLongestCompoundWord();
    }
}
