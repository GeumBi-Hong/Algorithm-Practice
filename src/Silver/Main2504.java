package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2504 {

    static String []str;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int lenght = inputStr.length();

         str = new String[inputStr.length()];

        for(int i = 0 ; i < str.length;i++){
            str[i]=String.valueOf(inputStr.charAt(i));
        }

        int dif =1;

        while (dif<lenght){

            for(int i = 0 ; i<lenght-dif;i++){
                if(str[i].equals("(")&&str[i+dif].equals(")")){
                    int n = makeSum(i,i+dif,str[i]);
                    if(n==-1){
                      System.out.println(0);
                        return;
                    }
                    if(dif==1){
                      str[i]=String.valueOf(n);
                    }else {
                        str[i]=String.valueOf(n*2);
                    }
                }


                if(str[i].equals("[")&&str[i+dif].equals("]")){
                    int n = makeSum(i,i+dif,str[i]);
                    if(n==-1){
                        System.out.println(0);
                        return;
                    }

                    if(dif==1){
                        str[i]=String.valueOf(n);
                    }else {

                        str[i]=String.valueOf(n*3);
                    }
                }

                }//for
            dif++;
            }

        //다하고 나서 남은 괄호가 있는지 검사
        int answer = 0;
        for(int i = 0 ; i<str.length;i++){

            if(notInt(str[i])){
                System.out.println(0);
                return;
            }
            answer+=Integer.parseInt(str[i]);
        }



       // printArray();
           System.out.println(answer);
        }



private static void printArray (){
        for(int i = 0  ; i<str.length;i++){
            System.out.print(str[i]+" ");
        }
        System.out.println();
}

    private static int makeSum(int start , int end ,String s){
        int sum=0;

        if(end-start==1){
            if(s.equals("(")){
                str[end]="0";
                return 2;
            }

            if(s.equals("[")){

                str[end]="0";
                return 3;
            }

        }
        for(int i=start+1 ; i<=end-1;i++){
            if(notInt(str[i])){
                return -1;
            }
            sum+=Integer.parseInt(str[i]);
            str[i]="0";
        }
        str[end]="0";
        return sum;
    }

    private static boolean notInt(String s){
        if( s.equals("(") || s.equals(")") || s.equals("[") || s.equals("]")){
          return true;
        }
        return false;
    }
}
