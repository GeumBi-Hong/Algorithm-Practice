package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//소형기관차
public class Main2616 {

static int answer=-1;
static int max;
static int[] plus;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] train =  new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i <N;i++){
            train[i] = Integer.parseInt(st.nextToken());
        }

         max = Integer.parseInt(br.readLine());


        plus = new int[N-(max-1)];//

        for(int i = 0; i<N-(max-1);i++){
           for(int j=i;j<=i+(max-1);j++){
               plus[i]+=train[j];
            }

        }



       dfs(0,1,0,true);

        System.out.println(answer);

    }
    public static void dfs(int index,int count,int total,boolean isCheck){


        if(index > plus.length-1){
            return;
        }
        if(isCheck){
            total+=plus[index];
        }


        if(count==3){


            if(answer <total){
                answer= total;
              //  System.out.println(total);
              //  System.out.println(total+plus[index]);
             //   System.out.println(index);
            }
           return;
        }

        //했다면
        dfs(index+max,count+1,total,true);
        //안했다면
        dfs(index+1,count,total,false);
    }
}
