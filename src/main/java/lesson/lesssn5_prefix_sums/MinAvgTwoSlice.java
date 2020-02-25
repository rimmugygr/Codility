package lesson.lesssn5_prefix_sums;

import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N,
 * is called a slice of array A (notice that the slice contains at least two elements).
 * The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice.
 * To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 *
 * For example, array A such that:
 *
 *     A[0] = 4
 *     A[1] = 2
 *     A[2] = 2
 *     A[3] = 5
 *     A[4] = 1
 *     A[5] = 5
 *     A[6] = 8
 * contains the following example slices:
 *
 * slice (1, 2), whose average is (2 + 2) / 2 = 2;
 * slice (3, 4), whose average is (5 + 1) / 2 = 3;
 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is minimal.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N integers, returns the starting position of the
 * slice with the minimal average. If there is more than one slice with a minimal average,
 * you should return the smallest starting position of such a slice.
 *
 * For example, given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 2
 *     A[2] = 2
 *     A[3] = 5
 *     A[4] = 1
 *     A[5] = 5
 *     A[6] = 8
 * the function should return 1, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 * */
public class MinAvgTwoSlice {

    public static void main(String[] args) {
        int[] A = new int[7];
     A[0] = 0;
      A[1] = 0;
    A[2] = 0;
       A[3] = 0;
    A[4] = -1;
     A[5] = 0;
      A[6] = -1;

      int[] B={1000,-1000};
        System.out.println(solutionOld(A)+"<<<");
    }


    public static int solutionOld(int[] tabInput) {
        float[] resultTab=new float[tabInput.length-1];

        for (int i = 0; i < tabInput.length-1; i++) {
            int sum=tabInput[i];
            resultTab[i]=10_000;

            for (int j = i; j < tabInput.length-1; j++) {
                sum=sum+tabInput[j+1];
                float temp=(float) sum/(j+2-i);
                if (resultTab[i]>temp) resultTab[i]=temp;
            }
        }


        float minValue=Integer.MAX_VALUE;
        int result=0;
        for (int i = resultTab.length - 1; i >= 0; i--) {
            if (resultTab[i]<=minValue){
                minValue=resultTab[i];
                result=i;
            }
        }


        return result;
    }

}
