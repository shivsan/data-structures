import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ClosingParanthesis {

    public boolean isValid(String s) {
        List<Character> st = new ArrayList<>();
        int index = 0;
        final List<Character> openingBrackets = Arrays.stream(new Character[]{'{', '[', '('}).collect(Collectors.toList());
        final List<Character> closingBrackets = Arrays.stream(new Character[]{'}', ']', ')'}).collect(Collectors.toList());

        while (index < s.length()) {
            if (openingBrackets.contains(s.charAt(index)))
                st.add(s.charAt(index));
            else {
                if(st.isEmpty())
                    return false;

                if (openingBrackets.indexOf(st.get(st.size() - 1)) == closingBrackets.indexOf(s.charAt(index))) {
                    st.remove(st.size() - 1);
                }
                else
                    return false;
            }
            index++;
        }

        return st.isEmpty();
    }
}
