package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1717 {

    static int [] parent ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
         int N = Integer.parseInt(st.nextToken());
         int M = Integer.parseInt(st.nextToken()); //연산의 개수

        parent = new int[N+1]; //인덱스번호의 부모가 누구인지


        make(N);
        for(int i = 0 ; i < M ;i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // type = 0 a가 포함된 집합과 b가 포함된 집합과 합치기  union(a,b)
            // type = 1 a랑 b 가 같은 집합에 포함되어있는가 ?  두 부모가 같은가를 판단하면 되지않을까? find(A)== find(B) ?

            switch (type){

                case 0:
                   union(a,b);//두 집합 합치기
                    break;
                case 1:
                    if (isUnion(a,b))sb.append("YES").append("\n"); //같은 집합에 있다면
                    else sb.append("NO").append("\n"); //같은 집합에 존재하지 않다면
                    break;
            }


        }

        System.out.println(sb);


    }
    //부모 찾기
    static private int find (int a){
        //자기 자신이 부모면
        if(parent[a]==a){
            return a;
        }
        //그렇지 않으면
        return parent[a]= find(parent[a]);

    }

    //a 집합과 b의 집합을 합친다 ->  a의 집합 부모밑에 b를 달아준다.
    static void union (int a,int b){

        int parentA = find(a); //a의 집합의 부모를 찾는다.
        int parentB = find(b); //b의 집합의 부모를 찾는다.

        if(parentA!=parentB){ //부모가 다르다면 다른 집합에 서로 존재한다는 의미 이기때문에 합칠 수 있다.
            parent[parentB]=parentA;

        }else { //두 집합이 같다면 합칠 수 없음

        }
    }
    static boolean isUnion (int a,int b){

        int parentA = find(a); //a의 집합의 부모를 찾는다.
        int parentB = find(b); //b의 집합의 부모를 찾는다.

        if(parentA!=parentB){ //부모가 다르다면 다른 집합에 있다는의미
            return false;

        }else { //두 집합이 같다면 합칠 수 없음
            return true;
        }
    }

    static private void make (int N){

        //맨 처음에 모든 집합은 자기 자신이 부모니까 자기 자신으로 부모로 초기화 시켜준다.
        for(int i = 0 ; i <=N;i++){
            parent[i]=i;
        }
    }
}
