import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Graph{
    private ArrayList<LinkedList<Integer>> graph;

    Graph(int maxNodes){
        graph = new ArrayList<LinkedList<Integer>>();
        for(int i=1;i<=maxNodes;i++)
            graph.add(new LinkedList<Integer>());
    }
    public void addEdge(int node1, int node2){
        graph.get(node1).add(node2);
        graph.get(node2).add(node1);
    }
}