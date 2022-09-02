package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MSTprime {

    public static ArrayList<Edge> prime(Graph graph)
    {
        ArrayList<Edge> result=new ArrayList<>();
        PriorityQueue<Edge> edgePriorityQueue=new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });
        HashSet<Node> hashSet=new HashSet<>();
        Node node=graph.nodes.get(1);
        hashSet.add(node);
        for(Edge next: node.edges)
        {
            edgePriorityQueue.add(next);
        }
    //从某个结点出发把属于它的边加入到优先级队列，每次弹出一条权值最小的边
        //看这条边to的点在不在set集合里不在这条边就要并把to结点加到set集合里
        //属于to结点的边又全部被解锁
    while(!edgePriorityQueue.isEmpty())
    {
        Edge edg=edgePriorityQueue.poll();
        if(!hashSet.contains(edg.to))
        {
            result.add(edg);
            hashSet.add(edg.to);
            for(Edge e:edg.to.edges)
            {
                edgePriorityQueue.add(e);
            }
        }

    }
        return result;
    }

    public static void main(String[] args) {
        int [][] matrix={
                {3,2,1},
                {3,1,2},
                {1,1,6},
                {1,6,1},
                {2,3,6},
                {2,6,3},
                {4,6,5},
                {4,5,6},
                {5,1,5},
                {5,5,1},
                {6,3,4},
                {6,4,3},
                {7,4,5},
                {7,5,4},
                {8,5,7},
                {8,7,5},
                {9,8,7},
                {9,7,8},
                {10,2,3},
                {10,3,2},
                {11,4,6},
                {11,6,4}

        };
        Graph graph=TransformGraph.transform(matrix);
        ArrayList<Edge> res= prime(graph);
        for (Edge e:res
        ) {
            System.out.println(e.weight);
        }

    }
}
