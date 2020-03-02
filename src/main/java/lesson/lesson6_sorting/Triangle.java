package lesson.lesson6_sorting;


import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
 *
 * A[P] + A[Q] > A[R],
 * A[Q] + A[R] > A[P],
 * A[R] + A[P] > A[Q].
 * For example, consider array A such that:
 *
 *   A[0] = 10    A[1] = 2    A[2] = 5
 *   A[3] = 1     A[4] = 8    A[5] = 20
 * Triplet (0, 2, 4) is triangular.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.
 *
 * For example, given array A such that:
 *
 *   A[0] = 10    A[1] = 2    A[2] = 5
 *   A[3] = 1     A[4] = 8    A[5] = 20
 * the function should return 1, as explained above. Given array A such that:
 *
 *   A[0] = 10    A[1] = 50    A[2] = 5
 *   A[3] = 1
 * the function should return 0.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */

public class Triangle {
    protected final static Logger LOG= Logger.getLogger(Triangle.class);
    public static void main(String[] args) {
        int[] A1 = new int[6];
        A1[0] = 10;    A1[1] = 2;    A1[2] = 5;
        A1[3] = 1;     A1[4] = 8;    A1[5] = 20;

        int[] A0 = new int[4];
        A0[0] = 10;    A0[1] = 50;    A0[2] = 5;
        A0[3] = 1;
        LOG.info(solution(A1)+"<<<");
        LOG.info(solution(A0)+"<<<");


    }
    public static int  solution(int[] tabInput) {

        Arrays.sort(tabInput);
        if (tabInput.length < 3) return 0;
        LOG.info(Arrays.toString(tabInput));

        for (int i = 0; i < tabInput.length -2; i++) {
            if (tabInput[i] > tabInput[i + 2] - tabInput[i + 1]) return 1;
        }

        return 0;
    }

}
