package programmers.level2;

import java.util.*;

public class ArcheryCompetition {
    public static void main(String[] args) {
        int[] info = {0,0,1,2,0,1,1,1,1,1,1};
        System.out.println(Arrays.toString(solution(9, info)));
    }

    static ArrayList<int[]> list = new ArrayList<>();
    static int[] apache = new int[11];
    static int[] ryan = new int[11];
    static int max = Integer.MIN_VALUE;
    static int N;

    public static int[] solution(int n, int[] info) {
        apache = info.clone();
        N = n;
        DFS(0, 0);
        if (list.isEmpty())
            return new int[] {-1};
        Collections.sort(list, (o1, o2) -> {
            for (int i = 10; i >= 0; i--) {
                if (o1[i] != o2[i])
                    return o2[i] - o1[i];
            }
            return 0;
        });
        return list.get(0);
    }

    public static void DFS(int L, int s) {
        if (L == N) {
            int a = 0;
            int r = 0;
            for (int i = 0; i < 11; i++) {
                if (apache[i] == 0 && ryan[i] == 0)
                    continue;
                else if (apache[i] < ryan[i])
                    r += 10 - i;
                else
                    a += 10 - i;
            }
            if (r > a) {
                int diff = r - a;
                if (diff > max) {
                    max = diff;
                    list.clear();
                    list.add(ryan.clone());
                } else if (diff == max)
                    list.add(ryan.clone());
            }
        } else {
            for (int i = s; i < 11; i++) {
                ryan[i]++;
                DFS(L + 1, i);
                ryan[i]--;
            }
        }
    }
}
