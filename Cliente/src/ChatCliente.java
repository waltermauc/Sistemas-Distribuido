import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;
import java.util.*;
 
public class ChatCliente {
	public static void main (String[] argv) {
	    try {
	    	    LocateRegistry.createRegistry (2012);
		    	Scanner s=new Scanner(System.in);
		    	System.out.println("ESCRIBE TU NOMBRE Y PRESIONA ENTER:");
		    	String nombre=s.nextLine().trim();		    		    	
		    	ChatInterface cliente = new Chat(nombre);
 
		    	ChatInterface server = (ChatInterface)Naming.lookup("rmi://localhost/ABC");
		    	String msg="["+cliente.getName()+"] CONECTADO";
		    	server.send(msg);
		    	System.out.println("[SISTEMA] CHAT DISPONIBLE ESCRIBE:");
		    	server.setClient(cliente);
 
		    	while(true){
		    		msg=s.nextLine().trim();
		    		msg="["+cliente.getName()+"] "+msg;		    		
	    			server.send(msg);
		    	}
 
	    	}catch (Exception e) {
	    		System.out.println("[SISTEMA] SERVIDOR FALLIDO: " + e);
	    	}
		}
}