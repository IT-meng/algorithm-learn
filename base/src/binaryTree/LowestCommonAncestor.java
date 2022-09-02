package binaryTree;

import java.util.HashMap;
import java.util.HashSet;
//找一棵树中两个结点的最低公共祖先
public class LowestCommonAncestor {
    public static BiNode searchLCA1(BiNode o1,BiNode o2,BiNode root){
        //从o1开始一路往上找，记录它上面的结点
        //要能往上找先得知道每个结点的父亲
        HashMap<BiNode ,BiNode> fatherMap=new HashMap<>();
        fatherMap.put(root,root);//root的父亲就是他自己
        process(fatherMap,root);
        HashSet<BiNode> set=new HashSet<>();
        //在set里记录从O1开始往上的结点
        BiNode Cur=o1;
        while(Cur!=fatherMap.get(Cur)){
            set.add(Cur);
            Cur=fatherMap.get(Cur);
        }
        set.add(Cur);
        //从o2往上的序列第一个出现在set里的就是LCA
        Cur=o2;
        while(!set.contains(Cur)){
            Cur=fatherMap.get(Cur);
        }
        return Cur;
    }

    //此过程将每个结点的parent存在Hash表里
    public static void process(HashMap<BiNode,BiNode> fatherMap,BiNode root){
        if(root==null)return;
        if(root.left!=null){
            fatherMap.put(root.left,root);
        }
        if(root.right!=null){
            fatherMap.put(root.right,root);
        }
        process(fatherMap,root.left);
        process(fatherMap,root.right);
    }
    //骚一点
    public static BiNode searchLCA2(BiNode o1,BiNode o2,BiNode root){
        //是null返回null，是o1返回o1，是o2返回o2
        if(root==null||root==o1||root==o2){
            return root;
        }
        BiNode left=searchLCA2(o1,o2,root.left);
        BiNode right=searchLCA2(o1,o2,root.right);
        //左右都不为空返回自己
        if(left!=null&&right!=null){
            return root;
        }
        //返回左右中不为空的那个(左右都为空返回空)
        return left!=null?left:right;
    }

    public static void main(String[] args) {
        BiNode root=Generator.getBiTree();
        BiNode o1=root.left.left.left.left;
        BiNode o2=root.right.left.right.left;
        System.out.println(searchLCA2(o1,o2,root)==null?"null":searchLCA2(o1,o2,root).data);

    }
}
