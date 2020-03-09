package lesson.lesson9_maximum_slice_problem;


import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given.
 *
 * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
 *
 * The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
 *
 * For example, array A such that:
 *
 *     A[0] = 3
 *     A[1] = 2
 *     A[2] = 6
 *     A[3] = -1
 *     A[4] = 4
 *     A[5] = 5
 *     A[6] = -1
 *     A[7] = 2
 * contains the following example double slices:
 *
 * double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
 * double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
 * double slice (3, 4, 5), sum is 0.
 * The goal is to find the maximal sum of any double slice.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.
 *
 * For example, given:
 *
 *     A[0] = 3
 *     A[1] = 2
 *     A[2] = 6
 *     A[3] = -1
 *     A[4] = 4
 *     A[5] = 5
 *     A[6] = -1
 *     A[7] = 2
 * the function should return 17, because no double slice of array A has a sum of greater than 17.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 *
 */

public class MaxDoubleSliceSum {
    protected final static Logger LOG= Logger.getLogger(MaxDoubleSliceSum.class);
    public static void main(String[] args) {

        int[] A=new int[8];
         A[0] = -3;    A[1] = -112;    A[2] = 6;
         A[3] = -1;    A[4] = 4;    A[5] = 5;
        A[6] = -1;    A[7] = 2;
        LOG.info(solution(A));
        int[] tab17 = {5, 17, 0, 3};
        LOG.info(solution(tab17));
    }
    public static int  solution(int[] input) {
        if(input.length==3) return 0;
        int maxDoubleSum=Integer.MIN_VALUE;
        int sum=0;
        for (int i = 1; i < input.length-2; i++) {
            sum=0;
            //System.out.print("A="+ (i-1));
            for (int j = i ; j < input.length -1; j++) {
                sum+=input[j];//suma (A...C)
                //System.out.print( "["+input[j]+"] ");
                for (int k = i  ; k <= j ; k++) {// każdy przypadek z (A...B...C) dla danego (A...C)
                    maxDoubleSum=Math.max(sum-input[k],maxDoubleSum);//zapamietaj największy wynik
                    //System.out.print(input[k]+" ");
                }
                //System.out.print("B="+ (j+1));
            }
            //System.out.println();
        }
        if(maxDoubleSum<0)return 0;//wynik zawsze >0
        return maxDoubleSum;
    }



}
