package bruteForceRecursive;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubSequences {

    //打印arr数组所有的子序列(子集)
    public  static void print1(char[] arr,int i, List<Character> result){
            //参数i表示当前来到i位置,result是之前的选择所形成的结果集
        if(i==arr.length){//当前来到结束字符的下一个位置，直接打印
            printList(result);
        }else{
            print1(arr,i+1,result);//不要当前位置的字符
//            result.add(arr[i]); 不能直接add因为list是地址传递只有一份
            List<Character> copylist = copylist(result);
            copylist.add(arr[i]);
            print1(arr,i+1,copylist);//要当前位置字符
        }


    }
    //省空间(复用str)
    public static void print2(char[] str,int i){
        if(i==str.length){
            printArray(str);
        }else{
            //不要当前位置字符
            char tem=str[i];
            str[i]=0;
            print2(str,i+1);
            //要当前位置字符
            str[i]=tem;
            print2(str,i+1);
        }
    }

    private static void printArray(char[] str) {
        for (char ch:
             str) {
            System.out.print(ch);
        }
        System.out.println();
    }

    public static List<Character> copylist(List<Character> list){
        ArrayList<Character> res = new ArrayList<>();
        res.addAll(list);
        return res;
    }

    public static void printList(List<Character> list){
        if(list.size()==0){
            System.out.println("null");
            return;
        }
        for (Character ch:
             list) {
            System.out.print(ch);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[] arr= {'a','b','c'};
        print1(arr,0,new ArrayList<>());
        System.out.println("===================");
        print2(arr,0);

    }
}
