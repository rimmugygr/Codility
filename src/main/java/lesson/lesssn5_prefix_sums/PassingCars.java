package lesson.lesssn5_prefix_sums;

import java.util.Arrays;

/**
 *A non-empty array A consisting of N integers is given.
 * The consecutive elements of array A represent consecutive cars on a road.
 *
 * Array A contains only 0s and/or 1s:
 *
 * 0 represents a car traveling east,
 * 1 represents a car traveling west.
 * The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N,
 * is passing when P is traveling to the east and Q is traveling to the west.
 *
 * For example, consider array A such that:
 *
 *   A[0] = 0
 *   A[1] = 1
 *   A[2] = 0
 *   A[3] = 1
 *   A[4] = 1
 * We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A of N integers, returns the number of pairs of passing cars.
 *
 * The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
 *
 * For example, given:
 *
 *   A[0] = 0
 *   A[1] = 1
 *   A[2] = 0
 *   A[3] = 1
 *   A[4] = 1
 * the function should return 5, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1
 *
 * */

public class PassingCars {
    public static void main(String[] args) {
        int[] A = new int[7];
        A[0] = 4;
        A[1] = 2;
        A[2] = 2;
        A[3] = 5;
        A[4] = 1;
        A[5] = 5;
        A[6] = 8;
        System.out.println(solutionOld(A)+"<<<");
    }
    public static int  solution(int[] tabInput) {
        float[] avarageA=new float[tabInput.length-1];
        float[] avarageB=new float[tabInput.length-1];

        int sum=tabInput[0];
        for (int i = 1; i < tabInput.length; i++) {
            avarageA[i-1]=sum+tabInput[i];
            sum= (int) avarageA[i-1];
            avarageA[i-1]/=i+1;
        }

        sum=tabInput[tabInput.length-1];
        for (int i = tabInput.length - 2; i >= 0; i--) {
            avarageB[i]=sum+tabInput[i];
            sum= (int) avarageB[i];
            avarageB[i]/=tabInput.length-i;
        }

        System.out.println(Arrays.toString(avarageA));
        System.out.println(Arrays.toString(avarageB));
        System.out.println(Arrays.toString(tabInput));


        int[] resultTab=new int[tabInput.length-1];

        for (int i = 0; i < resultTab.length; i++) {
            for (int j = 0; j < resultTab.length; j++) {

            }
        }




        int minValue=Integer.MAX_VALUE;
        int result=0;
        for (int i = resultTab.length - 1; i >= 0; i--) {
            if (resultTab[i]<=minValue){
                minValue=resultTab[i];
                result=i;
            }
        }





        return result;
    }

    public static int solutionOld(int[] tabInput) {
        float[] resultTab=new float[tabInput.length-1];

        System.out.println(Arrays.toString(tabInput));
        for (int i = 0; i < tabInput.length-1; i++) {
            int sum=tabInput[i];
            resultTab[i]=10_000;

            for (int j = i; j < tabInput.length-1; j++) {
                sum=sum+tabInput[j+1];
                float temp=(float) sum/(j+2);
                System.out.println(temp);
                if (resultTab[i]>temp) resultTab[i]=temp;
                System.out.println(Arrays.toString(resultTab));
            }
        }


        int minValue=Integer.MAX_VALUE;
        int result=0;
        for (int i = resultTab.length - 1; i >= 0; i--) {
            if (resultTab[i]<=minValue){
                minValue=(int) resultTab[i];
                result=i;
            }
        }


        return tabInput[result];
    }

}
