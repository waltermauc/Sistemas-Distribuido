package ec.edu.ups.Banco.Proveedor.ws;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.Banco.Proveedor.on.*;

@WebService
public class Servicio {

	@Inject
	private Bancoon banco;
	
	@WebMethod
	public double depositarService(int cuenta, double valor) {
		try {
			return banco.depositar(cuenta, valor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0;
	}
	@WebMethod
	public double retirarService(int cuenta, double valor) {
		try {
			return banco.retirar(cuenta, valor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0;
	}
}
