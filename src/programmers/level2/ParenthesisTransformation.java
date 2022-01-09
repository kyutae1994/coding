package programmers.level2;

import java.util.Stack;

public class ParenthesisTransformation {
    public static void main(String[] args) {
        System.out.println(solution("()))((()"));
    }
    public static String solution(String p) {

        if (check(p))
            return p;
        return dfs(p);
    }

    public static String dfs(String w) {

        if (w.length() == 0)
            return "";
        String u = "";
        String v = "";
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                cnt1++;
            } else {
                cnt2++;
            }
            if (cnt1 == cnt2 && cnt1 != 0 && cnt2 != 0) {
                u = w.substring(0, i + 1);
                v = w.substring(i + 1, w.length());
                break;
            }
        }

        if (!check(u)) {
            String temp = "(" + dfs(v);
            temp += ")";
            u = u.substring(1, u.length() - 1);
            u = u.replace("(", ".");
            u = u.replace(")", "(");
            u = u.replace(".", ")");
            temp += u;
            return temp;
        } else {
            return u + dfs(v);
        }
    }

    public static boolean check(String p) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        if (!st.isEmpty())
            return false;
        return true;
    }
}
