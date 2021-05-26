import java.rmi.*;
import java.rmi.server.*;
 
public class Chat extends UnicastRemoteObject implements ChatInterface  {
 
	public String nombre;
	public ChatInterface cliente=null;
 
	public Chat(String n)  throws RemoteException { 
		this.nombre=n;   
	}
	public String getName() throws RemoteException {
		return this.nombre;
	}
 
	public void setClient(ChatInterface c){
		cliente=c;
	}
 
	public ChatInterface getClient(){
		return cliente;
	}
 
	public void send(String s) throws RemoteException{
		System.out.println(s);
	}	
}