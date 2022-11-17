import RMI.RemoteServer;

public class Main {
    public static void main(String[] args){
        System.out.println("----------------------Start-------------------");
        try
        {
            RemoteServer server = new RemoteServer();
            server.startServer();
        }
        catch(Exception e)
        {
            System.out.println("Client/Server connection Error");
            e.printStackTrace();
        }
    }

}

