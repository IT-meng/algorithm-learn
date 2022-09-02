package graph;

import java.util.ArrayList;

public class Node {
    public int value;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public int in;//入度
    public int out;//出度
    public ArrayList<Node> nexts;//它所指向的结点
    public ArrayList<Edge> edges;//由它发出的边

    public Node(int value) {
        this.value = value;
        nexts=new ArrayList<Node>();
        edges=new ArrayList<Edge>();
    }
}
