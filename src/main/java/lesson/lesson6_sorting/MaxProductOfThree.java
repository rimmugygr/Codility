package lesson.lesson6_sorting;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
 *
 * For example, array A such that:
 *
 *   A[0] = -3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = -2
 *   A[4] = 5
 *   A[5] = 6
 * contains the following example triplets:
 *
 * (0, 1, 2), product is −3 * 1 * 2 = −6
 * (1, 2, 4), product is 1 * 2 * 5 = 10
 * (2, 4, 5), product is 2 * 5 * 6 = 60
 * Your goal is to find the maximal product of any triplet.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A, returns the value of the maximal product of any triplet.
 *
 * For example, given array A such that:
 *
 *   A[0] = -3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = -2
 *   A[4] = 5
 *   A[5] = 6
 * the function should return 60, as the product of triplet (2, 4, 5) is maximal.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 *
 */

public class MaxProductOfThree {
    protected final static org.apache.log4j.Logger LOG= org.apache.log4j.Logger.getLogger(MaxProductOfThree.class);
    public static void main(String[] args) {
        int[] A = new int[6];
        A[0] = -3;
        A[1] = 1;
        A[2] = 2;
        A[3] = -2;
        A[4] = 5;
        A[5] = 6;

        int[] tab125 = {-5, 5, -5, 4};
        int[] tabMinus120 ={-5, -6, -4, -7, -10};
        int[] tab105 = {4, 7, 3, 2, 1, -3, -5};
        System.out.println(solution(A)+"<<<");
        System.out.println(solution(tab125)+"<<<");
        System.out.println(solution(tabMinus120)+"<<<");
        System.out.println(solution(tab105)+"<<<");
    }
    public static int  solution(int[] tabInput) {

        int[] plusMax={-1,-1,-1};
        int[] minusMax={1,1,1};

        for (int i = 0; i < tabInput.length; i++) {

            if (tabInput[i]>=plusMax[0]){
                if (tabInput[i]>plusMax[2]){
                    plusMax[0]=plusMax[1];
                    plusMax[1]=plusMax[2];
                    plusMax[2]=tabInput[i];
                } else if (tabInput[i]>plusMax[1]){
                    plusMax[0]=plusMax[1];
                    plusMax[1]=tabInput[i];
                } else {
                    plusMax[0]=tabInput[i];
                }
                LOG.info(Arrays.toString(plusMax));
            }

            if (tabInput[i]<minusMax[0]){
                if (tabInput[i]<minusMax[2]){
                    minusMax[0]=minusMax[1];
                    minusMax[1]=minusMax[2];
                    minusMax[2]=tabInput[i];
                } else if (tabInput[i]<minusMax[1]){
                    minusMax[0]=minusMax[1];
                    minusMax[1]=tabInput[i];
                } else {
                    minusMax[0]=tabInput[i];
                }
                LOG.info(Arrays.toString(minusMax));
            }

        }

        //+++
        if (minusMax[0]==1 && minusMax[1]==1 && minusMax[2]==1)
            return plusMax[0]*plusMax[1]*plusMax[2];
        //---
        if (plusMax[0]==-1 && plusMax[1]==-1 && plusMax[2]==-1){
            plusMax[2]=tabInput[0];
            plusMax[1]=Integer.MIN_VALUE;
            plusMax[0]=Integer.MIN_VALUE;

            for (int i = 1; i < tabInput.length; i++) {
              if (tabInput[i]>plusMax[2]){
                    plusMax[0]=plusMax[1];
                    plusMax[1]=plusMax[2];
                    plusMax[2]=tabInput[i];
                } else if (tabInput[i]>plusMax[1]){
                    plusMax[0]=plusMax[1];
                    plusMax[1]=tabInput[i];
                } else if (tabInput[i]>plusMax[0]){
                    plusMax[0]=tabInput[i];
                }
                LOG.info(Arrays.toString(plusMax) +" * ");
            }
            return plusMax[0]*plusMax[1]*plusMax[2];
       }






        //-+-
        if (plusMax[2]<=-minusMax[2] && plusMax[2]>=-minusMax[1] && plusMax[1]<=-minusMax[1])
            return minusMax[2]*plusMax[2]*minusMax[1];
        //+--
        if (plusMax[2]>=-minusMax[2] && plusMax[1]<=-minusMax[1])
            return plusMax[2]*minusMax[2]*minusMax[1];
        //--+
        if (plusMax[2]<=-minusMax[1])
            return plusMax[2]*minusMax[2]*minusMax[1];

        return plusMax[0]*plusMax[1]*plusMax[2];
    }


}
