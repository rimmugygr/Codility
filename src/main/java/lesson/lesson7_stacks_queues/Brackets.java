package lesson.lesson7_stacks_queues;


import org.apache.log4j.Logger;

import javax.management.Query;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 *
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 *
 * Write a function:
 *
 * class Solution { public int solution(String S); }
 *
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 *
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 */

public class Brackets {
    protected final static Logger LOG= Logger.getLogger(Brackets.class);
    public static void main(String[] args) {
        String sTrue = "{[()()]}";
        String sFalse = "([)()]";

       // LOG.info(solution(sFalse)+"<<<");
        LOG.info(solution(sTrue)+"<<<");


    }
    public static int  solution(String string) {
        if (string.length()==0) return 1;
        Stack<Character> stack = new Stack<>();

        char elementString;
        char elementTop;
        for (int i = 0; i < string.length() ; i++) {
            elementString=string.charAt(i);
            if(elementString=='{' || elementString=='[' || elementString=='(') stack.add(elementString);
            else {
                if(stack.isEmpty()) return 0;
                elementTop=stack.pop();
                if ((elementString=='}' && elementTop!='{') ||
                        (elementString==']' && elementTop!='[') ||
                        (elementString==')' && elementTop!='(') ){
                    return 0;
                }
            }
            LOG.info(Arrays.toString(stack.toArray()) + ' ' + elementString);
        }
        if (stack.isEmpty()) return 1;
        return 0;
    }

}
