package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
    //任意给一个结点从它开始进行广度优先遍历
    public static void graphBFS(Node node)
    {
        Queue<Node> queue= new LinkedList<>();
        //用set保证不重复遍历
        HashSet<Node> set=new HashSet<>();
        queue.add(node);
        set.add(node);
        while(!queue.isEmpty())
        {
            Node cur=queue.poll();
            System.out.println(cur.value);
            for (Node next: cur.nexts
                 ) {
                if(!set.contains(next))
                {
                    queue.add(next);
                    set.add(next);
                }
            }

        }
    }

    public static void main(String[] args) {
        int [][] matrix={
                {2,2,1},
                {1,1,4},
                {3,4,9},
                {4,10,2},
                {5,10,9},
                {6,2,5},
                {7,9,5},
                {8,5,10},
                {9,4,5}

        };
        Graph graph=TransformGraph.transform(matrix);
        graphBFS(graph.nodes.get(1));
    }
}
