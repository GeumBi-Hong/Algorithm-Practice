package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20040 {


    static  int parent[];
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //점 개수
        int M = Integer.parseInt(st.nextToken()); // 진행된 차례의 수

        parent = new int[N];


        //처음에는 자기 자신이 부모 노드이다.
        for(int i = 0 ; i < N ; i++){
            parent[i]=i;
        }


        //a,b를 같은 집합에 넣는다.
        for(int i = 0 ; i < M ;i++){
           st = new StringTokenizer(br.readLine());

           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());

           //사이클을 이루었다면 0
           if(find(a)==find(b)){
               System.out.print(i+1);
               return;
           }


           union(a,b);




        }
        System.out.print(0);


    }
    private static void union(int a,int b){
        a = find(a); //a의 부모를 찾는다.
        b = find(b); //b의 부모를 찾는다.

        //a b 중 작은 쪽을 부모로 해준다.
        if(a<=b){
            parent[b]=a;
        }else{
            parent[a]=b;
        }
    }

    private static int find(int x){
        if(parent[x]==x) return x;
        return parent[x]= find(parent[x]);
    }
}
