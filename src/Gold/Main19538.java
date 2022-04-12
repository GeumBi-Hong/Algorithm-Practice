package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main19538 {


    static ArrayList<Integer>[] map ;
    static int [] answer ;
    static boolean [] visited;
    static int N ;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map =  new ArrayList[N+1];

        for(int i =1 ;  i <=N;i++){
            map[i] = new ArrayList<>();
        }

        answer =  new int[N+1];
        visited = new boolean[N+1];
        Arrays.fill(answer,-1);


        for(int start =1 ; start<=N;start++){
           st = new StringTokenizer(br.readLine()," ");

            while (st.hasMoreTokens()){
                int end = Integer.parseInt(st.nextToken());
                if(end==0)continue;
                map[start].add(end);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

         for(int i = 0; i<M;i++){
             int  n = Integer.parseInt(st.nextToken());
             answer[n]=0; //최초 유포자는 0분
             queue.add(n);
         }


        bfs();

         for(int i=1; i<=N;i++){
             sb.append(answer[i]+" ");
         }
        System.out.print(sb);
    }

    public static void bfs(){

        int []half = new int[N+1];


        for(int i = 1 ; i<=N;i++){
            int n = map[i].size()/2;
            if(map[i].size()%2!=0){
                half[i]=n+1;
            }else {
                half[i]=n;
            }

        }

        while (!queue.isEmpty()){

         int curr=  queue.poll();

        //현재 사람에서 루머를 퍼트릴 수 있는 주변인을 있는지 찾는다.
         for(int next : map[curr]){

             half[next]-=1; // 루머에 걸린 사람이 있으니 -1 를 해준다.

             if(answer[next]==-1&&half[next]<=0){

                 queue.add(next);
                 answer[next]=answer[curr]+1;
             }

               }
           }

        }

    }


