package binaryTree;

import java.util.List;

//一个员工去了，他的所有直接下级就都不能去，问怎样发请柬可以使整体的快乐值最大
public class MaxHappy {


    public static ReturnType process(Employee header){
        if(header==null){
            return new ReturnType(0,0);
        }

        int yes=header.happy;
        int no=0;

        for (Employee e: header.subordinates){
           ReturnType r= process(e);
            //1、根节点参与：
            yes+=r.no;//根节点参与的maxhappy等于它自己的happy加上它的直接下级不参与的maxhappy
            //2、根节点不参与；
            no+=Math.max(r.no,r.yes);
        }
        return new ReturnType(yes,no);
    }

    public static int getMaxHappy(Employee header){
        ReturnType rt = process(header);
        return Math.max(rt.yes,rt.no);
    }
}
class Employee{
    public int happy;
    public List<Employee> subordinates; //直接下级
}
class ReturnType{
    public int yes;//当前节点来所能带来的快乐值
    public int no;//当前节点不来所能带来的 快乐值

    public ReturnType(int yes, int no) {
        this.yes = yes;
        this.no = no;
    }

    public int getYes() {
        return yes;
    }

    public void setYes(int yes) {
        this.yes = yes;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
