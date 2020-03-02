package lesson.lesson6_sorting;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a function
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns the number of distinct values in array A.
 *
 * For example, given array A consisting of six elements such that:
 *
 *  A[0] = 2    A[1] = 1    A[2] = 1
 *  A[3] = 2    A[4] = 3    A[5] = 1
 * the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */

public class Distinct {
    protected final static org.apache.log4j.Logger LOG= org.apache.log4j.Logger.getLogger(Distinct.class);
    public static void main(String[] args) {
        int[] A = new int[5];
        A[0] = 0;
        A[1] = 1;
        A[2] = 0;
        A[3] = 1;
        A[4] = 1;
        System.out.println(solution(A)+"<<<");
    }
    public static int  solution(int[] tabInput) {
        Set<Integer> resultSet=new HashSet<>();
        for (int i : tabInput) {
            resultSet.add(i);
        }




        return resultSet.size();
    }

}
