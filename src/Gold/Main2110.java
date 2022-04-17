package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2110 {


    static int [] nums;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        nums = new int[N];




        for(int i = 0 ; i < N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }


        //이분 탐색을 하기 위해서는 반드시 정렬되어있어야한다.
        Arrays.sort(nums);

        int lo = 1; //최소 거리
        int hi = nums[N-1]-nums[0]; //최대로 가질 수 있는 최소거리

        while (lo<=hi){


            int  mid = (lo+hi)/2;

            if(canInstall(mid)<C){ //mid거리만큼 설치할 수있는 공유기 개수가 c 에 미치지 못하면
                //hi를 줄인다.
                hi =mid-1;

            }else {
                //그렇지 않고 설치할 수 있거나 그 이상의 개수라면 범위를 넓힌다.
                lo=mid+1;
            }
        }

        System.out.print(lo-1);
    }

    public static int canInstall(int mid){

        int curr = nums[0];
        int count =1;

        for(int i = 1 ; i < nums.length;i++){


            if(nums[i]-curr>=mid){
                count++;
                curr = nums[i];
            }

        }

        return count;
    }
}
