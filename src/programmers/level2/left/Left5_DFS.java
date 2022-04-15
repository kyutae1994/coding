package programmers.level2.left;

import java.util.*;

public class Left5_DFS {
    public static void main(String[] args) {
        int[] info = {0,0,1,2,0,1,1,1,1,1,1};
        System.out.println(Arrays.toString(solution(9, info)));
    }

    static List<int[]> list = new ArrayList<>();
    static int[] ryan = new int[11];
    static int max = Integer.MIN_VALUE;

    public static int[] solution(int n, int[] info) {
        dfs(info, 1, n, 0);
        if(list.isEmpty())
            return new int[] {-1};
        Collections.sort(list, (o1, o2) -> {
            for(int i = 10; i >= 0; i--) {
                if(o1[i] != o2[i])
                    return -1;
            }
            return 0;
        });
        return list.get(0);
    }
    public static void dfs(int[] info, int cnt, int n, int s) {
        if(cnt == n + 1) {
            int ryan_point = 0;
            int apache_point = 0;
            for(int i = 0; i < 11; i++) {
                if(ryan[i] != 0 || info[i] != 0) {
                    if(info[i] < ryan[i]) {
                        ryan_point += 10 - i;
                    } else {
                        apache_point += 10 - i;
                    }
                }
            }
            if(ryan_point > apache_point) {
                if(ryan_point - apache_point > max) {
                    max = ryan_point - apache_point;
                    list.clear();
                    list.add(ryan.clone());
                } else if(ryan_point - apache_point == max) {
                    list.add(ryan.clone());
                }
            }
        } else {
            for(int i = s; i < 11; i++) {
                ryan[i]++;
                dfs(info, cnt + 1, n, i);
                ryan[i]--;
            }
        }
    }
}
