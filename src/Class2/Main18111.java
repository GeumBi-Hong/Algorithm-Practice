package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18111 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); //행 수
        int M = Integer.parseInt(st.nextToken()); //열 수
        int B = Integer.parseInt(st.nextToken()); //인벤토리 블럭 수
        int [][] minecarft = new int[N][M];
        int count [] = new int[257]; // 인덱스 번호를 층수로 활용하여 해당하는 인덱스 번호의 층수가 몇개가있는지 저장시킬것이다.

        int min_H=256; //최소 높이
        int max_H=0;   //최대 높이

        //2차 원 배열에 땅 높이를 저장시킨다.
        //땅 고르기를 할 수 있는 최소 높이와 최대 높이를 구한다.
        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j =0 ; j < M ; j++){
                    minecarft[i][j]=Integer.parseInt(st.nextToken());
                    count[minecarft[i][j]]+=1; //같은 층이 몇개있는지 인덱스 번호를 이용하여 수를 세어준다.

                    if ( minecarft[i][j]>=max_H){ //최대 높이 구하기
                        max_H =minecarft[i][j];

                }

                    if (minecarft[i][j]<=min_H){ //최소 높이 구하기
                        min_H = minecarft[i][j];
                    }
            }
        }

        int []answer = {Integer.MAX_VALUE, 257};// {시간, 높이}
        //최소 높이 부터 최대 높이까지 작업을 진행한다.
        for (int h = max_H ; h >= min_H;h--){ //i 가 땅을고를 기준인 수가 된다.
            int time =0;
            int block = B; //층이 바뀔때마다 블록수를 처음 받아온 블록 수 로 초기화

         for (int k=max_H ; k>h;k--){ //최대 층부터 기준층 전까지 내려가면서 연산
             int d = (k-h) *count[k]; //인벤토리에 넣어야할 블록수를 계산
             time+=d*2;
             block = block +d;
            }


         for (int k = min_H; k<h;k++){ //최소 층 부터 기준층 전까지 올라가면서 연산
             int d = (h-k) * count[k];//블록 위에 올려야할 블록 수를 계산
             time = time +d;
             block = block -d;
         }

         // 전부 계산 후 블록수가 음수가 아니고 , 시간이 그 전보다 최소일 경우에만 값을 갱신한다.
         if (block>=0 && time<answer[0]){
             answer[0]=time;
             answer[1]=h;
         }

        }

        System.out.print(answer[0]+" "+answer[1]);

    }
}
