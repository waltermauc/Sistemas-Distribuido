
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;
import java.util.*;

public class ChatServer {

    public static void main(String[] argv) {
        try {
            
            LocateRegistry.createRegistry(1099);
            
            Scanner s = new Scanner(System.in);
            System.out.println("ESCRIBE TU NOMBRE Y PRESIONA ENTER:");
            String nombre = s.nextLine().trim();

            Chat server = new Chat(nombre);

            Naming.rebind("rmi://localhost:1099/ABC", server);

            System.out.println("[SISTEMA] CHAT DISPONIBLE ESCRIBE:");

            while (true) {
                String msg = s.nextLine().trim();
                if (server.getClient() != null) {
                    ChatInterface client = server.getClient();
                    msg = "[" + server.getName() + "] " + msg;
                    client.send(msg);
                }
            }

        } catch (Exception e) {
            System.out.println("[SISTEMA] SERVIDOR FALLIDO: " + e);
        }
    }
}
