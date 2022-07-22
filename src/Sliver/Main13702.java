package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main13702 {
    /**
     * N 주전자의 개수
     * K 은상이를 포함한 친구 수
     */
    static int N, K ,L ;
    static  ArrayList<Integer> arrayList;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList<>();


        //주전자에 들어있는 막걸리 ml 저장
        for(int i = 0 ; i < N; i++){
            int n = Integer.parseInt(br.readLine());
            if(n==0)continue;
            arrayList.add(n);
        }

        L = arrayList.size();

        long left = 0;
        long right = Integer.MAX_VALUE;
        long answer = 0;

        //이분 탐색 =>시간복잡도 log(n)
        while(left <=right){

            long mid =  (left+right)/2;
            if(canDivide(mid)){ //나눠줄수있는 친구 수보다 많으면 범위를 높인다.
                left=mid+1;
                answer=mid;

            }else { //k 인원수보다 덜 나눠주면 나눠줘야하는 용량을 줄인다.
                right = mid -1;

                answer= mid; //****여기 ****/
            }
        }

        System.out.println(answer);

    }

    private static boolean canDivide(long ml){
        //L = arraylist.length
        int sum =0;
        for(int i = 0 ; i <L ;i++ ){
            sum+= arrayList.get(i)/ml;
            if(sum>=K)return true;

        }
        return false;
    }
}
