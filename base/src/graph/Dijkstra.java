package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Dijkstra {

    public static HashMap<Node,Integer> dijkstra(Graph graph,Node start)
    {
        //result是指从start到key的最短路径长为value
        HashMap<Node,Integer> result=new HashMap<>();
        //被锁死的记录
        HashSet<Node> Locked=new HashSet<>();
        //初始化result
        for (Node node:graph.nodes.values()
             ) {
            if(node==start)
            {
                result.put(node,0);
            }else
            {
                result.put(node,Integer.MAX_VALUE);
            }
        }
        //找出result中value值最小的node
      Node minNode=findMinVlueNode(Locked,result);
        while(minNode!=null)
        {
            //遍历minNode的所有边，更新边的toNode的value值
            for(Edge e:minNode.edges){
                int dist=result.get(minNode)+e.weight;
                if( dist<result.get(e.to)){
                    result.put(e.to,dist);
                }
            }
            Locked.add(minNode);
            minNode=findMinVlueNode(Locked,result);
        }


        return result;

    }

    public static Node findMinVlueNode(HashSet<Node> locked ,HashMap<Node,Integer> result){
        int min=Integer.MAX_VALUE;
        Node minNode=null;
        for (Map.Entry<Node,Integer> entry: result.entrySet())
        {
            if(!locked.contains(entry.getKey())&&entry.getValue()<min){
                min=entry.getValue();
                minNode=entry.getKey();
            }

        }
        return minNode;
    }

    //用堆优化
    public static HashMap<Node,Integer> dijkstra2(Graph graph,Node start){
        HashMap<Node,Integer>result=new HashMap<>();
        NodeHeap nodeHeap = new NodeHeap(graph.nodes.size());
        nodeHeap.addOrUpdateOrIgnore(start,0);
        //从堆中弹出distance最小的结点，加入result中
        while(!nodeHeap.isEmpty()){
            NodeRecord record = nodeHeap.pop();
            Node cur=record.node;
            int dis=record.distance;
            result.put(cur,dis);
            //将该结点解锁的结点加入堆中
            for(Edge edge: cur.edges){
                nodeHeap.addOrUpdateOrIgnore(edge.to,dis+ edge.weight);
            }
        }
        return result;
    }
   static class NodeHeap{
       private Node[] nodes;//作为堆的数组
        //key:某个node， value:该node在堆中的位置(数组下标)
        private HashMap<Node,Integer> nodeIndexMap;
        //源结点到key的目前的最短距离
        private HashMap<Node,Integer> distanceMap;
        private int size;//堆上有几个结点
        //构造
        public NodeHeap(int size){
            nodes=new Node[size];
            nodeIndexMap=new HashMap<>();
            distanceMap=new HashMap<>();
            this.size=0;
        }
        public void addOrUpdateOrIgnore(Node node,int distance){
            //在堆上
            if(inHeap(node)){
                distanceMap.put(node,Math.min(distanceMap.get(node),distance));
                insertHeapify(nodeIndexMap.get(node));
            }//没有进来过
            if (!isEntered(node)){
                //新建记录
                nodes[size++]=node;
                nodeIndexMap.put(node,size-1);
                distanceMap.put(node,distance);
                insertHeapify(size-1);
            }
        }
        //是否进来过
        public boolean isEntered(Node node){
            return nodeIndexMap.containsKey(node);
        }
        //是否在堆上
        public boolean inHeap(Node node){
            return isEntered(node)&&nodeIndexMap.get(node)!=-1;
        }
        //弹出小根堆堆顶
        public NodeRecord pop(){
            if(!this.isEmpty()){
                Node node=nodes[0];
                int dis=distanceMap.get(nodes[0]);
                swap(0,size-1);
                nodeIndexMap.put(node,-1);
                nodes[--size]=null;
                //向下调整
                heapIfy();
                return new NodeRecord(node,dis);
            }
            return null;
        }
        public void swap(int index1,int index2){
            if(index1==index2){
                return;
            }
            //数组中要交换
            Node tem=nodes[index1];
            nodes[index1]=nodes[index2];
            nodes[index2]=tem;
            //nodeIndexMap中也要换
            //注意：上面已经交换过了数组中的位置
            nodeIndexMap.put(nodes[index1],index1);
            nodeIndexMap.put(nodes[index2],index2);

        }
        //判断堆是否为空
       public boolean isEmpty(){
            return size==0;
       }

       //只需要向上调整
       public void insertHeapify(int index){
            while(distanceMap.get(nodes[index])<distanceMap.get(nodes[(index-1)/2])){
                swap(index,(index-1)/2);
                index=(index-1)/2;
            }

       }
       //向下调整
            public void heapIfy(){
                int index=0;
                if(nodes[0]==null)return;
                while(  (2*index+2<size)
                        &&
                distanceMap.get(nodes[index])>
                                Math.min(distanceMap.get(nodes[2*index+1]),
                                distanceMap.get(nodes[2*index+2]))){
                    int minIndex=distanceMap.get(nodes[2*index+1]) ==
                            Math.min(distanceMap.get(nodes[2*index+1]),
                                    distanceMap.get(nodes[2*index+2]))?
                            2*index+1:2*index+2;
             swap(index,minIndex);
             index=minIndex;
                }
            }
    }
    static class NodeRecord{
        Node node;
        int distance;

        public NodeRecord(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }


    public static void main(String[] args) {
        int [][] matix={
                {9,1,4},
                {9,4,1},
                {7,4,3},
                {7,3,4},
                {16,4,5},
                {16,5,4},
                {15,1,3},
                {15,3,1},
                {14,3,5},
                {14,5,3},
                {3,1,2},
                {3,2,1},
                {2,2,3},
                {2,3,2},
                {200,2,5},
                {200,5,2}

        };
        Graph graph=TransformGraph.transform(matix);
        Node start=graph.nodes.get(1);
        HashMap<Node,Integer> res=dijkstra(graph,start);
        for(Map.Entry<Node,Integer> entry:res.entrySet()){
            System.out.println(entry);
        }
        System.out.println("========================");
        HashMap<Node, Integer> res2 = dijkstra2(graph, start);
        for (Map.Entry<Node,Integer> entry:res2.entrySet()){
            System.out.println(entry);
        }
    }


}
