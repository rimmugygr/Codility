package lesson.lesson9_maximum_slice_problem;


import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N,
 * is called a slice of array A. The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns the maximum sum of any slice of A.
 *
 * For example, given array A such that:
 *
 * A[0] = 3  A[1] = 2  A[2] = -6
 * A[3] = 4  A[4] = 0
 * the function should return 5 because:
 *
 * (3, 4) is a slice of A that has sum 4,
 * (2, 2) is a slice of A that has sum −6,
 * (0, 1) is a slice of A that has sum 5,
 * no other slice of A has sum greater than (0, 1).
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000];
 * the result will be an integer within the range [−2,147,483,648..2,147,483,647].
 */

public class MaxSliceSum {
    protected final static Logger LOG = Logger.getLogger(MaxSliceSum.class);

    public static void main(String[] args) {

        int[] A = new int[5];
        A[0] = 3;
        A[1] = 2;
        A[2] = -6;
        A[3] = 4;
        A[4] = 0;
        LOG.info(solutionV1(A));
        LOG.info(solutionV1(new int[]{1,-1}));
        LOG.info(solutionV3(new int[]{-1,-1}));
        LOG.info(solutionV1(new int[]{1,2,3}));
        LOG.info("====Version2=====");
        LOG.info(solutionV2(A));
        LOG.info(solutionV2(new int[]{1,-1}));
        LOG.info(solutionV3(new int[]{-1,-1}));
        LOG.info(solutionV2(new int[]{1,2,3}));
        LOG.info("=======Version3====");
        LOG.info(solutionV3(A));
        LOG.info(solutionV3(new int[]{1,-1}));
        LOG.info(solutionV3(new int[]{-1,-1}));
        LOG.info(solutionV3(new int[]{1,2,3}));
        LOG.info(solutionV3(new int[]{-1,-2,-3,-4,-5,-6}));
    }
    public static int solutionV3(int[] input) {
        //dla 1 elentu suma zwsze warością tego elementu
        if (input.length == 1) return input[0];

        //suma elementów od lewej
        long[] leftSum = new long[input.length];
        leftSum[0] = input[0];
        for (int i = 1; i < leftSum.length; i++) {
            leftSum[i] = +leftSum[i - 1] + input[i];
        }

        long actualSum = leftSum[0];
        long minSum = leftSum[0];
        long maxSum = actualSum;

        for (int i = 1; i < input.length; i++) {
            actualSum = leftSum[i];//suma elemntów do i-tego elementu
            if (maxSum < actualSum) maxSum = actualSum;//czy to największa suma

            if (minSum > leftSum[i-1]) minSum = leftSum[i-1];//zapamietujemy najmniejsza sume
            actualSum = leftSum[i]-minSum;//suma elemntów minus najmniejszy po warości przedział
            if (maxSum < actualSum) maxSum = actualSum;//czy to największa suma

        }

        return(int) maxSum;
    }

    public static int solutionV2(int[] input) {
        //dla 1 elentu suma zwsze warością tego elementu
        if (input.length == 1) return input[0];

        //suma elementów od lewej
        int[] leftSum = new int[input.length];
        leftSum[0] = input[0];
        for (int i = 1; i < leftSum.length; i++) {
            leftSum[i] = +leftSum[i - 1] + input[i];
        }

        int maxSum = Integer.MIN_VALUE;
        int actualSum = 0;
        for (int i = 0; i < input.length; i++) {
            actualSum = leftSum[i];//suma elemntów do i-tego elementu
            if (maxSum < actualSum) maxSum = actualSum;//czy to największa suma
            for (int j = 0; j < i; j++) {
                actualSum = leftSum[i]-leftSum[j];//suma elemntów od j do i-tego elementu // przedziały: (j-i)=(0-j)-(0-i)
                if (maxSum < actualSum) maxSum = actualSum;//czy to największa suma
            }
        }

        return maxSum;
    }

    public static int solutionV1(int[] input) {
        if (input.length == 1) return input[0];
        int maxSum = Integer.MIN_VALUE;
        int actualSum = 0;
        for (int i = 0; i < input.length; i++) {
            actualSum = 0;
            for (int j = i; j < input.length; j++) {
                actualSum += input[j];
                if (maxSum < actualSum) maxSum = actualSum;
            }
        }
        return maxSum;
    }
}
