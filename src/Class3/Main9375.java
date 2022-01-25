package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
//패션왕 신해빈 (조합 , 해쉬맵)
public class Main9375 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); //테스트케이스 수


        while (T-- > 0) { //테스트 케이스 수 만들 반복


            int n = Integer.parseInt(br.readLine()); //가진 의상 개수
            int answer = 1;
            HashMap<String, Integer> hashMap = new HashMap<>(); //(옷종류 , 그 종류의 옷 개수)

            while (n-- > 0) { //가진 의상 수 만큼 반복
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String cloth = st.nextToken();
                //((옷종류 , 그 종류의 옷 개수) 이렇게 저장하려고한다.
                //getOrDefault(key ,defaultValue) 를 쓰면
                //key 값이 존재하면 key에 매핑된 가져오고 없으면 defaultValue 값으로 가져온다.
                //hashMap.getOrDefault(cloth, 0) + 1 을 해줘서 해당하는 종류의 옷이 없었을때 +1을 하고
                //있다면 그 value 값에 +1 을 해주어서 옷의 개수를 세어준다.
                hashMap.put(cloth, hashMap.getOrDefault(cloth, 0) + 1);


            }

            for (int count : hashMap.values()) { //모든 hashMap의 value 값을 조회한다.
                answer = answer *(count + 1);
                // +1 을 해준 이유는 아예 그 종류에 옷을 않입는 경우를 포함하여 계산해주기 위해서이다.

            }

            sb.append(answer-1).append("\n"); // -1을 해주는 이유는 알몸인 상태의 경우를 빼주기 위해서이다.

        }

        System.out.print(sb);
    }
}
