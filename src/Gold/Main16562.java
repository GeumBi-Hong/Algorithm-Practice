package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16562 {

    static int N ,M ,K;
    static int []parent;
    static int []pay;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //학생 수
        M = Integer.parseInt(st.nextToken()); //친구 관계 수
        K = Integer.parseInt(st.nextToken()); // 가지고 있는 돈

        parent = new int[N+1];
        st = new StringTokenizer(br.readLine());
        pay = new int[N+1];


        for(int i = 1 ; i <=N ;i++){
            //처음에 자기 자신이 부모 노드
            parent[i]=i;
            //친구 비 저장
            pay[i] = Integer.parseInt(st.nextToken());
        }


        //집합 관계를 만든다.
        for (int i = 0 ; i <M ;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a,b);
        }

        //친구 비의 최소를 구한다.
        //결국은 친구 관계의 집합을 만들때 부모노드에는 친구비가 가장 작은 친구의 id 여야 최소 비용으로 친구를 사귈 수 있다.
        int total = 0;

        for(int i=1; i<=N; i++){



            if(i==parent[i]) total+= pay[i];

        }

        System.out.print(total>K?"Oh no":total);


    }

    private static void union (int a,int b){

        a = find(a);
        b = find(b);


        //친구 비가 적은 친구를 부모로 설정
        if(a!=b){
            //부모노드의 친구 비가 적은 쪽이 부모노드가 된다.
          if(pay[a] <pay[b])parent[b] = a;
          else parent[a]=b;
        }
    }
    private static int find (int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);
    }
}
