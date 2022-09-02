package graph;

public class Edge {
    public int weight;//权值
    public Node from;//该条边的发出点
    public  Node to;//该条边的指向点

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
