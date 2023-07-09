import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 사촌
 *
 * [첫 풀이]
 * -사촌의 수는 : k 의 부모 형제들의 자식노드의 개수 합
 * - 그럼 이 관계는 먼저 어떻게 만들어아야하지
 * - 연속된 수가 끊기는 부분이 다음 깊이 인거같음
 *
 */
public class Main9489 {

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String str = "";

        while (true) {

            str = br.readLine();

            st = new StringTokenizer(str);

            int n = Integer.parseInt(st.nextToken()); //노드 수 (1 <= n <= 1,000)
            int k = Integer.parseInt(st.nextToken()); //노드의 번호  (1 <= k <= 1,000,000)

            if(n == 0 && k == 0) break;
            str = br.readLine();
            st = new StringTokenizer(str);

            int[] num = new int[n + 1];
            int[] childCount = new int[n+ 1];
            int[] parentNode = new int[n+ 1];

            if(n == 1){
               sb.append("0").append("\n");
                continue;
            }

            int parentIndex = -1;
            int kIndex = 0;
            num[0] = -1;

            for(int i = 1; i <=n; i++){
                num[i] = Integer.parseInt(st.nextToken());
                //k 노드의 인덱스 번호
                if(num[i] == k) kIndex = i;
                //num[i]에 대해서 부모노드가 누군지에 대한 인덱스 번호
                //+1차이가 아니면 다음 부모 밑으로 들어가야하기 때문에 부모인덱스 +1을 해서 다음 부모노드를 가르키도록한다.
                if(num[i] != num[i - 1] + 1) parentIndex++;
                parentNode[i] = parentIndex;
                childCount[parentIndex]++;

            }


            int answer = 0;
            //k부모의 부모 인덱스값
            int kParent = parentNode[parentNode[kIndex]];

            for(int i = 1; i <= n;i++){

                //k를 포함하는 부모의 자식개수는 포함하면 안된다. (사촌관계가 아니니까)
                if(parentNode[kIndex] == i) {
                    continue;
                }

                //k의 부모의 부모를 가지고 있는 노드의 자식 개수를 합한다.
                if(parentNode[i] == kParent) {
                    answer += childCount[i];
                }
            }

            sb.append(answer).append("\n");

        }

        System.out.println(sb);

    }
}
