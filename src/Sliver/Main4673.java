package Sliver;



public class Main4673{

    public static void main(String[] args)  {

        int Max =10_001;
        StringBuilder sb = new StringBuilder();

        boolean [] selfNum = new boolean[Max];


        for(int i =1; i <Max;i++){

            int n = i;
            int sum = i;
            while (n!=0){
                int unit = n%10;
                sum+=unit;
                n=n/10;
            }
            if(sum<Max){
                selfNum[sum]=true;
            }

        }



        for(int i =1; i<Max;i++){
            if(!selfNum[i]){
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}

