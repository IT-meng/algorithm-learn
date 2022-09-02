package linkList;
//判断给定的单链表是否回文(以结点为最小单位 )
public class PalindromeLinkList {
    public static boolean isPalindromeLinkList(Node head){
        if(head==null||head.next==null)return true;
        Node mid=getMid(head);
        //不用管是奇数个还是偶数个结点
        Node p1=head,p2=reverseMid(mid);
        Node memory=p2;
        while(p2!=mid){
            if(p1.data !=p2.data){
                return false;
            }
            p1=p1.next;
            p2=p2.next;
        }
        reverseMid(memory,mid);
        return true;
    }
    public static void reverseMid(Node h,Node mid){
        if(h.next==mid){
            h.next=null;
        }
       else if(h.next!=mid){
           Node p=h.next;
           Node q=h.next.next;
           Node tail=h;
           //将mid以后的结点反过来挂
           while(q!=mid){
               p.next=tail;
               tail=p;
               p=q;
               q=q.next;
           }
           p.next=tail;

       }

    }
    public static Node reverseMid(Node mid){
         if(mid.next==null)return mid;
            Node p=mid.next;
            Node q=mid.next.next;
            Node tail=mid;
            //将mid以后的结点反过来挂
            while(q!=null){
                p.next=tail;
                tail=p;
                p=q;
                q=q.next;
            }
            p.next=tail;
            return p;

    }
    //如果链表的个数为偶数此函数返回中间两个结点中的前面那个
    public static Node getMid(Node head){

        Node quick,slow;
        quick=slow=head;
        quick=quick.next;
        //快指针一次走两步，慢指针一次走一步快指针走完时，慢指针走到终点
        while (quick!=null&&quick.next!=null){
            quick=quick.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public static int getNumber(Node head){
        Node p=head;
        int count=0;
        while(p!=null){
            p=p.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Node[] arr=new Node[6];
      for(int i=0;i<arr.length;i++){
          arr[i]=new Node();
      }
        arr[0].data=1;
        arr[1].data=3;
        arr[2].data=10;
        arr[3].data=10;
        arr[4].data=3;
        arr[5].data=1;
    for(int i=0;i<arr.length-1;i++){
        arr[i].next=arr[i+1];
    }
        Node head=arr[0];
        Node p=head;
        while(p!=null){
            System.out.print(p.data+"\t");
            p=p.next;
        }
        System.out.println();
        System.out.println("==============================");
        System.out.println(isPalindromeLinkList(head));
    }
}
class Node{
    int data;
    Node next;
    Node(){
        this.data=0;
        this.next=null;
    }
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }

}