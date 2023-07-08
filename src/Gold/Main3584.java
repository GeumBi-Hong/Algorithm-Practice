package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장 가까운 공통 조상
 *
 * [첫 풀이]
 * 가장 가까운 조상 노드를 구해야한다.
 * 문제에서 입력값 두 수가 있었을때 A B면 A가 B의 부모인 관계라고 했다.
 *
 * 이를 트리를 만들때 B-->A 식으로 이동할 수 있도록 인접리스트를 만든후
 *
 * 조상 노드를 찾아야하는 두 수를 기준으로 출발하여 각 깊이 마다 조상 노드를 배열에 저장하고
 *
 * 이를 다 구했다면 두 배열을 비교해서 가장 낮은 깊이의 조상 노드가 같을 때 정답을 출력한다.
 *
 *
 * [두 번째 풀이 - 검색함]
 * 일단 왜 이 문제에 두번째 케이스 답이 3인지 모르겟음 적어도 깊이 차가 2는 나야되는줄 알앗음
 * 그냥 바로 만나는 노드면 그게 정답..??
 * 처음에 인접리스트를 떠올렷지만 생각해보면 위의 가정이 맞다면 첫번째 노드의 부모노드가 쭉 있고
 * 두번쨰 노드의 부모를 찾아서 갈때 가장 먼저 만나는 부모 노드가 이 문제에서 말하는 조상 노드일것이다.
 *
 * 그러니 처음에만 첫 노드의 부모 노드 기록만 있으면 b는 그냥 탐색하면서 a의 부모와 같다면 출력하면된다.
 * 그러니 그냥 1차원 배열로 부모노드의 값을 저장하고
 * 그 1차원 배열을 돌면서 a 의 부모노드에 해당하는 값들을 체크한다.
 * 그 후 b에서 다시 탐색할때 a의 부모 노드를 만나면 정답을 출력하는 식으로 하면된다.
 *
 * [세번째 풀이] 최소 공통 조상 (LCA, Lowest Common Ancestor)
 * 알고리즘을 이용하여 푸는 방법도 있는듯 하다.
 */
public class Main3584 {

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); //테스트 케이스 수
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        //테스트 케이스 수 만큼 반복
        while (T --> 0) {
            //노드 개수
            int N = Integer.parseInt(br.readLine());
            int[] parent = new int[N + 1]; //부모 노드의 값을 저장할 배열
            for (int i = 0; i < N - 1; i++) {

                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                // treeList[child].add(parent); 인접리스트 할 필요가없을듯
                //그냥 부모 노드만 일단 알고 있으면 되서
                parent[c] = p;
            }

            st = new StringTokenizer(br.readLine());

            int findA = Integer.parseInt(st.nextToken());
            int findB = Integer.parseInt(st.nextToken());


            boolean[] checkParent = new boolean[N + 1];

            //일단 그 입력값 노드 중에 첫번째꺼의 부모노드를 찾는다.

            while (findA != 0) {
                checkParent[findA] = true;
                findA = parent[findA];
            }

            //그래서 위에서 구한 findA의 부모중 가장 먼저 만나는 애가 정답노드이다.

            while (true) {
                if (checkParent[findB]) {
                    sb.append(findB).append("\n");
                    break;
                }
                findB = parent[findB];
            }

        }
        System.out.println(sb);
    }
}
