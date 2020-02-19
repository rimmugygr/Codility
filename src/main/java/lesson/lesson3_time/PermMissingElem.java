package lesson.lesson3_time;

import java.util.Arrays;

/**
 * An array A consisting of N different integers is given.
 * The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 *
 * Your goal is to find that missing element.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A, returns the value of the missing element.
 *
 * For example, given array A such that:
 *
 *   A[0] = 2
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 5
 * the function should return 4, as it is the missing element.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 *
 *
 */
public class PermMissingElem {
    public static void main(String[] args) {

        int[] x={1,2,3};
        System.out.println(solutionWithSum(x));
        System.out.println(solutionTabBoolen(x));
    }
    public static int solutionWithSum(int[] N) {
        double sum=0;
        int result=0;
        for (int i : N) {
            sum+=i;
            //System.out.println(sum);
        }

        for (int i = 0; i <= (N.length+1) ; i++) {
            sum-=i;
            //System.out.println(sum+" "+i);
        }

        return (int) (0- sum);

    }

    public static int solutionTabBoolen(int[] N) {
        boolean[] tab=new boolean[N.length+1];
        for (int i : N) {
            tab[i-1]=true;
        }
        //System.out.println(Arrays.toString(tab));
        for (int i = 0; i < N.length+1 ; i++) {
            if(!tab[i])return ++i;
        }
        return 0;
    }

}
