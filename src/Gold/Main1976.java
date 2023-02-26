package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1976 {

    static int [] parent ;
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 도시의 수
        int M = Integer.parseInt(br.readLine()); // 여행 게획에 속한 도시들의 수

        parent = new int[N]; //각 노드의 부모

        //각 노드의 부모는 처음에 자기 자신이다.
        for(int i = 0 ; i <  N ; i++){
            parent[i]=i;
        }



        for(int r = 0 ; r < N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N ;c++){
                int n = Integer.parseInt(st.nextToken());
                if(n==1) union(r,c);
            }
        }


        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] route = new int[M];
        for(int i = 0 ; i< M ; i++){
            route[i] = Integer.parseInt(st.nextToken())-1;
        }

        for(int i = 0 ; i < M-1; i++){
            if(find(route[i])!=find(route[i+1])){
                System.out.print("NO");
                return;
            }
        }

        System.out.print("YES");

    }

    //두개의 노드를 연결한다.
    private static void union(int a, int b){

        int parentA = find(a); //a의 부모를 찾는다.
        int parentB = find(b); //b의 부모를 찾는다.

        if(parentA < parentB){ //작은 수를 부모로 둔다.
            parent[parentB]= parentA;
        }else {
            parent[parentA] = parentB;
        }


    }

    //x의 부모를 찾아 리턴한다.
    private static int find(int x){

        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }
}
