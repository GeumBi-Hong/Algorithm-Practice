package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//기념품
public class Main12873 {

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine());

       List<Integer> list = new LinkedList<>();
       for(int i = 1 ; i <=N;i++){
           list.add(i);
       }

       int now = 0;
       //한명 남겨야되니까 N 전까지 만
       for(int i = 1; i< N ;i++){

           int mod =  list.size();

           //지울 인덱스번호

          int index =(now+ ((i%mod * i %mod * i%mod) %mod)-1) %list.size();


            if( index ==-1) {

                index+=list.size();
            }
            list.remove(index);
            now = index;


       }

       System.out.println(list.get(0));

    }
}
