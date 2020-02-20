package lesson.lesson4_counting;


import java.util.Arrays;

/**
 * You are given N counters, initially set to 0, and you have two possible operations on them:
 *
 * increase(X) − counter X is increased by 1,
 * max counter − all counters are set to the maximum value of any counter.
 * A non-empty array A of M integers is given. This array represents consecutive operations:
 *
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 * if A[K] = N + 1 then operation K is max counter.
 * For example, given integer N = 5 and array A such that:
 *
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 4
 *     A[3] = 6
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 4
 * the values of the counters after each consecutive operation will be:
 *
 *     (0, 0, 1, 0, 0)
 *     (0, 0, 1, 1, 0)
 *     (0, 0, 1, 2, 0)
 *     (2, 2, 2, 2, 2)
 *     (3, 2, 2, 2, 2)
 *     (3, 2, 2, 3, 2)
 *     (3, 2, 2, 4, 2)
 * The goal is to calculate the value of every counter after all operations.
 *
 * Write a function:
 *
 * class Solution { public int[] solution(int N, int[] A); }
 *
 * that, given an integer N and a non-empty array A consisting of M integers,
 * returns a sequence of integers representing the values of the counters.
 *
 * Result array should be returned as an array of integers.
 *
 * For example, given:
 *
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 4
 *     A[3] = 6
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 4
 * the function should return [3, 2, 2, 4, 2], as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N and M are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..N + 1].
 *
 *
 *
 * */
public class MaxCounters {
    public static void main(String[] args) {
        int X= 5;
        int[]A=new int[8];
        A[0] = 2;
        A[1] = 3;
        A[2] = 1;
        A[3] = 4;
        A[4] = 2;
        A[5] = 6;
        A[6] = 6;
        A[7] = 5;
        System.out.println(Arrays.toString(solutionArrayFill(X,A))+"<<<");
        System.out.println(Arrays.toString(solutionVector(X,A))+"<<<<");
    }
    public static int[]  solutionArrayFill(int range, int[] tab) {                //tab[] value 1..range+1
        int[] result=new int[range];                       //result [0...range-1] lenght=range
        int max=0;
        for (int input : tab) {
            if(input==range+1) {
                Arrays.fill(result, max);
            } else if (++result[input-1]>max) ++max;

        }
        return result;
    }


    public static int[] solutionVector(int range, int[] tab) {                //tab[] value 1..range+1
        int[] result=new int[range];                       //result [0...range-1] lenght=range
        int vectorResult=0;
        int max=0;
        for (int input : tab) {
            if(input==range+1) {//warunek maksowania
                if(max!=0) {//jesli poprzednio maksowanie to nie rob
                    result = new int[range];
                    vectorResult += max;
                    max = 0;
                }
            } else if (++result[input-1]>max) ++max;

            System.out.println(Arrays.toString(result) + input + " M:" + max + " V:"+ vectorResult);
        }
        for (int i = 0; i < result.length; i++) {
            result[i]+=vectorResult;
        }


        return result;
    }
}
