package binaryTree;

public class Generator {
    public  static BiNode geteCBT(){
        BiNode root=new BiNode(0);
        BiNode node1=new BiNode(1);
        BiNode node2=new BiNode(2);
        BiNode node3=new BiNode(3);
        BiNode node4=new BiNode(4);
        BiNode node5=new BiNode(5);
        BiNode node6=new BiNode(6);
        BiNode node7=new BiNode(7);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        node3.left=node7;
        return root;
    }
    public static BiNode getFBT(){
        BiNode root=new BiNode(0);
        BiNode node1=new BiNode(1);
        BiNode node2=new BiNode(2);
        BiNode node3=new BiNode(3);
        BiNode node4=new BiNode(4);
        BiNode node5=new BiNode(5);
        BiNode node6=new BiNode(6);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        return root;
    }
    public static BiNode getAVL(){
        BiNode root=new BiNode(0);
        BiNode node1=new BiNode(1);
        BiNode node2=new BiNode(2);
        BiNode node3=new BiNode(3);
        BiNode node4=new BiNode(4);
        BiNode node5=new BiNode(5);
        BiNode node6=new BiNode(6);
        BiNode node7=new BiNode(7);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        node3.left=node7;
        return root;
    }
    public static BiNode  getBiTree(){
        BiNode root=new BiNode(0);
        BiNode node1=new BiNode(1);
        BiNode node2=new BiNode(2);
        BiNode node3=new BiNode(3);
        BiNode node4=new BiNode(4);
        BiNode node5=new BiNode(5);
        BiNode node6=new BiNode(6);
        BiNode node7=new BiNode(7);
        BiNode node8=new BiNode(8);
        BiNode node9=new BiNode(9);
        BiNode node10=new BiNode(10);
        BiNode node11=new BiNode(11);
        BiNode node12=new BiNode(12);
        BiNode node13=new BiNode(13);
        BiNode node14=new BiNode(14);
        BiNode node15=new BiNode(15);
        BiNode node16=new BiNode(16);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        node3.left=node7;
        node3.right=node8;
        node4.left=null;
        node4.right=null;
        node5.left=node11;
        node5.right=node12;
        node6.left=null;
        node6.right=null;
        node7.left=node9;
        node7.right=node10;
        node8.left=node13;
        node8.right=node14;
        node9.left=null;
        node12.left=node15;
        node12.right=node16;
        return root;
    }
    public static BiNode onlyRight(){
        BiNode root=new BiNode(0);
        BiNode node1=new BiNode(1);
        BiNode node2=new BiNode(2);
        BiNode node3=new BiNode(3);
        BiNode node4=new BiNode(4);
        root.right=node1;
        root.left=null;
        node1.right=node2;
        node1.left=null;
        node2.right=node3;
        node2.left=null;
        node3.left=null;
        node3.right=node4;
        node4.left=null;
        node4.right=null;
        return root;
    }
    public static BiNode onlyLeft(){
        BiNode root=new BiNode(0);
        BiNode node1=new BiNode(1);
        BiNode node2=new BiNode(2);
        BiNode node3=new BiNode(3);
        BiNode node4=new BiNode(4);
        root.left=node1;
        root.right=null;
        node1.left=node2;
        node1.right=null;
        node2.left=node3;
        node2.right=null;
        node3.right=null;
        node3.left=node4;
        node4.right=null;
        node4.left=null;
        return root;
    }
    public static SpecialBiNode getSpecialBiTree(){
        SpecialBiNode root=new SpecialBiNode(0);
        SpecialBiNode node1=new SpecialBiNode(1);
        SpecialBiNode node2=new SpecialBiNode(2);
        SpecialBiNode node3=new SpecialBiNode(3);
        SpecialBiNode node4=new SpecialBiNode(4);
        SpecialBiNode node5=new SpecialBiNode(5);
        SpecialBiNode node6=new SpecialBiNode(6);
        root.parent=null;
        root.left=node1;
        root.right=node2;
        node1.parent=root;
        node2.parent=root;
        node1.left=node3;
        node1.right=node4;
        node3.parent=node1;
        node4.parent=node1;
        node2.left=node5;
        node4.right=node6;
        node5.parent=node2;
        node6.parent=node4;
        return root;
    }
    public  static SpecialBiNode getSpecialOnlyRight(){
        SpecialBiNode root=new SpecialBiNode(0);
        SpecialBiNode node1=new SpecialBiNode(1);
        SpecialBiNode node2=new SpecialBiNode(2);
        SpecialBiNode node3=new SpecialBiNode(3);
        SpecialBiNode node4=new SpecialBiNode(4);
        root.left=null;
        root.parent=null;
        root.right=node1;
        node1.parent=root;
        node1.right=node2;
        node2.parent=node1;
        node2.right=node3;
        node3.parent=node2;
        node3.right=node4;
        return root;
    }
}
