package lesson.lesson10_prime_and_composite_numbers;


import org.apache.log4j.Logger;

import java.util.*;

/**
 * A non-empty array A consisting of N integers is given.
 *
 * A peak is an array element which is larger than its neighbours. More precisely,
 * it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].
 *
 * For example, the following array A:
 *
 *     A[0] = 1
 *     A[1] = 5
 *     A[2] = 3
 *     A[3] = 4
 *     A[4] = 3
 *     A[5] = 4
 *     A[6] = 1
 *     A[7] = 2
 *     A[8] = 3
 *     A[9] = 4
 *     A[10] = 6
 *     A[11] = 2
 * has exactly four peaks: elements 1, 3, 5 and 10.
 *
 * You are going on a trip to a range of mountains whose relative heights are represented by array A,
 * as shown in a figure below. You have to choose how many flags you should take with you.
 * The goal is to set the maximum number of flags on the peaks, according to certain rules.
 *
 *
 *
 * Flags can only be set on peaks. What's more, if you take K flags,
 * then the distance between any two flags should be greater than or equal to K.
 * The distance between indices P and Q is the absolute value |P − Q|.
 *
 * For example, given the mountain range represented by array A, above, with N = 12, if you take:
 *
 * two flags, you can set them on peaks 1 and 5;
 * three flags, you can set them on peaks 1, 5 and 10;
 * four flags, you can set only three flags, on peaks 1, 5 and 10.
 * You can therefore set a maximum of three flags in this case.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A of N integers,
 * returns the maximum number of flags that can be set on the peaks of the array.
 *
 * For example, the following array A:
 *
 *     A[0] = 1
 *     A[1] = 5
 *     A[2] = 3
 *     A[3] = 4
 *     A[4] = 3
 *     A[5] = 4
 *     A[6] = 1
 *     A[7] = 2
 *     A[8] = 3
 *     A[9] = 4
 *     A[10] = 6
 *     A[11] = 2
 * the function should return 3, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..400,000];
 * each element of array A is an integer within the range [0..1,000,000,000].
 */

public class Flags {
    protected final static Logger LOG = Logger.getLogger(Flags.class);

    public static void main(String[] args) {

    }

    public static int solution(int[] input) {
        int result=0;
        int length = input.length;

        List<Integer> peak = new ArrayList<>();//list of peak //example {3,6,8}
        for (int i = 1; i < input.length -1; i++) {
            if (input[i] > input[i+1] && input[i] > input[i-1]) peak.add(i);
        }
        //LOG.info(Arrays.toString(peak.toArray()) + " - peak");

        if(peak.isEmpty()) return 0;//case no peak
        if(peak.size() == 1) return 1;//case 1 peak

        int[] next = new int[length];//table fill witch value of peaks between him and end with 0 // example{3,3,3,6,6,6,8,0}
        next[length-1] = 0;
        for (int i = length-2; i > -1; i--) {
            if(peak.contains(i)){
                next[i] = i;
            } else {
                next[i] = next[i+1];
            }
        }
        //LOG.info(Arrays.toString(next) + " - filled peak");

        int i = 1;
        while ((i-1)*i <= length) {
            int position = 0;
            int number = 0;
            while (position < length && number < i) {
                position = next[position];
                if (position == 0)
                    break;
                number += 1;
                position += i;
            }
            result = Math.max(result, number);
            i++;
        }

        return result;
    }
}
