package lesson.lesson8_leader;


import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An array A consisting of N integers is given.
 * The dominator of array A is the value that occurs in more than half of the elements of A.
 *
 * For example, consider array A such that
 *
 *  A[0] = 3    A[1] = 4    A[2] =  3
 *  A[3] = 2    A[4] = 3    A[5] = -1
 *  A[6] = 3    A[7] = 3
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of
 * A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 *
 * Write a function
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns index of any element of array
 * A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.
 *
 * For example, given array A such that
 *
 *  A[0] = 3    A[1] = 4    A[2] =  3
 *  A[3] = 2    A[4] = 3    A[5] = -1
 *  A[6] = 3    A[7] = 3
 * the function may return 0, 2, 4, 6 or 7, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 *
 */

public class Dominator {
    protected final static Logger LOG= Logger.getLogger(Dominator.class);
    public static void main(String[] args) {

        int[] A=new int[8];
         A[0] = 4;    A[1] = 4;    A[2] =  3;
         A[3] = 2;    A[4] = 3;    A[5] = -1;
         A[6] = 3;    A[7] = 3;
        LOG.info(solution(A)+"<<<");


    }
    public static int  solution(int[] inputTab) {
        int[] temp=new int[inputTab.length];
        for (int i = 0; i < inputTab.length; i++) {
            temp[i]=inputTab[i];
        }

        if (inputTab.length==0||inputTab.length==2) return -1;
        if (inputTab.length==1) return 0;
        Arrays.sort(inputTab);

        int count=0;
        int value=inputTab[inputTab.length/2];
        for (int i = inputTab.length/2; i < inputTab.length; i++) {
            if (inputTab[i]==value)count++;
            else break;
        }
        for (int i = (inputTab.length/2 - 1); i >= 0 ; i--) {
            if (inputTab[i]==value)count++;
            else break;
        }
        if(count>inputTab.length/2) {
            for (int i = 0; i <temp.length ; i++) {
                if(value==temp[i]) return i;
            }
        }

        return -1 ;
    }

}
