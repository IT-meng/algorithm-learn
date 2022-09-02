package linkList;
//判断两个单链表是否有重合的部分，有：返回重合的第一个节点，没有：返回null
public class CoincideLinkList {
//判断以head为头的链表是否有环，有返回第一个入环结点，没有返回空
    public  static Node isLoopList(Node head){
        if(head==null||head.next==null||head.next.next==null){
            return null;
        }
        Node quick=head.next.next,slow=head.next;
        while(quick!=null&&quick.next!=null&&quick!=slow){//如果链表没环快指针会走到最后一个结点，如果有环，快指针最终会和慢指针指向同一个结点
            //快指针一次走两步，慢指针一次走一步
            quick=quick.next.next;
            slow=slow.next;
        }
        if(quick==null||quick.next==null){//没环直接返回
            return null;
        }
        //让快指针指向开头，慢指针指向不变，重新开始快指针一次一步慢指针一次一步，它俩相遇的结点就是入环结点
        quick=head;
        while(quick!=slow){
            quick=quick.next;
            slow=slow.next;
        }
        return slow;
    }
    public static Node coincide(Node head1,Node head2){
        Node loop1=isLoopList(head1);
        Node loop2=isLoopList(head2);
        if(loop1==null&&loop2==null){
          return  bothNull(head1,head2);
        }//一个有环一个没有环不可能有公共部分
        else if((loop1==null&&loop2!=null)||loop2==null&&loop1!=null){
            return null;
        }else
        {
            //看两个链表的入环节点是否相同(依此判断是在入环之前重合还是入环之后重合)
            //入环之前重合,把loop结点当end结点执行bothnull的操作
            if(loop1==loop2){
               return bothNull(head1,head2,loop1);
            }else//入环节点不同
            {//让loop1继续往下走，看走到自己之前能否遇到loop2
                //如果遇到了返回loop1或者loop2中的一个，如果没遇到返回null
                Node tem=loop1.next;
                while(tem!=loop1){
                    if(tem==loop2){
                        return loop1;
                    }
                    tem=tem.next;
                }
                return null;
            }
        }
    }

    public static Node bothNull(Node head1,Node head2){
        int count=0;
       Node cur1=head1;
       Node cur2=head2;
        //遍历两个链表，记录表长
        while(cur1.next!=null){
            count++;
            cur1=cur1.next;
        }
        while(cur2.next!=null){
            count--;
            cur2=cur2.next;
        }
        //让cur1指向长的链表，cur2指向短的链表
        cur1=count>0?head1:head2;
        cur2=cur1==head1?head2:head1;
        if(count<0)count=-count;
        //让长的链表走完两链表的差值
        while(count>0){
            cur1=cur1.next;
            count--;
        }
        //让两个指针同时开始走，两指针相遇停止，极为两链表重合的第一个结点
        while(cur1!=cur2&&cur1!=null&&cur2!=null){
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;

    }
    public static Node bothNull(Node head1,Node head2,Node loop ){
        int count=0;
        Node cur1=head1;
        Node cur2=head2;
        //遍历两个链表，记录表长
        while(cur1.next!=loop){
            count++;
            cur1=cur1.next;
        }
        while(cur2.next!=loop){
            count--;
            cur2=cur2.next;
        }
        //让cur1指向长的链表，cur2指向短的链表
        cur1=count>0?head1:head2;
        cur2=cur1==head1?head2:head1;
        if(count<0)count=-count;
        //让长的链表走完两链表的差值
        while(count>0){
            cur1=cur1.next;
            count--;
        }
        //让两个指针同时开始走，两指针相遇停止，极为两链表重合的第一个结点
        while(cur1!=cur2&&cur1!=loop&&cur2!=loop){
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;

    }

    public static void main(String[] args) {
        Node head1=new Node(0,null);
        Node node1=new Node(1,null);
        Node node2=new Node(2,null);
        Node node3=new Node(3,null);
        Node node4=new Node(4,null);
        head1.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=null;
        Node head2=new Node(22,null);
        Node newnode1=new Node(33,null);
        Node newnode2=new Node(44,null);
        head2.next=newnode1;
        newnode1.next=newnode2;
        newnode2.next=node4;
        System.out.println(coincide(head1,head2)==null?"null":coincide(head1,head2).data);

    }
}
