package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2343 {

    static int N,M;
    static List<Integer> lecture =  new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");


        int start = 0;
        int sum=0;
        for(int i = 0 ; i<N;i++){
            int n = Integer.parseInt(st.nextToken());
            lecture.add(n);
            sum+=n;

        }

        for(int i = 0 ; i <N;i++){
            start=Math.max(start,lecture.get(i));
        }


        System.out.print(binarySearch(start,sum));


    }

    private static  int binarySearch(int start,int end){

        int lo = start;
        int hi = end;
        int result = 0 ;


        while (lo<=hi){

            int mid =(lo+hi)/2;

            if(canRecordLecture(mid)){
                result=mid;
                hi=mid-1;

            }else {
              lo=mid+1;
            }


        }

        return result;
    }

    private static boolean canRecordLecture(int min){

        int count = 0 ;
        int blueRay = M;
        int total = 0;

           for(int i = 0 ; i <N ;i++){
               total+=lecture.get(i);
                if(total>min){
                    count++;
                    total=lecture.get(i);
                }

            }

           if(total>0){
               count++;
           }



            return count<=blueRay;

    }
}
