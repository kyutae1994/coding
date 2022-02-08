package programmers.level2;

public class NextBigNumber { // 3페이지 & 다음 큰 숫자
    public static void main(String[] args) {
        System.out.println(solution(78));
    }
    public static int solution(int n) {
        String s = Integer.toString(n, 2);
        int cnt1 = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                cnt1++;
            }
        }
        int next = n;
        while(true) {
            next++;
            String sb = Integer.toString(next, 2);
            int cnt2 = 0;
            for(int i = 0; i < sb.length(); i++) {
                if(sb.charAt(i) == '1') {
                    cnt2++;
                }
            }
            if(cnt1 == cnt2)
                break;
        }
        return next;
    }
}
