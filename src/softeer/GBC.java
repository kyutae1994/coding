package softeer;

import java.util.*;
import java.io.*;


public class GBC {
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] standard = new int[N][2];  // 기준
        int[][] real = new int[M][2]; // 비교
        int max = 0;  // 가장 차이가 큰 속도
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 2; j++) {
                standard[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < 2; j++) {
                real[i][j] = sc.nextInt();
            }
        }

        int i = 0; // standard x좌표
        int j = 0; // real x좌표
        while(i < N && j < M) {
            if(standard[i][0] < real[j][0]) {
                real[j][0] -= standard[i][0];
                max = max > (real[j][1] - standard[i][1]) ? max : (real[j][1] - standard[i][1]);
                i++;
            } else if(standard[i][0] > real[j][0]) {
                standard[i][0] -= real[j][0];
                max = max > (real[j][1] - standard[i][1]) ? max : (real[j][1] - standard[i][1]);
                j++;
            } else {
                max = max > (real[j][1] - standard[i][1]) ? max : (real[j][1] - standard[i][1]);
                i++;
                j++;
            }
        }
        System.out.println(max);
    }
}