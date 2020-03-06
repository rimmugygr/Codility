package lesson.lesson8_leader;


import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given.
 *
 * The leader of this array is the value that occurs in more than half of the elements of A.
 *
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences
 * A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
 *
 * For example, given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 3
 *     A[2] = 4
 *     A[3] = 4
 *     A[4] = 4
 *     A[5] = 2
 * we can find two equi leaders:
 *
 * 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
 * 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
 * The goal is to count the number of equi leaders.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N integers, returns the number of equi leaders.
 *
 * For example, given:
 *
 *     A[0] = 4
 *     A[1] = 3
 *     A[2] = 4
 *     A[3] = 4
 *     A[4] = 4
 *     A[5] = 2
 * the function should return 2, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 *
 */

public class EquiLeader {
    protected final static Logger LOG= Logger.getLogger(EquiLeader.class);
    public static void main(String[] args) {

        int[] A=new int[6];
         A[0] = 4;    A[1] = 3;    A[2] =  4;
         A[3] = 4;    A[4] = 4;    A[5] =  2;
        LOG.info(solution(A)+"<<<");
        int[] b= {0,0};
        LOG.info(solution(b)+"<<<");
        int[] c={4, 4, 2, 5, 3, 4, 4, 4};
        LOG.info(solution(c)+"<<<");

    }
    public static int  solution(int[] input) {


        if (input.length==0||input.length==1) return 0;



        int result=0;

        for (int i = 0; i <input.length ; i++) {
            int[] tempA=new int[i+1];
            for (int j = 0; j <= i ; j++) {
                tempA[j]=input[j];
            }
            int[] tempB=new int[input.length-i-1];
            for (int j = i+1 ; j < input.length ; j++) {
                tempB[j-i-1]=input[j];
            }

            LOG.info(Arrays.toString(tempA) + "<-");
            LOG.info("->" + Arrays.toString(tempB));

            Integer leaderA=getLeader(tempA);
            Integer leaderB=getLeader(tempB);
            if (leaderA!=null){
                if(leaderA.equals(leaderB)) result++;
            }

            LOG.info(Arrays.toString(tempA) + "<-" + leaderA);
            LOG.info(leaderB +"->" + Arrays.toString(tempB));

        }


        return result ;
    }

    public static Integer  getLeader(int[] inputTab) {
        if (inputTab.length==0) return null;
        if (inputTab.length==1) return inputTab[0];
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
            return value;
        }

        return null ;
    }

}
