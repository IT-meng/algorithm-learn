package binaryTree;

//二叉树的Morris遍历空间复杂度O(1)
public class Morris {
 //cur指向当前节点，一开始时指向根节点
    //1、cur有左孩子
    //如果cur有左孩子，找到左孩子的最右边界，如果最右边界的右指针指向null，让其指向当前节点，cur=cur.left
    //如果最右边界的右指针指向cur，让其指向null,cur=cur.right
    //2、cur没有左孩子，cur=cur.right
   //cur等于null时停止
    public static void morris(Node root){
        if(root==null)return;
        Node cur=root;
        Node mostRight=null;
        while(cur!=null){
            mostRight=cur.left;
            if(mostRight!=null){
                //有左孩子
               while(mostRight.right!=null&&mostRight.right!=cur){
                   mostRight=mostRight.right;
               }
                if(mostRight.right==null){
                    //右边界右指针为空
                    mostRight.right=cur;//让其指向当前节点
                    cur=cur.left;//cur左移
                }else{//mostRight.right==cur
                    //将其置为null cur右移
                    mostRight.right=null;
                    cur=cur.right;
                }
            }//end if
            else {
                //没有左孩子,cur右移
                cur=cur.right;
            }

        }
    }


    //Morris先序遍历:
    //morris遍历，有左树的节点会到达两次，没有左树的节点只会到达一次
    //到达一次的节点直接打印，到达两次的节点第一次到达时打印
    public static void preOrder(Node root){
        if(root==null)return;
        Node cur=root;
        Node mostRight=null;
        while(cur!=null){
            mostRight=cur.left;
            if(mostRight!=null){
                //有左孩子
                while(mostRight.right!=null&&mostRight.right!=cur){
                    mostRight=mostRight.right;
                }
                if(mostRight.right==null){
                    //右边界右指针为空,第一次到达cur
                    System.out.print(cur.data+" ");
                    mostRight.right=cur;//让其指向当前节点
                    cur=cur.left;//cur左移
                }else{//mostRight.right==cur
                    //将其置为null cur右移
                    mostRight.right=null;
                    cur=cur.right;
                }
            }//end if
            else {
                //没有左孩子,cur右移
                System.out.print(cur.data+" ");
                cur=cur.right;
            }

        }
    }

    //Morris先序遍历：
    //有左树的节点会到达两次第二次到达时打印
    //没有左树的节点只会达到一次，达到时打印
    public static void  inorder(Node root){
        if(root==null)return;
        Node cur=root;
        Node mostRight=null;
        while(cur!=null){
            mostRight=cur.left;
            if(mostRight!=null){
                //有左孩子
                while(mostRight.right!=null&&mostRight.right!=cur){
                    mostRight=mostRight.right;
                }
                if(mostRight.right==null){
                    //第一次到达
                    //右边界右指针为空
                    mostRight.right=cur;//让其指向当前节点
                    cur=cur.left;//cur左移
                }else{//mostRight.right==cur
                    //第二次到达
                    //将其置为null cur右移
                    System.out.print(cur.data+" ");
                    mostRight.right=null;
                    cur=cur.right;
                }
            }//end if
            else {
                //没有左孩子,cur右移
                //只会到达一次直接打印
                System.out.print(cur.data+" ");
                cur=cur.right;
            }

        }
    }
    //中序遍历
    public static void inorder2(Node root){
        if(root==null)return;
        inorder2(root.left);
        System.out.print(root.data+" ");
        inorder2(root.right);
    }

    //先序遍历
    public static void preorder2(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder2(root.left);
        preorder2(root.right);
    }

    //Morris后序遍历

    //把打印时机放在有左树的节点(能两次到达自己)

    //第二次到达自己时打印自己左树的右边界

    //最后打印整棵树的右边界

    public static void postOrder(Node root){
        if(root==null)return;
        Node cur=root;
        Node mostRight=null;
        while(cur!=null){
            mostRight=cur.left;
            if(mostRight!=null){
                //有左孩子
                while(mostRight.right!=null&&mostRight.right!=cur){
                    mostRight=mostRight.right;
                }
                if(mostRight.right==null){
                    //右边界右指针为空
                    mostRight.right=cur;//让其指向当前节点
                    cur=cur.left;//cur左移
                }else{//mostRight.right==cur
                    //将其置为null cur右移
                    mostRight.right=null;
                    //第二次来到cur，逆序打印cur的左树的右边界
                    Node node = reverseRight(cur.left);
                    printRight(node);
                    //打印完逆序回来
                    reverseRight(node);
                    cur=cur.right;
                }
            }//end if
            else {
                //没有左孩子,cur右移
                cur=cur.right;
            }

        }

        //最后打印整棵树的右边界
        Node node = reverseRight(root);
        printRight(node);
        //打印完reverse回去
        reverseRight(node);
    }

    //打印一棵树的右边界(从一个结点出发顺着right指针的方向打印)
    public static void printRight(Node start){
        Node cur = start;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.right;
        }
    }

    //将一棵树的右边界逆序
    public static Node reverseRight(Node root){
        if (root==null)return null;
        Node cur = root;//right相当于next方向
        Node next = root.right;
        Node head = null;
        while(next!=null){
            cur.right=head;
            head=cur;
            cur=next;
            next=next.right;
        }
        cur.right=head;
        head=cur;
        return head;
    }


    //递归后序遍历
    public static void postOrder2(Node root){
        if(root==null)return;
        postOrder2(root.left);
        postOrder2(root.right);
        System.out.print(root.data+" ");
    }


    public static boolean  isBST(Node root){
        if(root==null)return true;
        int preValue = Integer.MIN_VALUE;
        boolean ans = true;
        Node cur=root;
        Node mostRight=null;
        while(cur!=null){
            mostRight=cur.left;
            if(mostRight!=null){
                //有左孩子
                while(mostRight.right!=null&&mostRight.right!=cur){
                    mostRight=mostRight.right;
                }
                if(mostRight.right==null){
                    //第一次到达
                    //右边界右指针为空
                    mostRight.right=cur;//让其指向当前节点
                    cur=cur.left;//cur左移
                }else{//mostRight.right==cur
                    //第二次到达
                    //将其置为null cur右移
//                    System.out.print(cur.data+" ");
                    mostRight.right=null;
                    if(cur.data<=preValue){
                        //没有递增
                       ans = false;
                    }else{
                        preValue = cur.data;
                    }
                    cur=cur.right;
                }
            }//end if
            else {
                //没有左孩子,cur右移
                //只会到达一次直接打印
//                System.out.print(cur.data+" ");
                if(cur.data<=preValue){
                    //没有递增
                   ans = false;
                }else{
                    preValue = cur.data;
                }
                cur=cur.right;
            }

        }
        return ans;
    }


    public static void main(String[] args) {
        Node root = Generator.getBiTree();
        System.out.println("Pre ans:");
        preorder2(root);
        System.out.println();
        System.out.println("Pre morris:");
        preOrder(root);
        System.out.println();
        System.out.println("In ans:");
        inorder2(root);
        System.out.println();
        System.out.println("In Morris:");
        inorder(root);
        System.out.println();
        System.out.println("Post ans:");
        postOrder2(root);
        System.out.println();
        System.out.println("Post Morris:");
        postOrder(root);
        System.out.println();
        System.out.println("============BST================");
        Node root2=Generator.getBiTree();
        System.out.println(isBST(root2));
        System.out.println("==========");
        PrintBinaryTree.printTree(root2);
    }
}
