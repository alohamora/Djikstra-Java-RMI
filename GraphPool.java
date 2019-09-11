import java.rmi.*; 
import java.rmi.server.*;
import java.util.*;
 
public class GraphPool extends UnicastRemoteObject implements GraphPoolInterface{
    private static final long serialVersionUID = 1L;
    static int maxNodes = 10000;
    static Map<String,Graph> graphMap;

    GraphPool() throws RemoteException{
        super();
        graphMap = new HashMap<String, Graph>();
    }

    @Override
    public String initGraph(String graphName) throws RemoteException{
        if(graphMap.containsKey(graphName))    return "Graph with name: " + graphName + "already exists";
        else    graphMap.put(graphName, new Graph(maxNodes));
        return "Created new graph with name: " + graphName;
    }

    @Override
    public String addEdge(String graphName, int node1, int node2) throws RemoteException{
        if(!graphMap.containsKey(graphName))    return "Graph with name: " + graphName + " does not exist";
        else    graphMap.get(graphName).addEdge(node1, node2);
        return "Added edge between " + node1 + " and " + node2 + " in graph: " + graphName;
    }

    @Override
    public String shortestDistance(String graphName, int node1, int node2) throws RemoteException{
        if(!graphMap.containsKey(graphName))    return "Graph with name: " + graphName + " does not exist";
        int ret = graphMap.get(graphName).shortestDistance(node1, node2);
        if(ret == -1)   return "There does not exist a path between " + node1 + " and " + node2;
        return "Shortest distance between " + node1 + " and " + node2 + ": " + ret;
    }
}