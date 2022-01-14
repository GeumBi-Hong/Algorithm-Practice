package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10828 {

    public static  int stack [];
    public static  int index = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        stack = new int[N];
        while (N -- > 0 ){
            String[] str = br.readLine().split(" ");

            switch (str[0]){
                case "push" :{
                    push(Integer.parseInt(str[1]));
                    break;
                }
                case "pop" :{
                    sb.append(pop()+"\n");
                    break;
                }
                case "size" :{
                    sb.append(size() + "\n");
                    break;
                }
                case "empty" :{
                    sb.append(empty() + "\n");
                    break;
                }
                case "top" :{
                    sb.append(top() + "\n");
                    break;
                }
            }
        }
        System.out.print(sb);

    }

    public static void push (int n){
        stack[index]=n;
        index++;
    }

    public static int pop () {
        if (index == 0) {
            return -1;
        } else {
            int popNum = stack[index-1];
            index--;
            return popNum;
        }

    }

    public static int size () {
        return index;
    }
    public static int empty () {
        if (index ==0){
            return 1;
        }
        else {
            return 0;
        }
    }
    public  static int top ( ){
        if (index==0){
            return  -1;
        }else {
            return stack[index-1];
        }
    }



}
