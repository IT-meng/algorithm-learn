package greedyAndTrie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingArrangement {

    //start表示最早可以开始会议的时间，要求返回最多可以安排的会议数
    public static int bestArrangement(Meeting[] arr,int start){
    //按结束时间早的排序，依次安排
        PriorityQueue<Meeting> meetingPriorityQueue=new PriorityQueue<>(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.getEnd()-o2.getEnd();
            }
        });
        //将所有会议加入按结束时间组织的小根堆
        for (Meeting meeting:
             arr) {
            meetingPriorityQueue.add(meeting);
        }
        int timePoint=start;//当前来到的时间点用于判断能否安排某个会议
        int result=0;
        while(!meetingPriorityQueue.isEmpty())
        {
            Meeting m=meetingPriorityQueue.poll();
            if(m.getStart()>=timePoint){
                result++;
                timePoint=m.getEnd();
            }

        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Meeting> arrayList=new ArrayList<>();
        arrayList.add(new Meeting(5,6));
        arrayList.add(new Meeting(10,20));
        arrayList.add(new Meeting(13,19));
        arrayList.add(new Meeting(14,23));
        arrayList.add(new Meeting(7,8));
        arrayList.add(new Meeting(6,9));
        arrayList.add(new Meeting(8,11));
        arrayList.add(new Meeting(9,12));
        Meeting[] arr=arrayList.toArray(new Meeting[0]);
        System.out.println(bestArrangement(arr,5));

    }
}
class Meeting{
    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}