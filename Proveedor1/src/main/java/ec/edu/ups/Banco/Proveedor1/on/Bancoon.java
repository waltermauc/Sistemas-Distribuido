package ec.edu.ups.Banco.Proveedor1.on;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ec.edu.ups.Banco.Proveedor1.dao.*;
import ec.edu.ups.Banco.Proveedor1.model.*;

@Stateless
public class Bancoon {
	
	@Inject
	private BancoDao banco;
	
	public double depositar(int cuenta, double valor, String proveedor) throws Exception {
		EntidadBancaria cuentaRecueprada = banco.read(cuenta);
		if(cuentaRecueprada!=null) {
			if(cuentaRecueprada.getProveedor().equals(proveedor)) {
				double saldo = cuentaRecueprada.getSaldo();
				double saldoTotal = saldo + valor;
				return saldoTotal;
			}
			
		}
		return 0.0;
	}

	public double retirar(int cuenta, double valor,String proveedor) throws Exception {
		EntidadBancaria cuentaRecueprada = banco.read(cuenta);
		if(cuentaRecueprada!=null) {
			if(cuentaRecueprada.getProveedor().equals(proveedor)) {
				double saldo = cuentaRecueprada.getSaldo();
				if(saldo>=valor) {
					return saldo -valor;
				}
			}
			
		}
		return 0.0;
	}

}
