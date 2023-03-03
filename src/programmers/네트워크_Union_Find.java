package programmers;

public class 네트워크_Union_Find {

    static int[] parent ; //i의 부모노드 저장할 배열

    public int solution(int n, int[][] computers) {


        int answer = 0;

        parent = new int[n];
        //처음엔 자기 자신이 부모노드이다
        for(int i = 0 ; i < n ; i++){
            parent[i]=i;
        }

        //노드들의 집합 관계를 만든다. => union
        for(int r = 0 ; r < n ; r++){
            for(int c = 0 ; c < n ; c++){

                //네트워크로 연결되어있다면 같은 집합으로 연결한다.
                if(computers[r][c]==1){
                    union(r,c);
                }
            }
        }

        for(int i = 0 ; i <  n ; i++){
            //부모 노드인 경우 만 찾으면 그것이 네트워크 하나가 된다.
            if(parent[i]==i)answer++;
        }

        return answer;
    }

    private static void union(int a,int b){

        a = find(a); //a의 최종 부모 노드를 찾는다.
        b = find(b); //b의 최종 부모 노드를 찾는다.

        if(a!=b){ //최종 부모노드가 서로 다르면 어느 한쪽으로 부모를 변경 해 준다.
            parent[a]=b;
        }

    }

    private static int find(int x){
        //자기 자신이 부모 , 즉 최 상단의 부모라면 x를 리턴한다.
        if(parent[x]==x) return x;
        //경로 압축을 하여 부모값을 갱신 해준다.
        return parent[x] = find(parent[x]);
    }
}
