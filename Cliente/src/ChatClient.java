import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;
import java.util.*;
 
public class ChatClient {
	public static void main (String[] argv) {
	    try {
	    	    LocateRegistry.createRegistry (2012);
		    	Scanner s=new Scanner(System.in);
		    	System.out.println("Enter Your name and press Enter:");
		    	String name=s.nextLine().trim();		    		    	
		    	ChatInterface client = new Chat(name);
 
		    	ChatInterface server = (ChatInterface)Naming.lookup("rmi://localhost/ABC");
		    	String msg="["+client.getName()+"] got connected";
		    	server.send(msg);
		    	System.out.println("[System] Chat Remote Object is ready:");
		    	server.setClient(client);
 
		    	while(true){
		    		msg=s.nextLine().trim();
		    		msg="["+client.getName()+"] "+msg;		    		
	    			server.send(msg);
		    	}
 
	    	}catch (Exception e) {
	    		System.out.println("[System] Server failed: " + e);
	    	}
		}
}