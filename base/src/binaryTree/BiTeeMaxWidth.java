package binaryTree;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
//获取一棵二叉树的最大宽度
public class BiTeeMaxWidth {
    //1、用hash表实现
    public static int getMaxWidth1(BiNode root){
        if(root==null)return 0;
        //对树进行层次遍历，并记录每层的结点数，求出最大值
        Queue<BiNode> queue=new LinkedList<>();
        //将根结点入队
        queue.add(root);
        HashMap<BiNode,Integer> map=new HashMap<BiNode, Integer>();
        //将根结点所在层加入hashmap
        map.put(root,1);
        //记录当前所在的层，及当前层的结点数
        int CurLevel=1,CurNodes=0,max=Integer.MIN_VALUE;
        //当队列不为空时
        while(!queue.isEmpty()){
        //队头元素出队
            BiNode tem=queue.remove();
            //每出队一个元素将其左右孩子入队，并将其层数记入hashmap中
            if(tem.left!=null){
                queue.add(tem.left);
                map.put(tem.left,map.get(tem)+1);
            }
            if(tem.right!=null){
                queue.add(tem.right);
                map.put(tem.right,map.get(tem)+1);
            }
            //出队元素在当前层，CurNodes++
            if(map.get(tem)==CurLevel){
                CurNodes++;
            }else{//不在当前层，结算max，CurLevel++，CurNodes置1
                max=max>CurNodes?max:CurNodes;
                CurLevel=map.get(tem);
                CurNodes=1;
            }
            //按照我写的逻辑必须有下一层的结点出现才会结算max，就会导致队列为空时最后一层未结算
        }
        //队列为空时结算
        max=max>CurNodes?max:CurNodes;
    return max;

    }
    //2、不用hash表
    public static int getMaxWidth2(BiNode root){
        if(root==null)return 0;
        Queue<BiNode> queue=new LinkedList<>();
        queue.add(root);
        BiNode curEnd=root;//当前层的结束结点
        BiNode nextEnd=null;//下一层的结束节点
        int CurNodes=0;//当前层的结点总数
        int max=Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            BiNode tem=queue.remove();
            //让nextEnd永远等于最新入队的结点
            if(tem.left!=null){
                queue.add(tem.left);
                nextEnd=tem.left;
            }
            if(tem.right!=null){
                queue.add(tem.right);
                nextEnd= tem.right;
            }
            if(tem!=curEnd){//tem不是当前层的结束
                CurNodes++;
            }else
            {
                CurNodes++;
                //更新当前层的结束
                curEnd=nextEnd;
                //下一层的结束置为空
                nextEnd=null;
                //结算max
                max=max>CurNodes?max:CurNodes;
                CurNodes=0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BiNode root=Generator.getBiTree();
        System.out.println(getMaxWidth1(root));
        System.out.println(getMaxWidth2(root));
        System.out.println("====================================");
        BiNode root2=Generator.getBiTree();
        System.out.println(getMaxWidth1(root2));
        System.out.println(getMaxWidth2(root2));
    }
}
