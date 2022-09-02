package singleStackAndWindowMax;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class WindowMax {
   private int[] arr;
   private int l;
   private int r;
   //用户给我一个 数组，我对外提供l往右和r往右的操作，随时可以为用户返回窗口内最大值
   private Deque<Integer> q;//里边存数组下标

    public WindowMax(int[] arr) {
        this.arr = arr;
        l=-1;
        r=-1;
        //初始化l和r在数组的左边
        q=new LinkedList<>();
    }
    public void rRight(){//r右移
        r++;
        //根据双端队列的情况看窗口中新增加的元素是否可以从尾部进入双端队列
        //要求双端队列从头部到尾部单调递减
        //peek方法只返回不删除

        //如果尾部有比当前r位置的值小的元素，将其弹出，直到当前r位置的元素可以进入
        while(!q.isEmpty()&&arr[q.peekLast()]<arr[r]){
            q.pollLast();//删除双端队中的尾部元素
        }
        //将当前r位置的元素加入尾部
        q.addLast(r);//q里装的是下标
    }
    public void lRight(){//l右移
    //l右移可能会导致双端队列中的下标过期
        //检查当前队头元素是否过期，过期则删除
        l++;
        while(!q.isEmpty()&&q.getFirst()<l){
            //删除过期的下标
            q.pollFirst();
        }

    }


    public int getMax(){//为用户返回当前窗口中的最大值
        //返回双端队列头部元素即可
        if((l==-1&&r==-1)||(q.isEmpty())){
            return -1;
        }else{
            return arr[q.getFirst()];
        }
    }

    public static void main(String[] args) {
        WindowMax windowMax = new WindowMax(new int[]{1,5,6,8,4,9,3});
        System.out.println("1 5 6 8 4 9 3");
       char in;
       while((in=new Scanner(System.in).next().charAt(0))=='l'||in=='r'){
           if(in=='l'){
               windowMax.lRight();
           }else{
               windowMax.rRight();
           }
           System.out.println("当前窗口最大值:"+windowMax.getMax());
       }

    }
}
