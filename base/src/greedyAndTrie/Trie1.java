package greedyAndTrie;

import java.util.Enumeration;
import java.util.HashMap;

public class Trie1 {

    private TrieNode1 root;
   public Trie1(){
        root=new TrieNode1();
    }

    public void insert(String str){
       if(str==null) return;
       char[] arr=str.toCharArray();
       TrieNode1 cur=root;
       cur.pass++;
       int index=0;
        for (int i = 0; i < arr.length ; i++) {
            index=arr[i]-'a';//拿到当前字符的index
            if(cur.nexts[index]==null){//没有到当前字符的路径,就新建
                TrieNode1 node=new TrieNode1();
                cur.nexts[index]=node;
            }
            //找到就复用
            cur=cur.nexts[index];
            cur.pass++;
        }
        //最后一个结点的end值加加
        cur.end++;
    }
    //查找某个字符串加入了几次
    public int search(String str){
       if(str==null) return 0;
       char[] arr=str.toCharArray();
       //怎么加的就怎么找
        TrieNode1 cur=root;
        int index=0;
        for (int i = 0; i < arr.length ; i++) {
            index=arr[i]-'a';
            //字符数组没遍历完相应的index位置就为空，说明没加入过这个字符return 0
            if(cur.nexts[index]==null)
            {
                return 0;
            }
            cur=cur.nexts[index];
        }
        return cur.end;
    }
    // 所有加入的字符串中，有几个是以pre这个字符串作为前缀的
    public int prefixNumber(String pre){
       char[] arr=pre.toCharArray();
       int index=0;
       TrieNode1 cur=root;
        for (int i = 0; i < arr.length ; i++) {
            index=arr[i]-'a';
            if(cur.nexts[index]==null){
                return 0;
            }
            cur=cur.nexts[index];
        }
        return cur.pass;
    }
    //从前缀树中删除某个字符串
    public void delete(String word){

       //得先看看它存不存在再去进行删除操作
        //所谓删除就是，一路上通过的结点的pass值减减，最后一个结点的end值减减
        if(search(word)!=0)
        {
            char[] arr=word.toCharArray();
            TrieNode1 cur=root;
            cur.pass--;
            int index=0;
            for (int i = 0; i < arr.length; i++) {
                index=arr[i]-'a';
                cur=cur.nexts[index];
                cur.pass--;
            }
            cur.end--;
        }
    }

    public static void main(String[] args) {
        Trie1 trie1=new Trie1();
        String[] words={ "abca","abcb","abd","abca", "ab","ace","ac"};
        for (String str:words
             ) {
            trie1.insert(str);
        }
//    trie1.delete("ab");
//        System.out.println(trie1.search("ab"));
//        System.out.println(trie1.prefixNumber("ab"));


//        for (String str:
//             words) {
//            System.out.println(str+"出现" +trie1.search(str)+"次");
//        }
    }
}
class TrieNode1{
    int pass;
    int end;
    TrieNode1[] nexts;
  public  TrieNode1(){
        pass=0;
        end=0;
        nexts=new TrieNode1[26];
    }
}
class TrieNode2{
    int pass;
    int end;
    HashMap<Integer,TrieNode2> nexts;//key值就类似于数组下标，用当前字符减去你认为编码为零的字符得到
    public TrieNode2(){
        pass=0;
        end=0;
        nexts=new HashMap<>();
    }
}