package lesson.lesson7_stacks_queues;


import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A string S consisting of N characters is called properly nested if:
 *
 * S is empty;
 * S has the form "(U)" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 *
 * Write a function:
 *
 * class Solution { public int solution(String S); }
 *
 * that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
 *
 * For example, given S = "(()(())())", the function should return 1 and given S = "())",
 * the function should return 0, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..1,000,000];
 * string S consists only of the characters "(" and/or ")".
 *
 */

public class Nesting {
    protected final static Logger LOG= Logger.getLogger(Nesting.class);
    public static void main(String[] args) {
        String s1 = "(()(())())()";
        String s0 = "())";
        LOG.info(solution(s1)+"<<<");
        LOG.info(solution(s0)+"<<<");


    }
    public static int  solution(String string) {
        if (string==null) return 1;
        if (string.length()%2==1) return 0;
        List<Boolean> stock = new ArrayList<>();//true='('  fales=')'
        char element;
        for (int i = 0; i < string.length() ; i++) {
            element=string.charAt(i);
            if (element=='(') {
                stock.add(true);
            } else {
                if (stock.isEmpty()) return 0;
                if (stock.get(stock.size()-1)==true) stock.remove(stock.size()-1);
                else return 0;
            }
            LOG.info(stock.toString());
        }
        if (stock.isEmpty()) return 1;
        return 0 ;
    }

}
