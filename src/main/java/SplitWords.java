import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// TODO: What if the list is not empty and it did not match, in the case of catsanddog(gs)
public class SplitWords {
    public List<List<String>> split(List<String> dictionary, String wordToSplit) {
        List<List<String>> splitWords = new LinkedList<>();

        List<String> smallerFirstWords = getSmallerFirstWordsFromSentence(dictionary, wordToSplit);

        if (smallerFirstWords.size() == 1 && smallerFirstWords.get(0).equals(wordToSplit))
            return Collections.singletonList(Collections.singletonList(wordToSplit));

        for (String smallerFirstWord : smallerFirstWords) {
            final String restOfTheSentence = wordToSplit.substring(smallerFirstWord.length());
            List<List<String>> splitListsForTheRestOfTheSentence = split(dictionary, restOfTheSentence);

            for (List<String> splitListForTheRestOfTheSentence : splitListsForTheRestOfTheSentence) {
                addFirstWordToList(splitWords, smallerFirstWord, splitListForTheRestOfTheSentence);
            }
        }

        return splitWords;
    }

    private void addFirstWordToList(List<List<String>> splitWords, String smallerFirstWord, List<String> splitListForTheRestOfTheSentence) {
        final ArrayList<String> newList = new ArrayList<>();
        newList.add(smallerFirstWord);
        newList.addAll(splitListForTheRestOfTheSentence);
        splitWords.add(newList);
    }

    public List<String> getSmallerFirstWordsFromSentence(List<String> dictionary, String sentence) {
        String firstWord = "";
        List<String> smallerFirstWords = new LinkedList<>();

        for (int i = 0; i < sentence.length(); i++) {
            firstWord += sentence.charAt(i);

            if (dictionary.contains(firstWord))
                smallerFirstWords.add(firstWord);
        }

        return smallerFirstWords;
    }
}


// catsanddogs -> [[sand, dogs]]
// cats anddogs -> [[and, dogs]]

//[cats, cat, sand, dogs]
//
//catsanddogs -> [cat, cats]
//
//        ['cat', 'sand', 'dogs']
//
//
//        ['cats', 'and', 'dogs']