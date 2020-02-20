package lesson.lesson4_counting;

import java.util.Arrays;



/**
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 *
 *
 *
 * */
public class MissingInteger {

    public static void main(String[] args) {
        int X= 5;
        int[]A=new int[8];
        A[0] = 2;
        A[1] = 3;
        A[2] = 1;
        A[3] = 4;
        A[4] = 2;
        A[5] = -6;
        A[6] = -6;
        A[7] = 5;
        System.out.println(solution(A)+"<<<");
    }
    public static int  solution(int[] tab) {
        int max=0;
        for (int input : tab) {
            if(max<input)max=input;
        }
        if(max==0)return 1;

        boolean[] presentNumber = new boolean[max+1];

        for (int input : tab) {
            if(input>0) presentNumber[input-1]=true;
            System.out.println(Arrays.toString(presentNumber));
        }

        for (int i = 0; i < presentNumber.length; i++) {
            if(!presentNumber[i])return i+1;
        }
        return 1;
    }
}
