package greedyAndTrie;

import java.util.Comparator;
import java.util.PriorityQueue;

//一个数据流中随时可以取得中位数
public class GetMidNumber {
    //内部维持一个大根堆和一个小根堆
   private PriorityQueue<Double> smallpriorityQueu;
    private PriorityQueue<Double> bigPriorityQueue;


    //构造函数
    public GetMidNumber() {
        smallpriorityQueu=new PriorityQueue<>();
        //系统默认小根堆，大根堆传比较器
        bigPriorityQueue=new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return (int) (o2-o1);
            }
        });
    }

    public void add(double num){
        //上来第一个数据直接放入大根堆
        //以后的数据，如果大于大根堆的堆顶就放入小根堆，否则放入大根堆
        if(bigPriorityQueue.isEmpty()){
            bigPriorityQueue.add(num);
        }else if(num>bigPriorityQueue.peek()){
            smallpriorityQueu.add(num);
        }else{
            bigPriorityQueue.add(num);
        }
        //一旦大根堆和小根堆的size相差为二就从size大的堆弹出堆顶放入size小的堆
        if(bigPriorityQueue.size() -smallpriorityQueu.size()==2){
            smallpriorityQueu.add(bigPriorityQueue.poll());
        }
        if(smallpriorityQueu.size()-bigPriorityQueue.size()==2){
            bigPriorityQueue.add(smallpriorityQueu.poll());
        }
    }

    public double getMidNum(){
        //看现在总共有奇数个数还是偶数个数
        if((smallpriorityQueu.size()+bigPriorityQueue.size())%2==0){//偶数个
            return (smallpriorityQueu.peek()+bigPriorityQueue.peek())/2;
        }else {
            //奇数个返回size大的那个的堆顶
            return smallpriorityQueu.size()>bigPriorityQueue.size()?smallpriorityQueu.peek():bigPriorityQueue.peek();
        }
    }

    public static void main(String[] args) {
        GetMidNumber getter=new GetMidNumber();
        getter.add(4);
        getter.add(7);
        getter.add(3);
        getter.add(2);
        getter.add(1);
        getter.add(5);
        System.out.println(getter.getMidNum());
    }
}
