package lesson.lesson7_stacks_queues;


import org.apache.log4j.Logger;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * You are going to build a stone wall. The wall should be straight and N meters long, and its thickness
 * should be constant; however, it should have different heights in different places. The height of the
 * wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1
 * meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1]
 * is the height of the wall's right end.
 *
 * The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular).
 * Your task is to compute the minimum number of blocks needed to build the wall.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] H); }
 *
 * that, given an array H of N positive integers specifying the height of the wall,
 * returns the minimum number of blocks needed to build it.
 *
 * For example, given array H containing N = 9 integers:
 *
 *   H[0] = 8    H[1] = 8    H[2] = 5
 *   H[3] = 7    H[4] = 9    H[5] = 8
 *   H[6] = 7    H[7] = 4    H[8] = 8
 * the function should return 7. The figure shows one possible arrangement of seven blocks.
 *
 *
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array H is an integer within the range [1..1,000,000,000].
 *
 */

public class StoneWall {
    protected final static Logger LOG= Logger.getLogger(StoneWall.class);
    public static void main(String[] args) {

    int[] H=new int[9];
     H[0] = 8;    H[1] = 8;    H[2] = 5;
     H[3] = 7;    H[4] = 9;    H[5] = 8;
     H[6] = 7;    H[7] = 4;    H[8] = 8;
        LOG.info(solution(H)+"<<<");


    }
    public static int  solution(int[] inputTab) {
        if (inputTab.length==1) return 1;
        List<Integer> stock= new ArrayList<>();
        int result=0;
        for (int i = 0; i < inputTab.length; i++) {
            if (stock.isEmpty()) {
                stock.add(inputTab[i]);
                result++;
                LOG.info("add to empty");
            } else {
                if (inputTab[i]>stock.get(stock.size()-1)){
                    result++;
                    stock.add(inputTab[i]);
                    LOG.info("add_1"+inputTab[i]+" "+stock.get(stock.size()-1));
                } else {
                    while(inputTab[i]<stock.get(stock.size()-1)){
                        LOG.info("remowe "+inputTab[i]+" "+stock.get(stock.size()-1));
                        stock.remove(stock.size()-1);
                        if (stock.isEmpty()) {
                            stock.add(inputTab[i]);
                            result++;
                            break;
                        }
                    }
                    if (!stock.isEmpty()){
                        if (inputTab[i]!=stock.get(stock.size()-1)) {
                            LOG.info("add_2" +inputTab[i]+" "+stock.get(stock.size()-1));
                            stock.add(inputTab[i]);
                            result++;
                        }
                    }

                }
            }
            LOG.info(stock.toString() + " " + i+" result: " + result);
        }




        return result ;
    }

}
