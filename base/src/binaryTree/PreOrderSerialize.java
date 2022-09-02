package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

//先序序列化
//给我一棵二叉树将其转化为字符串储存起来
public class PreOrderSerialize {

    public static String preOrderSerialize(BiNode root){
        String res=new String();
        //将结点中的data存在String里以_作为结束的标志如果结点为null就存#
        if(root==null){
            res+="#_";
            return res;
        }
        res+=root.data+"_";
        res+=preOrderSerialize(root.left);
        res+=preOrderSerialize(root.right);
        return res;

    }
    public static BiNode anti_preOrderSerialize(String str){
        String[] arr=str.split("_");
        Queue<String> queue=new LinkedList<>();
        for (int i = 0; i < arr.length ; i++) {
            queue.add(arr[i]);
        }
       return process(queue);
    }
    //消费队列建二叉树
    public static BiNode process(Queue<String> queue){
     String data=queue.poll();
     if(data.equals("#"))return null;
     //先建根节点，再建左子树，再建右子树
     BiNode root=new BiNode(Integer.parseInt(data));
     root.left=process(queue);
     root.right=process(queue);
     return root;
    }

    public static void main(String[] args) {
        BiNode root=Generator.getFBT();
        String str=preOrderSerialize(root);
        System.out.println(str);
        BiNode head=anti_preOrderSerialize(str);
        PrintBinaryTree.printTree(root);
        PrintBinaryTree.printTree(head);
        System.out.println();


    }

}
