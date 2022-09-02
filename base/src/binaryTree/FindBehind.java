package binaryTree;
//找一个结点中序遍历的后继结点(结点中有parent指针)
public class FindBehind {
    public static SpecialBiNode findBehind(SpecialBiNode o1){
        /*
        * 1、o1有右孩子
        * o1中序的后继为其右树最左结点
        * 2、o1无右孩子
        * 看o1是不是它父亲的左孩子，如果是o1的后继为它父亲，如果不是{
        * o1=o1.parent;
        * parent=o1.parent;
        * }*/
        if(o1.right!=null){
            return leftMost(o1.right);
        }else
        {
            SpecialBiNode Cur=o1;
            while(Cur.parent!=null && Cur!=Cur.parent.left){
                Cur=Cur.parent;
            }
            return Cur.parent;
        }

    }

    public static SpecialBiNode  leftMost(SpecialBiNode root) {
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        SpecialBiNode root=Generator.getSpecialBiTree();
        System.out.println(findBehind(root.left.right.right)==null?"null":
                findBehind(root.left.right.right).val);
        System.out.println("---------------------------------------");
        System.out.println(findBehind(Generator.getSpecialOnlyRight().right.right.right.right)==null?"null":
                findBehind(Generator.getSpecialOnlyRight()).val);
    }
}
class SpecialBiNode{
    int val;
    SpecialBiNode left;
    SpecialBiNode right;
    SpecialBiNode parent;
    public SpecialBiNode(int val) {
        this.val = val;
    }
}