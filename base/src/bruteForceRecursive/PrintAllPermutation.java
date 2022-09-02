package bruteForceRecursive;

import java.util.ArrayList;

//打印所有排列
public class PrintAllPermutation {
      //0~(i-1)位置已确定
    public static void process(char[] str, int i, ArrayList<String> res){
        if(i==str.length){
            res.add(String.valueOf(str));
        }else{
            for (int j = i; j < str.length; j++) {
                swap(str, i, j);//把j放i位置
                process(str,i+1,res);
                swap(str,i,j);//交换回来,在同一层要保证str是一样的
            }
        }

    }
    public static void swap(char[] str,int i,int j){
        if(i==j)return;
        char tem=str[i];
        str[i]=str[j];
        str[j]=tem;
    }

    public static void main(String[] args) {
        char[] str={'a','b','a'};
        ArrayList<String> res = new ArrayList<>();
        process(str,0,res);
        for (String s:
             res) {
            System.out.println(s);
        }
        System.out.println("===============");
        ArrayList<String> res2 = new ArrayList<>();
        process2(str,0,res2);
        for (String s:
                res2) {
            System.out.println(s);
        }

        System.out.println("res: "+res.size());
        System.out.println("res2: "+res2.size());

    }
    //说是去重复，但我不理解!!!!!!
    //懂了，str中有重复字符的话，不去重就会出现重复的结果
    public static void process2(char[] str, int i, ArrayList<String> res){
        if(i==str.length){
            res.add(String.valueOf(str));
        }else{
            boolean[] visited=new boolean[26];
            for (int j = i; j < str.length; j++) {
                if(!visited[str[j]-'a']){
                    visited[str[j]-'a']=true;
                    swap(str, i, j);//把j放i位置
                    process(str,i+1,res);
                    swap(str,i,j);//交换回来,在同一层要保证str是一样的
                }
            }
        }

    }
}
