package asseco.aaaa.zad1developers;


/*A company has employed N developers (numbered from 0 to N−1) and wants to divide them into two teams.
The first is a front-end team with F developers. The second is a back-end team with N−F developers.
If the K-th developer is assigned to the front-end team then their contribution is A[K], and if
they are assigned to the back-end team then their contribution is B[K]. What is the maximum sum of
contributions the company can achieve?

Write a function:

class Solution { public int solution(int[] A, int[] B, int F); }

that, given two arrays A, B (consisting of N integers each) and the integer F,
returns the maximum sum of contributions the company can achieve.

Examples:

1. Given A = [4, 2, 1], B = [2, 5, 3] and F = 2, the function should return 10.
 There should be two front-end developers and one back-end developer. The 0th and 2nd developers should
  be assigned to the front-end team (with contributions 4 and 1) and the 1st developer should be assigned
  to the back-end team (with contribution 5).

2. Given A = [7, 1, 4, 4], B = [5, 3, 4, 3] and F = 2, the function should return 18. The 0th and 3rd developers
should be assigned to the front-end team and the 1st and 2nd developers should be assigned to the back-end team.

3. Given A = [5, 5, 5], B = [5, 5, 5] and F = 1, the function should return 15. The 0th developer can be assigned
to the front-end team and the 1st and 2nd developers can be assigned to the back-end team.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..200,000];
arrays A and B have equal lengths;
each element of array A is an integer within the range [0..1,000];
F is an integer within the range [0..N].*/


import java.util.*;

public class Main {
    static List<List<Integer>> result = new ArrayList<>();
    static int f;
    static int k;
    static int[] r = new int[100];
    {
        r[0]=0;
    }

    public static void main(String[] args) {



        int[] A = {4,4,4,4,4,4};
        int[] B = {2,4,4,4,4,4};
        int F = 4;

        System.out.println(solution(A,B,F));

    }

/**
 * funkcja generujaca f wraiacje bez powtorzen ze zbioru k
 *
 *
 * */
      static   List<Integer> rec(int d){
            int i;
            if (f ==d) {
                List<Integer> zbior=new LinkedList<>();//
                for(i=1; i<= f; i++ ) {
                    zbior.add(r[i]);//
                    System.out.print(r[i]);
                }
                System.out.println();
                return zbior;

            } else{

                for( i= r[d]+1; i<=k; i++ ) {// ew. for( i=1; i<=k; i++ )
                    r[d+1] = i;

                    result.add(rec(d+1));

                }
                return new LinkedList<>();
            }

    }












    public static int solution(int[] A, int[] B, int F) {
        f=F;
        k=A.length;
        int number=0;


        rec(0);
        //pobieramy permutacje z podannych zbiorów

        result.removeIf(List::isEmpty);
        result.forEach(System.out::println);



        for (List<Integer> frontDev : result) {
            // dana wariancja front developerów
            frontDev.forEach(System.out::println);

            // reszta to back developerzy
            List<Integer> backDev = new LinkedList<>();
            for (int j = 1; j < A.length+1; j++) {
                if(!frontDev.contains(j))backDev.add(j);
            }
            backDev.forEach(System.out::print);

            int temp=0;
            //liczymy warosci wagowe dla danej wariacji developerow
            for (Integer integer : backDev) {
                temp+=B[integer-1];
            }
            for (Integer integer : frontDev) {
                temp+=A[integer-1];
            }


            System.out.println("x"+ temp);
            if(temp>number)number=temp;
        }
        if(result.isEmpty())
            for (int i : B) {
            number+=i;
        }




        return number;


    }




}
