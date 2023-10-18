# WordCompositionProblem
Overview :-
The CompoundedWords program is designed to find the longest and second-longest compounded words from a list of words provided in a text file. A compounded word is defined as a word that can be formed by concatenating two or more other words.

Execution Steps :-
To execute the program, follow these steps:

1. Compile the Java Code: Ensure you have Java installed on your system. Open a command prompt or terminal and navigate to the directory containing the CompoundedWords_01.java file. Use the following command to compile the code:

javac CompoundedWords_01.java

2. Prepare Input File: Create a text file (e.g., Input_01.txt) containing a list of words, each on a separate line. Ensure the file is placed in the same directory as the compiled Java file.

3. Run the Program: Use the following command to run the program:

java CompoundedWords_01

4. View Output: The program will process the input file and print the longest and second-longest compounded words along with the time taken for processing.

   
Design Decisions

Data Structures:-
The program uses two main data structures: a HashSet (wordsSet) and an ArrayList (sortedWords).
    wordsSet: This set is used to quickly check if a word exists in the list. It allows for constant-time lookups, which is useful for determining if a word is part of a compounded word.
    sortedWords: This list is used to sort the words by length in descending order. This ensures that longer words are checked first, which are more likely to be compounded.

Algorithm for Finding Compounded Words:-
The program uses a recursive approach to determine if a word is compounded. It iterates through all possible prefixes and suffixes of the word, checking if both the prefix and suffix are in the wordsSet. If so, it recursively checks if the suffix is also a compounded word.

Time Complexity Optimization:-
To further optimize the code, a Trie data structure is used. This allows for efficient checking if a word can be split into two existing words. This optimization reduces the time taken to process the input file.


*Approach* :-

1. Reading from File:
The program reads the list of words from a text file (Input_01.txt) using a BufferedReader. Each word is trimmed and added to both wordsSet and sortedWords.

2. Sorting Words:
The words are sorted by length in descending order using Collections.sort and a custom Comparator.

3. Finding Compounded Words:
The program uses a recursive function (isCompoundWord) to determine if a word is compounded. It iterates through all possible prefixes and suffixes.

4. Finding Longest and Second-Longest:
The longest compounded word is found by iterating through the sorted list of words and using the isCompoundWord function. The second-longest is then found by removing the longest from wordsSet and sortedWords and repeating the process.

5. Output:
The program prints the longest and second-longest compounded words along with the time taken for processing.


Conclusion:-
The CompoundedWords program efficiently identifies compounded words from a given list. By using data structures like HashSet and Trie, along with a sorted list, the program achieves a balance between memory usage and runtime efficiency. The use of a Trie structure particularly improves the time complexity, allowing the program to process the input file in a matter of milliseconds.
