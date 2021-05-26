package ec.edu.ups.Banco.Proveedor1.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EntidadBancaria {

	@Id
	@Column(name = "id_cueta")
	private int idCuenta;
	
	@Column(name = "cedula_cliente")
	private String cedula;
	
	@Column(name = "saldo")
	private double saldo;
	
	@Column(name = "proveedor")
	private String proveedor;

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	
}
