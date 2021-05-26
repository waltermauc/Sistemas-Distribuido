package ec.edu.ups.Banco.Proveedor.ws;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.Banco.Proveedor.on.*;


@Path("/Servicio")
public class Servicio {

	@Inject
	private Bancoon banco;
	
	@GET
	@Path("/depositar")
	@Produces(MediaType.APPLICATION_JSON)
	public double depositarService(@QueryParam("cuenta") int cuenta, @QueryParam("valor") double valor,@QueryParam("proveedor") String proveedor) {
		try {
			return banco.depositar(cuenta, valor,proveedor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0;
	}
	@GET
	@Path("/retirar")
	@Produces(MediaType.APPLICATION_JSON)
	public double retirarService(@QueryParam("cuenta") int cuenta, @QueryParam("valor") double valor,@QueryParam("proveedor") String proveedor) {
		try {
			return banco.retirar(cuenta, valor, proveedor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0;
	}
}
