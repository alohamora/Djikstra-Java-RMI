import java.rmi.*;
import java.io.*;

public class Client
{
    static String IP_ADDR = "0.0.0.0";
    static int PORT = 1900;
    static GraphPoolInterface graphPool;
    public static void main(String args[]){
        try{ 
            graphPool = (GraphPoolInterface)Naming.lookup("rmi://" + IP_ADDR + ":" + PORT + "/graph"); 
            inputLoop();
        }
        catch(Exception e){ 
            System.out.println(e);
        } 
    }
    static void inputLoop(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try{
                String input = bufferedReader.readLine();
                if(input.length() > 0){
                    String[] cmd = input.split(" ");
                    if(cmd[0].equals("create_graph") && cmd.length == 2){
                        String serverOutput = graphPool.initGraph(cmd[1]);
                        System.out.println("[SERVER]: " + serverOutput);
                    }
                    else if(cmd[0].equals("add_edge") && cmd.length == 4){
                        String serverOutput = graphPool.addEdge(cmd[1], Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]));
                        System.out.println("[SERVER]: " + serverOutput);
                    }
                    else
                        System.out.println("Invalid command format");
                }
            }
            catch(Exception e){
                System.out.println(e.toString());
            }
        }
    }
}