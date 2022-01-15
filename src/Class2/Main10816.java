package Class2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10816 {
    static  int []array;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); //상근이가 가지고 있는 숫자 카드 개수
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
       array = new int[N];


        for (int i = 0; i <N ; i++){ //int 형 배열에 상근이가 가진 숫자 카드들을 저장한다.
            array[i] = Integer.parseInt(st.nextToken());
        }
        //이분 탐색을 하기전에 배열을 정렬시켜준다.
        Arrays.sort(array);

        int M = Integer.parseInt(br.readLine()); //주어진 정수의 개수
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0 ; i <M ; i++){
            int n = Integer.parseInt(st.nextToken());
            bw.append((high_Index(n))-low_Index(n)+" "); //상한 인덱스와 하한 인덱스의 뺴기 값을 넣어준다.
        }

        bw.flush();//출력
        bw.close();
        br.close();

    }




    static public int low_Index (int n ){

        int start = 0 ; // 시작인덱스
        int end = array.length ; //끝 인덱스
        int mid ;

        while (start <end){
            mid = start+ (end-start)/2; //(start+end)/2 와 같지만 << 이렇게 하면 overflow (Integer.Max) 가 발생할수있다.

            if(array[mid]>=n) {
               end=mid; //중간인덱스를 끝인덱스로 바꿔 탐색 범위를 줄인다.
            }else {
                start =mid+1;
            }

        }
            return start;
    }

    static  public int high_Index(int n) {

        int start = 0 ;
        int end = array.length;
        int mid;


        while ( start<end){
            mid = start + (end-start)/2;

            if (array[mid]>n){
                end=mid;
            }else {
                start =mid+1;
            }
        }
        return start;
    }
}
