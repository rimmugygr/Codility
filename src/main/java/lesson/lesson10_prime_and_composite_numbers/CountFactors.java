package lesson.lesson10_prime_and_composite_numbers;


import org.apache.log4j.Logger;

/**
 * A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.
 *
 * For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).
 *
 * Write a function:
 *
 * class Solution { public int solution(int N); }
 *
 * that, given a positive integer N, returns the number of its factors.
 *
 * For example, given N = 24, the function should return 8, because 24 has 8 factors,
 * namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..2,147,483,647].
 */

public class CountFactors {
    protected final static Logger LOG = Logger.getLogger(CountFactors.class);

    public static void main(String[] args) {

    }

    public static int solution(int input) {
        int result=0;
        double max =  Math.sqrt(input);//max is vaule of max divisior with symetric one

        for (int i = 1; i < max; i++) {//count symetric divisior
            if (input%i == 0) result = result + 2;
        }

        if(input == (int)max*(int)max) result++;// cheak if is 1 unsymetric divisior
        return result;
    }
}
