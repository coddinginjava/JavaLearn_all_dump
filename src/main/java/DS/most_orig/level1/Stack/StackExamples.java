package DS.most_orig.level1.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackExamples {
    public static void main(String[] args) {
        String st = "{{[[1 +2]]}}";

        boolean bol = getbalancing(st);

        System.out.println("bol = " + bol);

    }

    private static boolean getbalancing(String st) {
        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        map.put('>','<');

        Stack<Character> s = new Stack<>();

        for (Character c : st.toCharArray()) {

            if (c == '{' || c == '[' || c == '(' || c == '<') {
                s.push(c);
            }
            else if (map.containsKey(c) ){
                if(s.empty()) return false;
                if(s.pop()!=map.get(c)) return false;
            }
        }
        if(!s.isEmpty()) return false;

        return true;
    }


}
