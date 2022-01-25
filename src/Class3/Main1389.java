package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//케빈 베이컨의 6단계 법칙 (플로이드 -와샬)
public class Main1389 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int MAX  = 10000; //int+int 오버플로우 방지

        int N = Integer.parseInt(st.nextToken()); // 유저의 수
        int M = Integer.parseInt(st.nextToken()); //친구 관계 수
        int [][] array = new int[N+1][N+1];

        for (int i = 1;  i < N+1 ; i++){
            for (int j = 1 ; j <N+1;j++){
                array[i][j]=MAX; // i = j를 제외한 나머지는 MAX로 초기화 시켜준다.
                if(i==j){
                    array[i][j]=0;
                }
            }
        }

        // 관계 수 M
       while (M -- > 0){
            st = new StringTokenizer(br.readLine());

           int A = Integer.parseInt(st.nextToken());
           int B = Integer.parseInt(st.nextToken());

           // A-B 가 친구이면 B-A 도 친구이기때문에 양방향 관게를 만들어 준다.
           array[A][B]=1;
           array[B][A]=1;
       }


        //플로이드-와샬

        //array [i][j] = array[i][k]  - > array [k][j]
       for(int k = 1; k <N+1;k++){ // 거쳐가는 노드 k
           for(int i =1 ; i <N+1 ;i++){ //출발노드 i
               for(int j = 1; j < N+1; j++){ //도착 노드 j
                   if(array[i][k]+array[k][j] <array[i][j]){ //더 작은 경로가 있다면
                       array[i][j]=array[i][k]+array[k][j]; // 그 경로의 단계 수로 바꾸어준다.
                   }
               }
           }
       }


       int answer=MAX;
       int person = -1;

       for(int i=1 ; i<N+1;i++){ //행마다 총 합을 더해서 행의 합이 작은것이 있다면 그 값으로 바꾸어 주고 index값을 변경한다.(사람번호)
           int sum = 0;

           for(int j = 1 ; j < N+1;j++){
               sum+=array[i][j];
           }

           if(answer >sum){
               answer=sum;
               person = i;
           }

       }

       System.out.print(person);

    }
}
