import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.max;

public class Merge2Arrays {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeArrays(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        ListNode head = l1.val >= l2.val ? l2 : l1;

        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                ListNode node = findNodeToAttachTo(l2, l1);
                l2 = node.next;
                node.next = l1;
            } else {
                ListNode node = findNodeToAttachTo(l1, l2);
                l1 = node.next;
                node.next = l2;
            }
        }

        return head;
    }

    private ListNode findNodeToAttachTo(ListNode node, ListNode nodeNeedingToBeAttached) {
        while (node.next != null && node.next.val <= nodeNeedingToBeAttached.val) {
            node = node.next;
        }

        return node;
    }

    // The goal is to find out how many ordered subsequences can be created such that a label(and all its occurences) exist only in that sub-sequence.
    // For finding each sub-sequence, set two boundaries - left and right.
    // Left is the index of the leftmost label in the sub-sequence
    // Right is the index of the rightmost label occurring in the sub-sequence
    // An optimization is to find out the index of the rightmost occurrence of all unique labels in the sub-sequence.
    // Then iterate through the array, with left boundary fixed.
    // When the largest of 'rights' is reached in the iteration, we've reached the right boundary.
    // Fix the element after the right boundary as the new left and repeat.

    List<Integer> lengthEachScene(List<Character> inputList) {
        HashMap<Character, Integer> labelMap = new HashMap<>();

        for (int i = 0; i < inputList.size(); i++)
            labelMap.put(inputList.get(i), i);

        List<Integer> result = new ArrayList<>();
        int left = 0, right = 0;

        for (int i = 0; i < inputList.size(); i++) {
            right = Math.max(right, labelMap.get(inputList.get(i)));

            if (right == i) {
                result.add(right - left + 1);
                left = right + 1;
            }
        }

        return result;
    }

    public static List<Integer> partitionLabels(List<Character> input) {
        HashMap<Character, Integer> labelMap = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            labelMap.put(input.get(i), i);
        }

        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < input.size(); i++) {
            right = max(right, labelMap.get(input.get(i)));
            if (right == i) {
                result.add(1 + right - left);
                left = right + 1;
            }
        }
        return result;
    }

    public List<String> getToyInQuote(String quote, List<String> toys) {
        return Arrays.stream(quote.replaceAll("[^a-zA-Z\\s]+", "").split(" "))
                .filter(qw -> toys.contains(qw.toLowerCase()))
                .distinct().collect(Collectors.toList());
    }

    public List<String> popularNToys(int numToys,
                                     int topToys,
                                     List<String> toys,
                                     int numQuotes,
                                     List<String> quotes) {
        ArrayList<String> popularToys = new ArrayList<String>();
        HashMap<String, Integer> toyOccurences = new HashMap<>();
        List<String> lowerToys = toys.stream().map(t -> t.toLowerCase()).collect(Collectors.toList());

        quotes.stream()
                .map(q -> getToyInQuote(q, lowerToys))
                .filter(t -> t.size() > 0)
                .forEach(toyOccurrenceList -> {
                    toyOccurrenceList.forEach(toyOccurrence -> {
                        if (toyOccurences.containsKey(toyOccurrence)) {
                            toyOccurences.put(toyOccurrence, toyOccurences.get(toyOccurrence) + 1);
                        } else {
                            toyOccurences.put(toyOccurrence, 1);
                        }
                    });
                });

        final List<Map.Entry<String, Integer>> sortedListOfToyOccurences = toyOccurences
                .entrySet()
                .stream()
                .sorted((a, b) -> (b.getValue() - a.getValue()) == 0 ? (b.getValue() - a.getValue()) : a.getKey().compareTo(b.getKey()))
                .collect(Collectors.toList());

        if (sortedListOfToyOccurences.size() < topToys)
            sortedListOfToyOccurences
                    .stream()
                    .map(st -> st.getKey())
                    .collect(Collectors.toList())
                    .forEach(item -> popularToys.add(item));
        else
            sortedListOfToyOccurences
                    .subList(0, topToys)
                    .stream()
                    .map(st -> st.getKey())
                    .collect(Collectors.toList())
                    .forEach(item -> popularToys.add(item));

        return popularToys;
    }

    static List<String> vowels = Arrays.stream(new String[] {"a", "e", "i", "o", "u"}).collect(Collectors.toList());

    public String toGoatLatin(String S) {
        String goated = "";
        List<String> splitStrings = Arrays.stream(S.split(" ")).collect(Collectors.toList());

        for(int i = 0; i < splitStrings.size(); i++) {
            goated = goated + " " + ruleForA(ruleForConsonant(ruleForVowel(splitStrings.get(i))), i);
        }

        return goated.trim();
    }

    private String ruleForVowel(String str) {
        if(vowels.contains(str.substring(0,1).toLowerCase()))
            return addMa(str);

        return str;
    }

    public String ruleForConsonant(String str) {
        if(str.length() <=1)
            return str;

        if(!vowels.contains(str.substring(0,1).toLowerCase()))
            return addMa(str.substring(1) + str.substring(0,1));

        return str;
    }

    private String ruleForA(String str, int index) {
        char[] charArray = new char[index + 1];
        Arrays.fill(charArray, 'a');
        String aStr = new String(charArray);

        return str + aStr;
    }

    private String addMa(String str) {
        return str + "ma";
    }
}
