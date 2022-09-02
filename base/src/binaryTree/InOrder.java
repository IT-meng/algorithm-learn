package binaryTree;

import java.util.Stack;

public class InOrder {
    //递归中序遍历
    public  static void inOrder1(BiNode root){
        if(root!=null){
            inOrder1(root.left);
            System.out.print(root.data+"\t");
            inOrder1(root.right);
        }
    }
    //非递归中序遍历
    public  static void inOrder2(BiNode root){
        //1.将根结点一路朝左的结点压入栈中直到左为空
        //2.弹出栈顶元素并打印，同时对当前节点的右孩子重复1的操作
        Stack<BiNode> stack=new Stack<>();
        BiNode tem=root;
        while(tem!=null){
            stack.push(tem);
            tem=tem.left;
        }
        while(!stack.isEmpty()){
           BiNode top=stack.pop();
            System.out.print(top.data+"\t");
            top=top.right;
            while(top!=null){
                stack.push(top);
                top=top.left;
            }

        }

    }
    //左神版
    public static void inOrder3(BiNode root){
        if(root==null)return;
        BiNode head=root;
        Stack<BiNode> stack=new Stack<>();
        while(!stack.isEmpty()||head!=null){
            if(head!=null){
                stack.push(head);
                head=head.left;
            }else{
                BiNode tem=stack.pop();
                System.out.print(tem.data+"\t");
                head=tem.right;
            }
        }

    }

    public static void main(String[] args) {
//        BiNode root=Generator.generateBiTree();
//        inOrder1(root);
//        System.out.println();
//        System.out.println("=================================");
//        inOrder2(root);
//        System.out.println();
//        System.out.println("=================================");
//        inOrder3(root);
        int[] arr={10,4,5,7,2,6,9,8,3,1};
        BiNode root=new GenerateBST().createBST(arr);
        inOrder1(root);
    }
}
