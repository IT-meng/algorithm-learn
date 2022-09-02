package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

//并查集
public class UnionFindSet<V> {
    HashMap<V,V> elementMap;//初始化每个元素对应它自己
    HashMap<V,V> fatherMap;//key的父节点是value
    HashMap<V,Integer> sizeMap;//key是集合的代表元素，value是该集合的size
    //构造
    public UnionFindSet(List<V> list){
        elementMap=new HashMap<>();
        fatherMap=new HashMap<>();
        sizeMap=new HashMap<>();
        for (V value:list){
            elementMap.put(value,value);
            fatherMap.put(value,value);
            sizeMap.put(value,1);
        }
    }
    //返回v1和v2是否在相同的集合
    public boolean isSameSet(V v1,V v2){
        if(elementMap.containsKey(v1) && elementMap.containsKey(v2)){
            V head1 = getHead(v1);
            V head2 = getHead(v2);
            return head1==head2;
        }
        return false;
    }

    public void union(V v1,V v2){
        if(!isSameSet(v1,v2)){
            V head1 = getHead(v1);
            V head2 = getHead(v2);
            V big= sizeMap.get(head1)>= sizeMap.get(head2)? head1 : head2;
            V small=big==head1 ? head2 :head1;
            fatherMap.put(small,big);
            sizeMap.put(big,sizeMap.get(big)+ sizeMap.get(small));
            sizeMap.remove(small);
        }
    }

    private V getHead(V value){
        Stack<V> stack=new Stack<>();
        while(value!=fatherMap.get(value)){
            stack.push(value);
            value=fatherMap.get(value);
        }
        //小优化
        while(!stack.isEmpty()){
            fatherMap.put(stack.pop(),value);
        }

        return value;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        UnionFindSet<Integer> unionFindSet = new UnionFindSet<>(list);
        unionFindSet.union(1,2);
        unionFindSet.union(3,4);
        unionFindSet.union(1,4);
        System.out.println(unionFindSet.isSameSet(3,2));
    }
}
