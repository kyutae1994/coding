package programmers.level2;

import java.util.*;

public class minAndMax { // 4페이지 & 최댓값과 최솟값
    public static void main(String[] args) {
        System.out.println(solution("-1 -2 -3 -4"));
    }
    public static String solution(String s) {
        String[] arr = s.split(" ");
        int[] num = Arrays.stream(arr).mapToInt(Integer :: parseInt).toArray();
        long[] n = Arrays.stream(arr).mapToLong(Long :: parseLong).toArray();
        System.out.println(Arrays.toString(n));
        Arrays.sort(num);
        int min = num[0];
        int max = num[arr.length - 1];
        return min + " " + max;
    }
}
