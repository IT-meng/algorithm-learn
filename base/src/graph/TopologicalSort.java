package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
    /*
    * 1、找入度为0的点，将其入队
    * 2、对于入对的结点擦除其影响(与它直接相邻的点入度减一)
    * 3、重复1、和2、
    * */

    //没有环的图（总有入度为零的点）
public static ArrayList<Node> topologicalSort(Graph graph)
{

    //只有入度为零的点可以进这个队列
    Queue<Node> queue=new LinkedList<>();
    //key是某个结点，value值是它的入度
    /*之所以重新用一个Hashmap来存节点的入度，
    如果你在遍历的过程中直接在图里面改节点的入度就把人家的图结构破坏了*/
    HashMap<Node,Integer> inMap=new HashMap<>();
    //把节点信息和它的入度加到map里去
    for(Node node:graph.nodes.values())
    {
        inMap.put(node, node.in);
        if(node.in==0)
        {
            queue.add(node);

        }
    }
    ArrayList<Node> result=new ArrayList<>();
    while(!queue.isEmpty()){
        Node cur=queue.poll();
        result.add(cur);
        for(Node next:cur.nexts)
        {
            //一边修改一边看，入度为零我就加到队列里
            inMap.put(next, inMap.get(next)-1);
            if(inMap.get(next)==0)
            {
                queue.add(next);
            }
        }
    }

    return result;
}

    public static void main(String[] args) {

    int [][] matrix={
            {2,1,2},
            {1,1,5},
            {3,2,4},
            {4,5,4},
            {5,4,10},
            {6,10,9}

    };
    Graph graph=TransformGraph.transform(matrix);
    ArrayList<Node> res=topologicalSort(graph);
    for(Node node:res)
    {
        System.out.println(node.value+"  ");
    }

    }
}
