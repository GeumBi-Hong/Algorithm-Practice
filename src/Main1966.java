import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main1966 {

    public static void main(String[] args) throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;

        int T= Integer.parseInt(br.readLine());

        while (T -- >0){

            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int count = 0;
            LinkedList<int[]> linkedList= new LinkedList<>();
            st = new StringTokenizer(br.readLine()," ");

            for (int i = 0 ; i < N ; i++){
                linkedList.offer(new int[]{i,Integer.parseInt(st.nextToken())});
            }


            while (!linkedList.isEmpty()){

                int[] first =linkedList.poll();
                boolean flag = true;

                for (int i= 0; i< linkedList.size(); i++){

                    if (first[1]<linkedList.get(i)[1]){
                        linkedList.offer(first);

                        for (int j =0 ; j<i; j++){
                            linkedList.offer(linkedList.poll());
                        }

                        flag =false;
                        break;

                    }
                }

               if (flag ==false){
                   continue;
               }

               count ++;
               if (first[0]==M){
                   break;
               }



            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);


    }
}
