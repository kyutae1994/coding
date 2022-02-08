package programmers.level2;
import java.util.*;
public class CorrectParenthesis {
    public static void main(String[] args) {
        System.out.println(solution(")()("));
    }
    static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                st.push(c);
            } else {
                if (st.isEmpty()) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }

        return !st.isEmpty() ? false : true;
    }
}
