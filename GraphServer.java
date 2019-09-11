import java.rmi.*; 
import java.rmi.registry.*; 
public class GraphServer{
    static String IP_ADDR = "0.0.0.0";
    static int PORT = 1900;
    public static void main(String args[]){ 
        try{ 
            GraphPool obj = new GraphPool();
            LocateRegistry.createRegistry(PORT);
            Naming.rebind("rmi://" + IP_ADDR + ":" + PORT + "/graph",obj);
        }
        catch(Exception e){
            System.out.println(e.toString()); 
        }
    }
}