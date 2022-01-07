package programmers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveThemInPairs {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }
    public static int solution(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty()) {
                st.push(s.charAt(i));
            } else {
                if (st.peek() == s.charAt(i)) {
                    st.pop();
                } else {
                    st.push(s.charAt(i));
                }
            }
        }

        if (st.isEmpty())
            return 1;
        return 0;
    }
}
