package 동화;

public class two {
    public static void main(String[] args) {
        System.out.println(solution(2, 2));
    }
    static boolean[] visited;
    static int[] pick;
    static int count;

    public static int solution(int n, int k) {
        visited = new boolean[n];
        pick = new int[n];
        count = 0;

        permutation(n, 0);
        return count;
    }

    public static void permutation(int n, int idx) {
        if (n == idx) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                pick[idx] = i;
                if(check(idx)) permutation(n, idx + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean check(int idx) {
        for(int i = 0; i < idx; i++) {
            if(pick[i] == pick[idx]) return false;
        }
        return true;
    }
}
