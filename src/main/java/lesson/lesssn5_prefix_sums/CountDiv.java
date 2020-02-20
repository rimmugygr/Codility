package lesson.lesssn5_prefix_sums;

import java.util.Arrays;

/**
 * Write a function:
 *
 * class Solution { public int solution(int A, int B, int K); }
 *
 * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
 *
 * { i : A ≤ i ≤ B, i mod K = 0 }
 *
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 * */
public class CountDiv {

    public static void main(String[] args) {

        int a=0;
        int b=7;
        int k=2;
        System.out.println(solution(a,b,k)+"<<<");
    }
    public static int  solution(int a,int b, int k) {

        return 1;
    }
}
