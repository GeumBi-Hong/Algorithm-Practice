package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//숨바꼭질 (너비우선탐색)
public class Main1697 {
    static int size=100001;
    static  int[] arr = new int[size];
    static  Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr[N]=1; //누나 위치
        queue.add(N);
        bfs(N,K); //누나 위치에서 너비 우선 탐색

    }
    static void bfs  (int start,int end){

       while (!queue.isEmpty()){

           int now = queue.poll();

           if(now==end){
               System.out.println(arr[end]-1);

              //System.exit(0);
               return;
          }

           if (now*2 <size &&arr[now*2]==0){
               queue.add(now*2);
               //  System.out.println("now*2: "+ (now*2));
               arr[now*2]=arr[now]+1;
           }

           if(now -1 != -1 && arr[now-1]==0){
               queue.add(now-1);
              // System.out.println("now -1: "+ (now-1));
               arr[now-1]=arr[now]+1;
           }

           if(now +1 < size &&arr[now+1]==0){
               queue.add(now+1);
             //  System.out.println("now +1: "+ (now+1));
               arr[now+1]=arr[now]+1;
           }



       }

    }
}
