package Sliver;
import java.io.*;
import java.util.*;


public class Main2151 {
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<String> list = new ArrayList<>();

        int length = str.length();

     for(int i = 1; i<length-1;i++){
         for(int j =i+1;j<length;j++){

             String s1 = str.substring(0,i);
             String s2 = str.substring(i,j);
             String s3 = str.substring(j,length);

             StringBuilder sb = new StringBuilder();
             sb.append(makeStringReverse(s1)).append(makeStringReverse(s2)).append(makeStringReverse(s3));

             list.add(sb.toString());
         }
     }
        Collections.sort(list);

        System.out.println(list.get(0));

    }
    private static String makeStringReverse(String str){
        StringBuffer sf = new StringBuffer(str);
        return sf.reverse().toString();
    }
}
