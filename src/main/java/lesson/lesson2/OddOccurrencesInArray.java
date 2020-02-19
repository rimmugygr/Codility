package lesson.lesson2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * A non-empty array A consisting of N integers is given. The array contains an odd number of elements,
 * and each element of the array can be paired with another element that has the same value,
 * except for one element that is left unpaired.
 *
 * For example, in array A such that:
 *
 *   A[0] = 9  A[1] = 3  A[2] = 9
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9
 * the elements at indexes 0 and 2 have value 9,
 * the elements at indexes 1 and 3 have value 3,
 * the elements at indexes 4 and 6 have value 9,
 * the element at index 5 has value 7 and is unpaired.
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers fulfilling the above conditions,
 * returns the value of the unpaired element.
 *
 * For example, given array A such that:
 *
 *   A[0] = 9  A[1] = 3  A[2] = 9
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9
 * the function should return 7, as explained in the example above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an odd integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [1..1,000,000,000];
 * all but one of the values in A occur an even number of times.
 *
 *
 * */
public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int[] A={7,2,2,7,7,2,2,7,7,2,2,7,7,2,2,7,7,2,2,7,7,2,2,7,7,2,2,7,1};
        System.out.println(solutionOnArray(A));
        System.out.println(solutionOnList(A));
    }


    //HasSet<> so fast !!!!!!!!!!!
    private static int solutionOnList(int[] a) {

        Set<Integer> tab= new HashSet<>();
        for (int i : a) {
            if(tab.contains(i)) tab.remove(i);
            else tab.add(i);
        }
        
        int result = 0;
        for (Integer integer : tab) {
            result=integer;
        }

        return result;
    }

    //to slow
    public static int solutionOnArray(int[] A) {
        int result = 0;
        boolean flagIsParied;
        for (int i = 0; i < A.length; i++) {
            result=A[i];
            flagIsParied=false;
            for (int j = 0; j < A.length; j++) {
                if (result == A[j] && j != i) {
                    flagIsParied = true;
                    break;
                }
            }
            if(!flagIsParied)return result;
        }
        return result;
    }
}

