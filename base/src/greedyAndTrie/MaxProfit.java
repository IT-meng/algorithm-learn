package greedyAndTrie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxProfit {
    //costs[i] 表示第i个项目的花费,profits[i]表示第i个项目的利润，k表示我最多可以做多少个项目,money表示最初的资金
    //最多只能同时做一个项目,返回做完<=k个项目后最多money可以变为多少
    public static int maxProfit( Project[] projects,int money, int k){
        //锁住的项目
        PriorityQueue<Project> lockedProject=new PriorityQueue<>(new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return o1.cost-o2.cost;
            }
        });
        //将所有项目加入小根堆
        for (Project p:
             projects) {
            lockedProject.add(p);
        }
        //已经解锁的项目
        PriorityQueue<Project> canDoProject=new PriorityQueue<>(new Comparator<Project>() {
            @Override
            //比较器：返回负数时第一个参数排前面，返回正数时第二个参数排前面
            public int compare(Project o1, Project o2) {
                return o2.profit-o1.profit;
            }
        });

        int curMoney=money;
        //根据curMoney去解锁一些项目放入canDoProject里面，从canDoProject里选利润最大的做
        for (int i = 0; i < k; i++) {
            //根据现有资金解锁一些项目
            while( !lockedProject.isEmpty() && lockedProject.peek().cost<=curMoney){
                canDoProject.add(lockedProject.poll());
            }
            if(canDoProject.isEmpty())break;
            Project p= canDoProject.poll();
            //做一个项目curMoney减去cost加上profit
            curMoney-=p.cost;
            curMoney+=p.profit;
        }

        return curMoney;
    }

    public static void main(String[] args) {
        ArrayList<Project> arrayList=new ArrayList<>();
        arrayList.add(new Project(1,1));
        arrayList.add(new Project(1,4));
        arrayList.add(new Project(2,3));
        arrayList.add(new Project(2,7));
        arrayList.add(new Project(3,2));
        arrayList.add(new Project(4,10));
        System.out.println(maxProfit(arrayList.toArray(new Project[0]),1,4));
    }

}
class Project{
    int cost;
    int profit;

    public Project(int cost, int profit) {
        this.cost = cost;
        this.profit = profit;
    }
}