package softeer;

import java.util.*;
import java.io.*;

public class 바이러스 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        long K = sc.nextLong();
        long P = sc.nextLong();
        long N = sc.nextLong();

        long total = K;
        for(int i = 0; i < N; i++) {
            total = total * P % 1000000007;
        }

        System.out.println((int)total);
    }
}
