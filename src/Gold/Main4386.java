package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * 별자리 만들기
 *
 * - 크루스칼 : 유니온 파인트를 이용해서 최소 스패닝 트리를 만드는 문제
 * 기본적으로 최소의 간선만을 선택하여 트리를 만들기에 , 시작 정점은 존재하지 않는다. (시작정점이 존재하면 프림)
 * - 문제에서 별들의 2차원에서 x,y좌표를 주어지니까 모든 별들의 거리를 직접 구한다. => a ^ 2 + b ^ 2 = c ^2 피타고르사ㅡ 정리 이용
 * - MST는 모든 정점을 연결하는 최소 비용의 간선들의 집합을 구해야한다.
 *
 *
 * 1. 모든 별들에 대해 거리를 구함 그 거리 가지고 간선 정보를 만듬
 * 2. 거리가 가장 작은 간선으로 계속 연결 , 이 때 사이클이 발생하는 것은 무시
 * 3.별의 개수가 N 개 라고 하면 최소 스패닝 트리를 만드는 간선의 개수는 N-1이기 때문에 간선이 전부 만들어 지면 그만
 */
public class Main4386 {



    static int N;
    static double[][] star;
    static int[] parent;



    private static class Star implements Comparable<Star> {
        int s;
        int e;
        double dis;

        Star(int s, int e, double dis) {
            this.s = s;
            this.e = e;
            this.dis = dis;
        }

        @Override
        public int compareTo(Star o) {
            if(this.dis > o.dis){
                return 1;
            }else if(this.dis < o.dis){
                return -1;
            }else {
                return 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        star = new double[N + 1][2];
        parent = new int[N + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            star[i][0] = x;
            star[i][1] = y;
            parent[i] = i; //처음에 본인이 부모

        }

        PriorityQueue<Star> priorityQueue = new PriorityQueue<>();

        for(int i = 1;  i <= N; i++){
            for(int j = i + 1;  j <= N; j++){

                double x1 = star[i][0];
                double y1=  star[i][1];

                double x2 = star[j][0];
                double y2=  star[j][1];

                //피타고라스
                double a = Math.pow(x1 - x2, 2); // a^ 2
                double b = Math.pow(y1- y2,2); // b^ 2

                double distance = Math.sqrt(a + b); // c


                //우선 순위 큐에 간선 정보 저장
                //거리가 작은 순으로 정렬됨
                priorityQueue.add(new Star(i,j,distance));



            }
        }


        double answer = 0.0;
        int cnt = N - 1;

        while (!priorityQueue.isEmpty() && cnt > 0){
            Star star = priorityQueue.poll();

            //사이클이 존재하지 않으면 거리 합산함
            if(union(star.s, star.e)){
                answer += star.dis;
                cnt--;
            }
        }


        //소수 둘 째 자리
        answer = (double) Math.round(answer * 100) / 100;
        System.out.println(answer);


    }
    private static boolean union(int a, int b){
        int root1 = find(a);
        int root2 = find(b);

        //같은 사이클이면 안됨
        if(root1 == root2){
            return false;
        }

        if(root2 > root1){
            parent[root2] = root1;
        }else{
            parent[root1] = root2;
        }

        return true;
    }

    private static int find(int root) {
        if (parent[root] == root) {
            return root;
        }
        return parent[root] = find(parent[root]);
    }
}
