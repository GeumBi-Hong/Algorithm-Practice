package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 트리의 순회
 *
 *
 * [풀이]
 * 후위 순회 :  왼쪽 Node -> 오른쪽 Node -> 루트 Node => 맨 끝에 루트 노드가 오게 되어있음
 * 중위 순회 :  왼쪽 Node -> 루트 Node -> 오른쪽 Node  => 즉, 루트 노드를 알면 왼쪽 트리,오른쪽 트리를 알 수있음
 *
 * 이러한 성질을 이용하여 풀이
 *
 */


public class Main2263 {

    static int[] inOrder; //중위
    static int[] postOrder; //후위

    static int[] inOrderIndex; //루트 노드가 어디 인덱스 번호에 있는지 매번 찾지 않게 하기 위함
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        inOrder = new int[N ];
        postOrder = new int[N];
        inOrderIndex =  new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());

        //[1] 중위 순회 값 저장
        for (int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());

        }

        st = new StringTokenizer(br.readLine());

        //[2] 후위 순회 값 저장
        for (int i = 0; i < N; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {

            inOrderIndex[inOrder[i]] = i;

        }

        preOrder(0,N-1,0,N-1);

    }

    private static void preOrder (int startI , int endI , int startP , int endP){
        if(startI > endI || startP  > endP ) return;

        int root = postOrder[endP] ; //후위 순회의 마지막 노드가 맨 루트 노드
        System.out.print(root+" ");

        int leftSize =  inOrderIndex[root] - startI;

        preOrder(startI, inOrderIndex[root] -1 ,startP,startP + leftSize -1);
        preOrder(inOrderIndex[root] + 1, endI , startP + leftSize, endP -1 );
    }
}
