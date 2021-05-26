package ec.edu.ups.Banco.Proveedor1.dao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.Banco.Proveedor1.model.*;

@Stateless
public class BancoDao {

	@PersistenceContext
	private EntityManager em;
	
	public EntidadBancaria read(int cuenta) {
		return em.find(EntidadBancaria.class, cuenta);
	}
	
}
