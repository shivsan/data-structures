import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Yoodel {
    public void printAllPermutationsRecursively(char[] chars) {
        List<Character> charList = IntStream.range(0, chars.length).mapToObj(i -> chars[i]).collect(Collectors.toList());

        print(charList, new StringBuilder());
    }

    private void print(List<Character> chars, StringBuilder createdString) {
        if (chars.isEmpty()) {
            System.out.println(createdString.toString());
            return;
        }

        for (int i = 0; i < chars.size(); i++) {
            char element = chars.get(i);
            createdString.append(element);
            chars.remove(i);
            print(chars, createdString);
            chars.add(i, element);
            createdString.deleteCharAt(createdString.length() - 1);
        }
    }

    public void printAllPermutationsIteratively(char[] chars) {
        List<String> finalWordList = new LinkedList<>();
        finalWordList.add("");

        for (char newCharacter : chars) {
            List<String> wordListWithOneMoreCharacter = new LinkedList<>();

            for (String word : finalWordList) {
                for (int wordIndex = 0; wordIndex < word.length(); wordIndex++) {
                    wordListWithOneMoreCharacter.add(word.substring(0, wordIndex) + newCharacter + word.substring(wordIndex));
                }

                wordListWithOneMoreCharacter.add(word + newCharacter);
            }

            finalWordList = wordListWithOneMoreCharacter;
        }

        System.out.println(Arrays.deepToString(finalWordList.toArray()));
    }
}

// create a sorted set of the 6 characters
// fillWithElementFromSet(sortedSet, resultString)
//      when(sortedSet.isEmpty)
//          print result

//      sortedSet = copy(set)
//      iterate through elements of set
//          sortedSet.remove(element)
//          result += element
//          fillWithElementFromSet(sortedSet, result)
//          result -= element
//          sortedSet.add(element)
//

// a,e,i,o,u,f
//
//result: ""
//set: a,e,i,o,u,f
//
//result: "a"
//set: e,i,o,u,f
//result: "ae"
//set: i,o,u,f
//.
//.
//.
//result: "aeiouf"
//set: {}
//
//result: "aeiou"
//set: {f}
//
//result: "aeio"
//set: {u, f}
//
//
//aeiouf