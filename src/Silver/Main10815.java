package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main10815 {

    static ArrayList<Integer> num = new ArrayList<>();
    static ArrayList<Integer> check = new ArrayList<>();
    static int N,M;
    static int [] answer ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()){
            num.add(Integer.parseInt(st.nextToken()));
        }


       M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()){
            check.add(Integer.parseInt(st.nextToken()));
        }


        //이진 탐색은 데이터가 정렬되어있어여함.
        Collections.sort(num);
       // Collections.sort(check);

        answer = new int[M];

        //이진 탐색



        //check배열 돌면서
        for(int i = 0 ; i < M;i++){
           if(BinarySearch(check.get(i),0,num.size()-1)){//찾았다면 1
               answer[i]=1;
           }
        }

        for(int i = 0 ; i < M;i++){
            sb.append(answer[i]+" ");
        }

        System.out.print(sb);


    }

    public static boolean BinarySearch(int searchItem,int low,int high){

        int mid ;

        while (low <=high){
            mid = (low+high)/2;

            //값을 찾았다면
            if(searchItem==num.get(mid)){
                return true;
            }else if(searchItem<num.get(mid)){
                high = mid -1;
            }else {
                low = mid+1;
            }

        }
        //못찾았다면
        return false;
    }
}
