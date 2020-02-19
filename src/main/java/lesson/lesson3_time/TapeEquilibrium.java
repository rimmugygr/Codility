package lesson.lesson3_time;

import java.util.Arrays;

/**
 *
 * A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
 *
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 *
 * The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 *
 * In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
 *
 * For example, consider array A such that:
 *
 *   A[0] = 3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = 4
 *   A[4] = 3
 * We can split this tape in four places:
 *
 * P = 1, difference = |3 − 10| = 7
 * P = 2, difference = |4 − 9| = 5
 * P = 3, difference = |6 − 7| = 1
 * P = 4, difference = |10 − 3| = 7
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
 *
 * For example, given:
 *
 *   A[0] = 3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = 4
 *   A[4] = 3
 * the function should return 1, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 *
 *
 *
 */
public class TapeEquilibrium {
    public static void main(String[] args) {

        int[] x={-1,4,4,4,-4,4,4,434,-2,-2,3,-5};
        System.out.println(solutionVer1(x)+"<<<");

//        System.out.println(solutionVer2(x)+"<<<<");
    }

//    // incomplite, errror,pomija pewne zaleznosci
//    public static int solutionVer2(int[] N) {
//        int sumA=N[0];
//        int sumB=N[N.length-1];
//        //System.out.println(sumA+" "+sumB);
//        for (int i = 0, k=1, j=N.length-2 ; i < N.length-2 ; i++) {
//            if (sumA < sumB) {// ktorą ze stron zwiększyć
//                if (N[k]<0) sumB +=N[j--];//czy ujemna liczba
//                else sumA += N[k++];
//            }
//            else {
//                if (N[j]<0) sumA += N[k++];//czy ujemna liczba
//                else sumB +=N[j--];
//            }
//            //System.out.println(sumA+" "+sumB);
//        }
//        return Math.abs(sumA-sumB);
//    }


    public static int solutionVer1(int[] n) {
        int[] sumA= new int[n.length];
        int[] sumB= new int[n.length];
        int sum=0;
        for (int i = 0; i < sumA.length; i++) {
            sumA[i]=n[i]+sum;
            sum=sumA[i];
        }
        sum=0;
        for (int i = sumB.length - 1; i >= 0; i--) {
            sumB[i]=n[i]+sum;
            sum=sumB[i];
        }
        sum=Integer.MAX_VALUE;
        for (int i = 0; i < sumA.length-1; i++) {
            int abs = Math.abs(sumA[i] - sumB[i+1]);
            if(abs <sum)
                sum= abs;
        }


        System.out.println(Arrays.toString(sumA));
        System.out.println(Arrays.toString(sumB));


        return sum;
    }


}
