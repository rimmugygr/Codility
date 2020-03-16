package lesson.lesson10_prime_and_composite_numbers;


import org.apache.log4j.Logger;

/**
 * An integer N is given, representing the area of some rectangle.
 *
 * The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).
 *
 * The goal is to find the minimal perimeter of any rectangle whose area equals N.
 * The sides of this rectangle should be only integers.
 *
 * For example, given integer N = 30, rectangles of area 30 are:
 *
 * (1, 30), with a perimeter of 62,
 * (2, 15), with a perimeter of 34,
 * (3, 10), with a perimeter of 26,
 * (5, 6), with a perimeter of 22.
 * Write a function:
 *
 * class Solution { public int solution(int N); }
 *
 * that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.
 *
 * For example, given an integer N = 30, the function should return 22, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..1,000,000,000]
 *
 *
 */

public class MinPerimeterRectangle {
    protected final static Logger LOG = Logger.getLogger(MinPerimeterRectangle.class);

    public static void main(String[] args) {

    }

    public static int solution(int input) {
        int result=0;
        int a = 1;
        int b;
        double max =  Math.sqrt(input);//max is vaule of max divisior with symetric one

        for (int i = 1; i < max; i++) {//find last symetric divisior
            if (input%i == 0) a=i;
        }
        b=input/a;
        LOG.info(a + " " + b);

        if(input == (int)max*(int)max) {// cheak if is 1 unsymetric divisior
            a= (int) max;
            b=a;
        }

        result=2*(a+b);
        return result;
    }
}
