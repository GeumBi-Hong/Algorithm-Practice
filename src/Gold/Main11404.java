package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11404 {
    static final int INF =9999999;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int [][]arr= new int[n+1][n+1];



        //플로이드 와샬 초기화
        for(int i=1; i<=n;i++){
            for(int j =1; j<=n;j++){
                    arr[i][j]=INF; //모든 정점에서 모든 정점까지 의 최소 거리를 구할꺼니까 최대 수치로 초기화 시켜놓는다.
                if(i==j){
                    arr[i][j]=0; //자기 정점에서 자기 정점으로 가는건 없다. -> 0
                }
            }
        }

        while (m-->-0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            //(1, 4, 3)  (1, 4, 1) 이렇게 들어올때 가장 최소값으로 갱신시켜주어야한다.
            arr[a][b] = Math.min(arr[a][b],c);

        }
        //플로이드 와샬 알고리즘
        for(int k=1; k<=n;k++){ //거쳐가는 노드
            for(int i =1;i<=n;i++){ //출발 노드
                for(int j = 1; j<=n;j++){ // 도착노드
                    arr[i][j]= Math.min(arr[i][j],arr[i][k]+arr[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i =1;i<=n;i++){ //출발 노드
            for(int j = 1; j<=n;j++){ // 도착노드
            if(arr[i][j]==INF){
               arr[i][j]=0;
            }
            sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
