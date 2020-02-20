package asseco.seatinplain;

public class Solution {
    public static void main(String[] args) {
        int aaa=11;
        String bbb="";
        System.out.println(">"+solution(aaa,bbb)+"<");
    }


    public static int solution(int N, String S) {
        int result=0;
        // tab of reserved set in string form
        String[] seatString=S.split(" ");
        if(S.equals(""))seatString= new String[]{};



        //sit kolumn symbol
        Character[] seatLetter={'A','B','C','D','E','F','G','H','J','K'};
        //tab of sit in plain
        Boolean[][] seat=new Boolean[N][seatLetter.length];//
        //set not reserved all places in table
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                seat[i][j]=false;
            }
        }
        //put reservet seat to table
        for (String string : seatString) {
            int temp=0;
            for (int i = 0; i < seatLetter.length; i++) {
                if (string.charAt(1)==seatLetter[i]) temp=i;
            }
            seat[Integer.parseInt(String.valueOf(string.charAt(0)))-1][temp]=true;
        }




        for (Boolean[] booleans : seat) {
            for (Boolean aBoolean : booleans) {
                System.out.print(aBoolean+" ");
            }
            System.out.println();

            //1 case 2 famili
            if(!booleans[1] && !booleans[2] && !booleans[3] && !booleans[4] &&
                    !booleans[5] && !booleans[6] && !booleans[7] && !booleans[8]) {
                result+=2;
                continue;
            }
            //2 case 1 famili to left
            if(!booleans[1] && !booleans[2] && !booleans[3] && !booleans[4]) {
                result+=1;
                continue;
            }
            //3 case 1 famili to right
            if(!booleans[5] && !booleans[6] && !booleans[7] && !booleans[8]) {
                result+=1;
                continue;
            }
            //4 case 1 famili in center
            if(!booleans[3] && !booleans[4] && !booleans[5] && !booleans[6]) {
                result+=1;
            }
        }
         return result;

    }







}
