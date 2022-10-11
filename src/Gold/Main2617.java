package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2617 {

    static  ArrayList<Integer>[] arrayLists ;

    //자기 보다 무거운 구슬 개수
    static  int [] heavyArray ;
    //자기 보다 가벼운 구슬 개수
    static  int [] lightArray ;

    //방문 처리
    static boolean [] isVisited ;
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arrayLists = new ArrayList[N+1];
        isVisited = new boolean[N+1];
        heavyArray = new int[N+1];
        lightArray = new int[N+1];


        for(int i = 0 ; i <=N;i++){
            arrayLists[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());

            //무거운거에서 가벼운거 관계 (단방향)
            arrayLists[heavy].add(light);
        }



        for(int i=1; i<=N;i++){
            isVisited = new boolean[N+1];
            dfs(i,i);
        }


        //half 개수 이상 만큼 가벼운 구슬이나 무거운 구슬이 존재한다면 중간 구슬이 아니다.
        int half = (N+1)/2;
        int count = 0 ;
        for(int i=1; i<=N;i++){

            if(lightArray[i]>=half||heavyArray[i]>=half){
                count++;
            }

        }

        System.out.println(count);



    }

    private static void dfs (int cur ,int start){

        //들어온 구슬은 방문처리
        isVisited[cur]=true ;

       for(int next : arrayLists[cur]){
           if(isVisited[next])continue;

           //다음 껄로 갈 수 있다는거는 start보다 가벼운 구슬이 있다는거니까  +1
           heavyArray[start]++;
           //다음 껄로 갈 수 있다는거는 다음 이동하는 구슬한테는 가벼운 구슬이 한개 존재한다는거니까 +1
           lightArray[next]++;

           dfs(next,start);

       }

    }

}
