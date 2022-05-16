package Sliver;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main5671 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNextLine()){
           String str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str," ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());


            int count = 0;
            for(int  i = start ; i<=end;i++){
                if(check(i))count++;
            }

            sb.append(count).append("\n");

        }
        System.out.println(sb);

    }
    private static boolean check(int n){
        int []num = new int[10];

            while (n!=0){
                num[n%10]++;
                if(num[n%10]==2){
                   return false;
                }
                n=n/10;
            }

        return true;
    }
}
