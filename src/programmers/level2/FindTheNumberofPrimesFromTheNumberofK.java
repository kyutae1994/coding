package programmers.level2;

public class FindTheNumberofPrimesFromTheNumberofK { // 3페이지 & k진수에서 소수 개수 구하기
    public static void main(String[] args) {
        System.out.println(solution(110011, 10));
    }
    public static int solution(int n, int k) {
        int answer = 0;
//        String a = Integer.toString(n, k);
        String a = "00011002";
        String temp = "";
        for(int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (c == '0') {
                if(!temp.equals("") && isPrime(temp))
                    answer++;
                temp = "";
            } else {
                temp += c;
            }
        }
        if (!temp.equals("") && isPrime(temp))
            answer++;
        return answer;
    }

    public static boolean isPrime(String temp) {
        long cnt = Long.parseLong(temp);
        if (cnt == 2) return true;
        if (cnt == 0 || cnt == 1 || cnt % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(cnt); i+=2) {
            if (cnt % i == 0)
                return false;
        }
        return true;
    }
}
