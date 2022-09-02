package binaryTree;


//求一棵二叉树上任意两个节点之间的距离的最大值
//1、头节点不参与时：
//左，右子树上任意两点之间的最大值
//2、头节点参与时：
// 左右子树的高度之和加1
public class MaxDistance {
    public static int getMaxdis(Node root){
        return process(root).maxdis;
    }

    public static Info process(Node root){
        if(root==null){
            return new Info(0,0);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        //做出来当前节点的Info
        //1、当前节点参与
        int yes = leftInfo.height+ rightInfo.height+1;
        //2、当前节点不参与
        int no =Math.max(leftInfo.maxdis,rightInfo.maxdis);
        return new Info(Math.max(leftInfo.height,rightInfo.height)+1,Math.max(yes,no));
    }

    public static void main(String[] args) {
        Node node1=new Node(1,null,null);
        Node node2=new Node(2,null,null);
        Node node3=new Node(3,null,null);
        Node node4=new Node(4,null,null);
        Node node5=new Node(5,null,null);
        Node node6=new Node(6,null,null);
        Node node7=new Node(7,null,null);
        Node node8=new Node(8,null,null);
        Node node9=new Node(9,null,null);
        Node node10=new Node(10,null,null);
        Node node11=new Node(11,null,null);
        Node root =new Node(12,null,null);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node3.left=node4;
        node4.left=node5;
        node4.right=node6;
        node6.right=node7;
        node2.left=node8;
        node2.right=node9;
        node8.right=node10;
        System.out.println(getMaxdis(root));
    }
}

//返回值信息
class Info{
  int height;//高度
  int maxdis;//以当前节点为根的子树(根节点不参与的任意两点间的最大距离)

    public Info(int height, int maxdis) {
        this.height = height;
        this.maxdis = maxdis;
    }
}
class Node{
    int data;
    Node left;
    Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
  public   Node(int data){
        this.data=data;
        right=null;
        left=null;
    }

    public Node() {
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}