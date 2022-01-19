package programmers.level2;

import java.util.Stack;

public class RotateParentheses {
    public static void main(String[] args) {
//        System.out.println(solution("[](){}"));
//        System.out.println(solution("}]()[{"));
//        System.out.println(solution("[)(]"));
        System.out.println(solution("([{)}]"));
    }
    public static int solution(String s) {

        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> st = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (st.isEmpty()) {
                    st.push(ch);
                    continue;
                }
                if (ch == ']' && st.peek() == '[') {
                    st.pop();
                } else if (ch == ')' && st.peek() == '('){
                    st.pop();
                } else if (ch == '}' && st.peek() == '{') {
                    st.pop();
                } else {
                    st.push(ch);
                }
            }
            if (st.isEmpty())
                answer++;
            s = s.substring(s.length() - 1, s.length()) + s.substring(0, s.length() - 1);
        }

        return answer;
    }
}
