package singleStackAndWindowMax;

import java.util.Stack;

//单调栈
//给你一数组，返回每个元素的左边和右边离它最近的比他大的元素的下标组成的数组
public class MonotonicStack {

    private Stack<Integer> stack;//stack里装的是下标

    public MonotonicStack() {
        this.stack = new Stack<>();
    }

    //Node[]数组中node[i].arr[0]表示i位置的元素左边离它最近比它大的元素下标，node[i].arr[1]
    //表示i位置的元素右边离它最近比它大的元素的下标,没有则是-1
    public  Node[] closeMax(int[] arr){
        Node[] nodes=new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i]=new Node();
            //要求维持栈中元素从栈底到栈顶，由大到小

            //栈顶比当前元素小时弹出栈顶元素
            while(!stack.isEmpty()&&arr[stack.peek()]<arr[i]){
              int cur = stack.pop();
                //每弹出一个生成Node信息

                //当前弹出的下标为cur
                nodes[cur].arr[1]=i;
                if(!stack.isEmpty())//栈不为空
                nodes[cur].arr[0]=stack.peek();//cur左边离它最近比它大的是当前栈顶
                else//栈为空
                    nodes[cur].arr[0]=-1;

            }
            //当前位置入栈
            stack.push(i);
        }//end for

        //扫完一遍了stack还不为空时,依次弹出生成信息并做返回
        while(!stack.isEmpty()){
            int cur=stack.pop();
            nodes[cur].arr[1]=-1;
            if(!stack.isEmpty())
            nodes[cur].arr[0]=stack.peek();
            else
                nodes[cur].arr[0]=-1;
        }

        return nodes;
    }


    public static void main(String[] args) {
        MonotonicStack singlStack = new MonotonicStack();
        int[] arr=new int[]{4, 5, 2, 3, 7, 9, 6, 0};
        Node[] nodes = singlStack.closeMax(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+" 左边离它最近比它大的数为："+(nodes[i].arr[0]==-1?"没有 ":arr[nodes[i].arr[0]]+" ")+
                    "它右边离它最近比它大的数为："+(nodes[i].arr[1]==-1?"没有 ":arr[nodes[i].arr[1]]));
        }
    }

}
class  Node{
   public int[] arr;

    public Node() {
        this.arr = new int[2];
    }
}