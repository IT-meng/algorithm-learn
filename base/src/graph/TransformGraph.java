package graph;

public class TransformGraph {
    //matrix为N*3的矩阵
    //[5,4,2] 第一个值为边的weight,第二个值为from的点，第三个值为to的点
    public static Graph transform(int[][] matrix)
    {
        
        Graph graph=new Graph();

        for (int [] arr:matrix)
        {
            int weight=arr[0];
            int from=arr[1];
            int to=arr[2];
            //必须先有点才能新建边
            if(!graph.nodes.containsKey(from))
            {
                graph.nodes.put(from,new Node(from));
            }
            if(!graph.nodes.containsKey(to))
            {
                graph.nodes.put(to,new Node(to));
            }


        Node fromNode=graph.nodes.get(from);
            Node toNode=graph.nodes.get(to);
            fromNode.nexts.add(toNode);
            Edge edg=new Edge(weight,fromNode,toNode);
            fromNode.edges.add(edg);
            fromNode.out++;
            toNode.in++;
            graph.edges.add(edg);

        }


    return  graph;

    }
    public static Graph transform2(int[][] matrix)
    {

        Graph graph=new Graph();

        for (int [] arr:matrix)
        {
            int weight=arr[0];
            int from=arr[1];
            int to=arr[2];
            //必须先有点才能新建边
            if(!graph.nodes.containsKey(from))
            {
                graph.nodes.put(from,new Node(from));
            }
            if(!graph.nodes.containsKey(to))
            {
                graph.nodes.put(to,new Node(to));
            }


            Node fromNode=graph.nodes.get(from);
            Node toNode=graph.nodes.get(to);
            fromNode.nexts.add(toNode);
            toNode.nexts.add(fromNode);
            Edge edg=new Edge(weight,fromNode,toNode);
            fromNode.edges.add(edg);
            toNode.edges.add(edg);
            fromNode.out++;
            toNode.out++;
            toNode.in++;
            toNode.out++;
            graph.edges.add(edg);

        }


        return  graph;

    }
}
