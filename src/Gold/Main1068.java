package Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 트리
 *
 * [문제조건]
 * - 트리의 노드 개수 (1 <= N <= 50)
 * - 0번 노드 ~ N-1번 노드까지 , 각 노드의 부모가 주어진다.
 * - 부모가 없다면 (루트) -1 이 주어진다.
 * 셋째 줄에는 지울 노드의 번호가 주어진다.
 *
 *
 * [첫 풀이]
 * - 일단 왼쪽 -> 오른쪽순으로 비어있는 곳으로 넣을까?
 * - 리프 노드의 개수는 어케 구하지? -> 자식의 개수가 0개인 노드 개수를 샌다면?
 * - 삭제는 어떻게 하지? ->
 *
 *
 * [두 번쨰]
 * - 일단 트리가 이진트리라는 보장이 없었네
 * - 루트노드는 반드시 0이 아닐 수 있음..
 */
public class Main1068 {
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //트리 노드의 총 개수
        int N = Integer.parseInt(br.readLine());

        //입력값
        int[] input = new int[N];
        int root = -1;

        //인접리스트 (?) 인덱스 번호는 부모 노드의 번호 ,  그안에 들어가는 번호는 자식
        ArrayList<Integer>[] childNode = new ArrayList[N];
        //입력값 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        //삭제할 노드의 번호
        int deleteNodeNum = Integer.parseInt(br.readLine());

        //얘를 먼저 만들어주고 값을 넣었어야했네... nullpointer에러 뜬 이유였음
        for (int i = 0; i < N; i++)  childNode[i] = new ArrayList<>();
        for (int i = 0; i < N; i++){

            int n = Integer.parseInt(st.nextToken());
            input[i] = n;

            //부모노드 구하기
            if(input[i] == -1) root = i;
            else if (i != deleteNodeNum ) childNode[input[i]].add(i);

        }

        int answer = 0;

        //이제 트리를 돌면서 childNode[i]의 크기가 0인거 를 찾으면 그게 리프노드

        Queue<Integer> queue = new ArrayDeque<>();
        //queue.add(root); //루트 노드 부터 탐색하기 위해 처음 add

        if(deleteNodeNum != root)  queue.add(root); //루트 노드 부터 탐색하기 위해 처음 add
        while (!queue.isEmpty()){

            int currNodeNumber = queue.poll();
            if(childNode[currNodeNumber].size() == 0 ) answer++;
            else {
                for (int child : childNode[currNodeNumber]) {
                    queue.add(child);
                }
            }
        }

        System.out.println(answer);
    }
}
