package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main7662 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); //테스트 케이스 수

        while(T -->0){


            int k = Integer.parseInt(br.readLine()); // 입력 케이스 수
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();//트리맵

            for (int i=0; i<k;i++){

                String[] input = br.readLine().split(" ");

                char c = input[0].charAt(0);
                int num = Integer.parseInt(input[1]);

                if(c=='I'){//삽입
                    treeMap.put(num, treeMap.getOrDefault(num,0)+1);
                }else { // 그렇지 않으면 제거

                    if(treeMap.isEmpty())continue; //큐가 비어있다면 진행하지않음

                    int n = (num == 1) ? treeMap.lastKey() : treeMap.firstKey();


                    if (treeMap.put(n, treeMap.get(n) - 1) == 1) {
                        treeMap.remove(n);
                    }
                }
            }
            System.out.println(treeMap.size() == 0 ? "EMPTY" : treeMap.lastKey() + " " + treeMap.firstKey());
        }



    }

}
