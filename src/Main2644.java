import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2644 {

    static ArrayList<Integer> array[];
    static boolean visited[];
    static int answer =-1;
    static int count =0;
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());//전체 사람 수
        visited = new boolean[n+1];
        array = new ArrayList[n+1];

        StringTokenizer st= new StringTokenizer(br.readLine()," ");

        int p = Integer.parseInt(st.nextToken()); //부모 번호
        int c = Integer.parseInt(st.nextToken()); //자식 번호
        int m = Integer.parseInt(br.readLine());  // 부모 자식들관의 관계 수

        //초기화 및 리스트 생성
        for (int i =0 ;i<n+1;i++){
            visited[i]=false;
            array[i]= new ArrayList<Integer>();
        }

        //부모 자식들관의 관계 수(m) 만큼 반복하여 ArrayList에 관계성 추가
        for (int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            array[a].add(b);
            array[b].add(a);

        }

       dfs(p,c);
        System.out.print(answer);


    }

    public static void dfs (int start,int end){
        //방문한 노드를 체크해준다. (방문함 =true , 방문 안함 =  false)
        visited[start]=true;

        //구하고자 하는 자식에 도착하였을 경우 현재까지 count된 값을 answer에 넣는다.
        if(start==end){
            answer=count;

        }
        //노드에 방문하였으므로 증가 1 시킨다.
        count++;

        //현재위치의 노드와 관계성을 가지는 노드의 값을 가져와 방문했는지 검사하고
        //방문하지 않았다면 해당 값을 가지고 함수를 다시 불러준다
        //현재노드에서 나올때 count -1 을 해줘서 깊이의 값을 갱신해준다.
       for(int i=0;i<array[start].size();i++){
           int next = array[start].get(i);
           if(!visited[next]){
               dfs(next,end);
               count--;
           }
       }


    }


}
