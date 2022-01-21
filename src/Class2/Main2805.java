package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); //  나무의 수
        int M = Integer.parseInt(st.nextToken()); // 집으로 가져가려하는 나무길이 M
        int max = 0 ; //최대 나무길이
        int min = 0; //최소 나무길이

        int []tree = new int[N];


        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i <N; i++){

            tree[i] = Integer.parseInt(st.nextToken());
            if (tree[i]>max){
                max = tree[i];
            }

        }


        while ( min<max){
            int mid= (min+max)/2;
            long sum= 0;
            for (int h : tree){
                if(h-mid >0){
                    sum+=(h-mid);
                }
            }

            if (sum<M){
                max=mid;
            }else {
                min= mid+1;
            }
        }
        System.out.print(min-1);
    }
}
