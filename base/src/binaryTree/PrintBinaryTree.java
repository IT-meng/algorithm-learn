package binaryTree;

public class PrintBinaryTree {





//        public static class Node {
//            public int value;
//            public Node left;
//            public Node right;
//
//            public Node(int data) {
//                this.value = data;
//            }
//        }

        public static void printTree(BiNode head) {
            System.out.println("Binary Tree:");
            printInOrder(head, 0, "H", 17);
            System.out.println();
        }

        public static void printInOrder(BiNode head, int height, String to, int len) {
            if (head == null) {
                return;
            }
            printInOrder(head.right, height + 1, "v", len);
            String val = to + head.data + to;
            int lenM = val.length();
            int lenL = (len - lenM) / 2;
            int lenR = len - lenM - lenL;
            val = getSpace(lenL) + val + getSpace(lenR);
            System.out.println(getSpace(height * len) + val);
            printInOrder(head.left, height + 1, "^", len);
        }

        public static String getSpace(int num) {
            String space = " ";
            StringBuffer buf = new StringBuffer("");
            for (int i = 0; i < num; i++) {
                buf.append(space);
            }
            return buf.toString();
        }

        public static void main(String[] args) {
            BiNode head = new BiNode(1);
            head.left = new BiNode(-222222222);
            head.right = new BiNode(3);
            head.left.left = new BiNode(Integer.MIN_VALUE);
            head.right.left = new BiNode(55555555);
            head.right.right = new BiNode(66);
            head.left.left.right = new BiNode(777);
            printTree(head);

            head = new BiNode(1);
            head.left = new BiNode(2);
            head.right = new BiNode(3);
            head.left.left = new BiNode(4);
            head.right.left = new BiNode(5);
            head.right.right = new BiNode(6);
            head.left.left.right = new BiNode(7);
            printTree(head);

            head = new BiNode(1);
            head.left = new BiNode(1);
            head.right = new BiNode(1);
            head.left.left = new BiNode(1);
            head.right.left = new BiNode(1);
            head.right.right = new BiNode(1);
            head.left.left.right = new BiNode(1);
            printTree(head);

        }









}
