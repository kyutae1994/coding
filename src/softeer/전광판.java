package softeer;

import java.util.*;
import java.io.*;

public class 전광판 {
    static Map<Integer, int[]> map = new HashMap<>();

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        map.put(0, new int[] {1,1,1,0,1,1,1});
        map.put(1, new int[] {0,0,1,0,0,1,0});
        map.put(2, new int[] {1,0,1,1,1,0,1});
        map.put(3, new int[] {1,0,1,1,0,1,1});
        map.put(4, new int[] {0,1,1,1,0,1,0});
        map.put(5, new int[] {1,1,0,1,0,1,1});
        map.put(6, new int[] {1,1,0,1,1,1,1});
        map.put(7, new int[] {1,1,1,0,0,1,0});
        map.put(8, new int[] {1,1,1,1,1,1,1});
        map.put(9, new int[] {1,1,1,1,0,1,1});
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            int[] arrA = new int[5];
            int[] arrB = new int[5];

            Arrays.fill(arrA, -1);
            Arrays.fill(arrB, -1);

            for(int j = 0; j < 5; j++) {
                arrA[j] = A % 10;
                A /= 10;
                if(A == 0)
                    break;
            }
            for(int j = 0; j < 5; j++) {
                arrB[j] = B % 10;
                B /= 10;
                if(B == 0)
                    break;
            }

            int sum = 0;

            for(int j = 0; j < 5; j++) {
                if(arrA[j] != arrB[j]) {
                    if(arrA[j] == -1) {
                        sum += plus(arrB[j]);
                    } else if(arrB[j] == -1) {
                        sum += plus(arrA[j]);
                    } else {
                        sum += compar(arrA[j], arrB[j]);
                    }
                }
            }
            System.out.println(sum);
        }
    }

    private static int compar(int a, int b) {
        int[] arrA = map.get(a);
        int[] arrB = map.get(b);
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            if (arrA[i] != arrB[i]) {
                sum++;
            }
        }
        return sum;
    }

    public static int plus(int a) {
        int[] arr = map.get(a);
        int res = 0;
        for(int i = 0; i < map.get(a).length; i++) {
            res += arr[i];
        }
        return res;
    }
}
