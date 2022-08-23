package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1043 {
    static int []  parent; //자기 부모가 몇번인지 저장할 배열
    static int parentTrue; // 진실을 알고있는 집합의 사람들 사이의 부모 인덱스
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 파티의 개수

        parent =  new int[N+1]; //1번부터 ~N번째 사람이라 패딩 +1

        for(int i = 1 ; i <=N;i++){ //처음은 자기 자신이 부모이다.
            parent[i]=i;
        }


        /**1.진실을 아는 사람의 집합을 만든다.*/
           parentTrue =0; //초기화

           st = new StringTokenizer(br.readLine());
           int participants = Integer.parseInt(st.nextToken()); //진실을 알고있는 사람 수

           int [] truePeople = new int[participants];
           for(int p  = 0 ; p < participants; p++){
              truePeople[p] = Integer.parseInt(st.nextToken());
           }

           //진신을 알고있는 사람의 집합을 만들어준다.
           for(int p = 0; p <participants-1;p++){
               union(truePeople[p],truePeople[p+1]);
           }
           //진실을 아는사람이 있는 경우에만 가능하다.
            if(truePeople.length!=0){
                parentTrue=truePeople[0];
            }

            /** 파티의 참가하는 참가자들의 정보를 가지고 집합을 갱신한다 */
           int [][] party = new int[M][];

           for(int i = 0 ; i <M ;i++){ //파티 개수 만큼 반복한다.
               st = new StringTokenizer(br.readLine());
               int p = Integer.parseInt(st.nextToken());

               party[i] = new int[p]; //인원 수 만큼 배열을 만들어줌

               for(int j = 0; j < p ; j++){
                   party[i][j]=Integer.parseInt(st.nextToken());
               }

               for(int j = 0; j < p-1 ; j++){ // 집합을 만든다. (여기서 진실을 아는 사람이 존재하면 진실을 모르는 사람이 진실을 아는사람으로 된다)
                  union(party[i][j],party[i][j+1]);
               }

           }

        int count= 0; //참여할 수 있는 파티 개수
        for(int i = 0 ; i <M ;i++){
           boolean flag = false; //참여가 가능한지 불가능 한지 (true =참여불가능)
            for(int j = 0; j < party[i].length; j++){
               if(find(party[i][j])==parentTrue){ //참여자 중에 진실된 사람이 있는경우
                   flag=true; //참여 불가능
                   break;
               }

            }
            if(!flag){
                //참여가능할때만 정답 증가
                count++;
            }


        }

        System.out.println(count);
    }

    private static int find(int a){
        //자기 자신이 부모면 자기를 리턴
        if(parent[a]==a){
            return a;
        }

        return parent[a]= find(parent[a]);
    }
    private static void union(int a,int b){

        a= find(a); //a의 부모를 찾는다.
        b= find(b); //b의 부모를 찾는다.

        if(a!=b){ // a와b가 다르면 서로 다른 집합에 속해 있다는 의미이기 때문에 합칠 수 있다.
            if(a==parentTrue){ //a가 만약 진실을 알고있는 집합의 부모였다면
                parent[b]=a; //a집단으로 b를 넣는다.
            }else if(b==parentTrue) { //b가 만약 진실을 알고있는 집합의 부모였다면
                parent[a]=b; //b집단으로 a를 넣는다.
                //- 진실을 모르는 사람이 진실을 아는 사람과 같은 파티를 참여했기때문에 그 사람 또한 진실을 알게 되니 진실을 아는 사람쪽의 집단으로 넣어준다.
            }else {
                //위의 경우가 아니라면 어느쪽이든 넣어줘도 상관없다.
                parent[b]=a;
            }
        }



    }
}
