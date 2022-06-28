package 오토에버;

public class one {
    public static void main(String[] args) {
        int[] rates = {1200,1000,1100,1200,900,1000,1500,900,750,1100};
        System.out.println(solution(1000, rates));
    }
    public static int solution(int k, int[] rates) {
        int buy = 0;
        boolean flag = false;
        for (int i = 0; i < rates.length; i++) {
            int cnt = i;
            int myWon = rates[i];
            if (rates[i] > k) {// 환율이 가지고 있는 원화보다 클 때
                continue;
            } else {  // 환율이 가지고 있는 원화보다 작을 때
                int current = rates[i];
                while (rates[++cnt] < current) {
                    current = rates[cnt];
                    i++;
                }
                buy = rates[cnt];
                k -= buy;
            }
        }
        return 1;
    }
}
