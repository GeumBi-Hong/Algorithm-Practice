package Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main10815 {

    static List<Integer> num_List = new ArrayList<>();
    static List<Integer> check_List = new ArrayList<>();

    static int N,M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i <N;i++){
            int n = Integer.parseInt(st.nextToken());
            num_List.add(n);
        }

        M = Integer.parseInt(br.readLine());
       int [] answer = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i <M;i++){
            int n = Integer.parseInt(st.nextToken());
            check_List.add(n);
        }

        //이분 탐색을 위해 정렬
        Collections.sort(num_List);


        for(int i = 0 ; i < check_List.size();i++){
            if(BinarySearch(check_List.get(i))){ //수가 존재하면 1 그렇지 않으면 0
                answer [i]= 1;
            }
        }

        for(int n : answer){
            sb.append(n+" ");
        }
        System.out.println(sb);
    }



    private static boolean BinarySearch(int ans){

        int left = 0;
        int right = num_List.size()-1;

        while (left<=right){
            int midIndex = (left+right)/2;
            int mid = num_List.get(midIndex);
            if(mid<ans)left=midIndex+1;
            else if(mid>ans)right=midIndex-1;
            else return true;


        }

       return false;
    }
}
