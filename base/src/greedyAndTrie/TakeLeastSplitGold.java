package greedyAndTrie;

import java.util.PriorityQueue;

public class TakeLeastSplitGold {

    public static int splitGold(int[] arr){
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        int result=0;
        for (int i:
             arr) {
            priorityQueue.add(i);
        }
        while(priorityQueue.size()>1){
            int o1=priorityQueue.poll();
            int o2=priorityQueue.poll();
            result+=(o1+o2);
            priorityQueue.add(o1+o2);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr={10,20,30};
        System.out.println(splitGold(arr));
    }
}
