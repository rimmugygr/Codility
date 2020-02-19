package asseco.seatinplain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String aaa="11 r4";
        int bbb=5;
        System.out.println(">"+solution(aaa,bbb)+"<");
    }


    public static String solution(String message, int K) {
        String[] strings = message.split(" ");
        String reoult="";
        int i=0;
        for (String string : strings) {
            i+=string.length();
            if(i++<=K){
                if(!reoult.equals(""))reoult+="";
                reoult+=string;
            }
            else break;
        }
        return reoult;
    }
}
