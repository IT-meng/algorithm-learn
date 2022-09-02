package graph;

import java.util.*;

public class MSTkruskal {

    //将所有边放入优先级队列，每次取权值最小的边，看是否形成环，形成环则不要
    public static ArrayList<Edge> kruskal(Graph graph)
    {
        UnionFind unionFind=new UnionFind(graph.nodes.values());
        PriorityQueue<Edge> edgePriorityQueue=new PriorityQueue<>(new WeightComp());
        for (Edge edge:graph.edges
             ) {
            edgePriorityQueue.add(edge);
        }
        ArrayList<Edge> result=new ArrayList<>();
        while(!edgePriorityQueue.isEmpty())
        {
            Edge cur=edgePriorityQueue.poll();
            if(!unionFind.isInSame(cur.from, cur.to))
            {
                result.add(cur);
                unionFind.union(cur.from, cur.to);

            }


        }
    return  result;

    }
    public static void main(String[] args) {
        int [][] matrix={
                {3,2,1},
                {1,1,6},
                {2,3,6},
                {4,6,5},
                {5,1,5},
                {6,3,4},
                {7,4,5},
                {8,5,7},
                {9,8,7},
                {10,3,2},
                {11,4,6}

        };
        Graph graph=TransformGraph.transform(matrix);
       ArrayList<Edge> res= kruskal(graph);
        for (Edge e:res
             ) {
          System.out.println(e.weight);
        }
    }
}
class WeightComp implements Comparator<Edge> {

    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.weight- o2.weight;
    }
}
//简易UnionFind
class UnionFind{
    public HashMap<Node, HashSet<Node>> getMap() {
        return map;
    }

    private HashMap<Node,HashSet<Node>> map;

    UnionFind(Collection<Node> c)
    {
        map=new HashMap<>();
        for(Node cur:c)
        {
           HashSet<Node> Nodeset =new HashSet<>();
           Nodeset.add(cur);
            map.put(cur,Nodeset);
        }

    }
    public  boolean isInSame(Node o1,Node o2)
    {
        if(map.get(o1)==map.get(o2))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public  void union(Node o1,Node o2)
    {
     HashSet<Node> O1set=map.get(o1);
     HashSet<Node> O2set=map.get(o2);
       /*O1set.addAll(O2set);
        map.put(o2,O1set);
        不能这样写因为：不能保证每次保留的集合都是之前保留的
        */
        for(Node node:O2set)
        {
            O1set.add(node);
            map.put(node,O1set);
        }
    }


}