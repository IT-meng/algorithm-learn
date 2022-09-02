package greedyAndTrie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MinDictionaryOrder {
    //给一个字符串数组，以某种顺序把它拼接成一个字符串，使得结果字符串的字典序最小
    public static String minDicOrder(String[] strings){
        //将字符串排序：o1+o2的字典序小于o2+o1的字典序就把o1排在前面
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        //排完序之后依次拼接就行
        String result=new String();
        for (String str:strings
             ) {
            result+=str;
        }
        return result;
    }
    //直接按照字典序排序，是错误的
public static String result2(String[] strings){
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        String result=new String();
    for (String str:
         strings) {
        result+=str;
    }
    return result;
}
    public static void main(String[] args) {
        ArrayList<String> stringArrayList=new ArrayList<>();
        stringArrayList.add("hello");
        stringArrayList.add("world");
        stringArrayList.add("whut");
        stringArrayList.add("littlezhou");
        stringArrayList.add("success");
        stringArrayList.add("dijkestra");
        stringArrayList.add("b");
        stringArrayList.add("ba");
        System.out.println( minDicOrder(stringArrayList.toArray(new String[0])));
        System.out.println(result2(stringArrayList.toArray(new String[0])));
    }

}
