package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class Node {
    char data;
    Node left;
    Node right;

    Node(char data) {
        this.data = data;
    }
}

 class Tree {
    public Node root;

    public void createNode(char data, char leftData, char rightData) {
        if (root == null) {//초기 상태일때 (처음 값을 넣을때)
            root = new Node(data);

            if (leftData !='.') {
                root.left = new Node(leftData);
            }
            if (rightData !='.') {
                root.right = new Node(rightData);
            }

        } else { //초기 상태가 아니라면 원래있는 노드들에서 값을 찾아 넣어줘야한다.
            searchNode(root,data,leftData,rightData);
        }
    }

    public void searchNode (Node root ,char data , char leftData ,char rightData){
        if(root == null){ //도착한 노드가 null이면 재귀 종료
            return;
        }

        else if (root.data == data){ //들어갈 위치를 찾았다면 왼쪽 or 오른쪽 노드에 값이 있으면 값을 넣어준다.
            if (leftData !='.') {
                root.left = new Node(leftData);
            }
            if (rightData !='.') {
                root.right = new Node(rightData);
            }
        }else { //찾지못하고 방문할 노드가 남아있다면 재귀한다.
            searchNode(root.left, data, leftData, rightData); //왼쪽 재귀 탐색
            searchNode(root.right, data, leftData, rightData); //오른쪽 재귀 탐색
        }
    }

     // 전위순회 : 루트 -> 좌 -> 우
     public void preorder(Node root){
         System.out.print(root.data); //먼저 가운데 출력
         if(root.left!=null) preorder(root.left); //그 다음 왼쪽
         if(root.right!=null) preorder(root.right); //마지막 오른쪽
     }

     // 중위순회 : 좌 -> 루트 -> 우
     public void inorder(Node root){
         if(root.left!=null) inorder(root.left); //왼쪽 먼저
         System.out.print(root.data); //그 다음 중앙 출력
         if(root.right!=null) inorder(root.right); //마지막으로 오른쪽
     }

     // 후위순회 : 좌 -> 우 -> 루트
     public void postorder(Node root){
         if(root.left!=null) postorder(root.left); //왼쪽 먼저
         if(root.right!=null) postorder(root.right); //그 다음 오른쪽
         System.out.print(root.data);
     }
}
public class Main1991 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        while (N-- > 0) {
            char data[];
            //공백을 없애준 후(replaceAll(" ", ""))한 문자열로 만든다음 한글자마다로 잘라 char 배열을 만든것임
            data = br.readLine().replaceAll(" ", "").toCharArray();
            tree.createNode(data[0], data[1], data[2]);

        }

        //전위 순회
        tree.preorder(tree.root);
        System.out.println();

        //중위 순회
        tree.inorder(tree.root);
        System.out.println();

        //후위 순회
        tree.postorder(tree.root);
   }
}