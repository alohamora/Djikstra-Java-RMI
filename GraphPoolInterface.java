import java.rmi.*; 
public interface GraphPoolInterface extends Remote 
{ 
    public String initGraph(String graphName) throws RemoteException; 
    public String addEdge(String graphName, int node1, int node2) throws RemoteException; 
    public String shortestDistance(String graphName, int node1, int node2) throws RemoteException;
    // public String getGraph(String graphName) throws RemoteException;
}