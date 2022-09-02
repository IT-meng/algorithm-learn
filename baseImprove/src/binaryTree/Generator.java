package binaryTree;

public class Generator {
    public  static Node geteCBT(){
        Node root=new Node(0);
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        Node node6=new Node(6);
        Node node7=new Node(7);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        node3.left=node7;
        return root;
    }
    public static Node getFBT(){
        Node root=new Node(0);
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        Node node6=new Node(6);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        return root;
    }
    public static Node getAVL(){
        Node root=new Node(0);
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        Node node6=new Node(6);
        Node node7=new Node(7);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        node3.left=node7;
        return root;
    }
    public static Node  getBiTree(){
        Node root=new Node(0);
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        Node node6=new Node(6);
        Node node7=new Node(7);
        Node node8=new Node(8);
        Node node9=new Node(9);
        Node node10=new Node(10);
        Node node11=new Node(11);
        Node node12=new Node(12);
        Node node13=new Node(13);
        Node node14=new Node(14);
        Node node15=new Node(15);
        Node node16=new Node(16);
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
        node9.right=null;
        node12.left=node15;
        node12.right=node16;
        return root;
    }
    public static Node onlyRight(){
        Node root=new Node(0);
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
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
    public static Node onlyLeft(){
        Node root=new Node(0);
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
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


}
