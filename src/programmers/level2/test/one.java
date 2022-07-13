package programmers.level2.test;

public class one {
    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
    }
    public static int solution(int n, int k) {
        int answer = 0;
        String jin = Integer.toString(n, k);
        StringBuilder sb = new StringBuilder();
//        String com = "";
        for(int i = 0; i < jin.length(); i++) {
            if (jin.charAt(i) != '0') {
                sb.append(jin.charAt(i));
            } else {
                if (sb.toString().equals(""))
                    continue;
                if (sb.toString().equals("2")) {
                    answer++;
                } else if(Integer.parseInt(sb.toString()) % 2 != 0 && isPrime(sb.toString())) {
                    answer++;
                }
                sb.setLength(0);
            }
        }

        if (sb.toString().equals("2")) {
            answer++;
        } else if(Integer.parseInt(sb.toString()) % 2 != 0 && isPrime(sb.toString())) {
            answer++;
        }

        return answer;
    }

    public static boolean isPrime(String com) {
        int num = Integer.parseInt(com);
        if (num == 0 || num == 1)
            return false;
        for (int i = 3; i <= (int)Math.sqrt(num); i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
