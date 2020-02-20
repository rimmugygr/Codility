package lesson.lesson4_counting;

import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given.
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 * For example, array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 * is a permutation, but array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 * is not a permutation, because value 2 is missing.
 *
 * The goal is to check whether array A is a permutation.
 *
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
 * For example, given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 * the function should return 1.
 *
 * Given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 * the function should return 0.
 *
 * Write an efficient algorithm for the following assumptions:
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 * */
public class PermCheck {

    public static void main(String[] args) {

        int[]A=new int[1];
        A[0] = 1;
//        A[1] = 3;
//        A[2] = 1;
//        A[3] = 4;
//        A[4] = 5;
//        A[5] = 6;
//        A[6] = 7;
//        A[7] = 8;
        System.out.println(solution(A)+"<<<");
    }
    public static int  solution(int[] tab) {
        boolean[] isElement=new boolean[tab.length];
        System.out.println(Arrays.toString(isElement));
        for (int input : tab) {
            if (input<=tab.length) {
                if (isElement[input - 1]) return 0;
                isElement[input-1]=true;
            }
        }
        System.out.println(Arrays.toString(isElement));
        for (boolean element : isElement) {
            if(!element) return 0;
        }
        return 1;
    }
}
