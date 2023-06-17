package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 탑
 */
public class Main2493 {

    static class Info{

        int height; //탑의 높이
        int index; // 몇번 째 탑이 였는지
        public Info(int height,int index){
            this.height=height;
            this.index=index;
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Info> priorityQueue = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            //높이 오름 차순 정렬
         public int compare(Info o1, Info o2) {
                return Integer.compare(o1.height,o2.height);
            }
        });

        int N = Integer.parseInt(br.readLine());

        //탑 높이
        // 6 9 5 7 4
        // 4 5
        int [] height = new int[N+1];
        //i번째 탑의 수신을 몇번째 탑이 받았는지 저장하기 위한 배열
        int [] top = new int[N+1];

        /** 입력값 저장 */
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <= N ;i++){

            height[i] = Integer.parseInt(st.nextToken());
        }

        priorityQueue.add(new Info(height[N],N));

        //탑의 개수 만큼 반복
        for(int i = N-1; i >= 1; i--){

            priorityQueue.add(new Info(height[i],i));

           while (!priorityQueue.isEmpty()) {

               Info info = priorityQueue.peek();

               //큐에 들어가 있는 탑의 높이보다 크다면
               if(height[i] > info.height){

                   top[info.index]=i;
                   priorityQueue.poll();

               }else {
                   break;
               }
           }

        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i<=N;i++){
            sb.append(top[i]+" ");
        }
        System.out.println(sb);
    }
}
