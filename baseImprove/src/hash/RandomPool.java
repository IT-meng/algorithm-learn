package hash;

import java.util.HashMap;

public class RandomPool<K> {
    //插入一个关键字
    public void insert(K key){
        keyIndexMap.put(key,size);
        indexKeyMap.put(size++,key);
    }
    //删除一个关键字
    public void delete(K key){
        //删除关键字后，把最后一个index的key放在删除的位置
        Integer index = keyIndexMap.get(key);
        keyIndexMap.put(indexKeyMap.get(size-1),index);
        keyIndexMap.remove(key);
        indexKeyMap.put(index,indexKeyMap.get(--size));
        indexKeyMap.remove(size);
    }
    //在所有已加入的关键字里等概率随机返回一个
    public K getRandom(){
        int index=(int)(Math.random()*size);//0~size-1
        return indexKeyMap.get(index);
    }
    private HashMap<K,Integer> keyIndexMap;
    private HashMap<Integer,K> indexKeyMap;
    private int size;
    RandomPool(){
        keyIndexMap=new HashMap<>();
        indexKeyMap=new HashMap<>();
        size=0;
    }

    public static void main(String[] args) {
        RandomPool<Integer> pool = new RandomPool<>();
        for (int i = 0; i < 100; i++) {
            pool.insert(i);
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(pool.getRandom());
        }
    }
}
