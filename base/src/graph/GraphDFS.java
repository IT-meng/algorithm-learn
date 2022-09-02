package graph;

import java.util.HashSet;
import java.util.Stack;

public class GraphDFS {

    /*
    打印操作是在第一次入栈之前打印
    * 把当前结点加入栈中，加入set中遍历当前结点的nexts如果找到nexts里的某个结点不在set里
    * 将当前节点重新加入栈中，将该节点加入栈中，将该节点加入set然后break*/
    public  static void graphDFS(Node node)
    {
        if(node==null)return;
        Stack<Node> stack=new Stack<>();
        HashSet<Node> set=new HashSet<>();
        System.out.println(node.value);
        stack.push(node);
        set.add(node);
        while(!stack.isEmpty())
        {
            Node cur=stack.pop();
            //遍历cur的nexts
            for(Node next: cur.nexts)
            {
                if(!set.contains(next))
                {
                    stack.push(cur);
                    System.out.println(next.value);
                    stack.push(next);
                    set.add(next);
                    break;
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
        graphDFS(graph.nodes.get(9));
    }
}
