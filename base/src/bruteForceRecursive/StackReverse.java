package bruteForceRecursive;

import java.util.Stack;
//不能使用额外数据结构，只能利用函数递归实现将一个栈逆序
public class StackReverse {

    public static int getBottom(Stack<Integer> stack){//返回栈底元素并将栈底元素从栈中删除
        int result=stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last=getBottom(stack);
            stack.push(result);
            return last;
        }

    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty())return;
        int i=getBottom(stack);//把栈最底层的元素拿掉
        reverse(stack);//将剩下的栈逆序
        stack.push(i);//将最底层元素压入栈中
    }


    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverse(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
