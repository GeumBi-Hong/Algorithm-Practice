package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2512 {

    static  int  N, M;
    static List<Integer> budget = new ArrayList<>();
    static int maxBudget;

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        maxBudget = 0 ; //예산들 중 가장 큰 예산값

        for(int i = 0 ; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            if(maxBudget <n)maxBudget=n;
            budget.add(n);
        }

        M = Integer.parseInt(br.readLine());

        int totalBuget = 0 ;
        for(int num : budget){
            totalBuget+=num;
        }

        if(totalBuget<=M){ // 국가의 예산 총액보다 지방 예산요청의 금액 합이 작거나 같을 경우는 예산이 배정될 수 있으므로 가장 큰값을 출력한다.
            System.out.print(maxBudget);
            return;
        }else {
            // 그렇지 않으면 상한액 배정
            System.out.print(binarySearch());
        }



    }

    private static int binarySearch(){

        int lo =1;
        int hi =maxBudget;


        while (lo<=hi){
            int mid = (lo+hi)/2;

            if(canAllocateBudget(mid)<=M){
                lo=mid+1;
            }else {
                hi = mid-1;
            }
        }

        return lo-1;
    }

    private static int canAllocateBudget(int n){


        //상한액 n

        int total = 0;

        for(int money : budget){

            if(n<=money){
                //기준 상한액 보다 예산이 같거나 크다면 상한가로 더해줌
                total+=n;
            }else {
                //기준 상한액 보다 예산이 작을 경우 그 예산값을 더함
                total+=money;
            }
        }

        return total;
    }
}
