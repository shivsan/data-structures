import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Yoodel {
    public void sortHasMap() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(-1, 1);
        map.put(0, 1);
        map.put(5, 1);

        map.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .forEach(kv -> System.out.println(kv));
    }

    public void printAllPermutations(char[] chars) {
        List<Character> charList = IntStream.range(0, chars.length).mapToObj(i -> chars[i]).collect(Collectors.toList());

        print(charList, new StringBuilder());
    }

    private void print(List<Character> chars, StringBuilder createdString) {
        if (chars.isEmpty()) {
            System.out.println(createdString.toString());
            return;
        }

        List<Character> cloneList = new LinkedList<>();
        cloneList.addAll(chars);

        for (int i = 0; i < chars.size(); i++) {
            char element = cloneList.get(i);
            createdString.append(element);
            cloneList.remove(i);
            print(cloneList, createdString);
            cloneList.add(i, element);
            createdString.deleteCharAt(createdString.length() - 1);
        }

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