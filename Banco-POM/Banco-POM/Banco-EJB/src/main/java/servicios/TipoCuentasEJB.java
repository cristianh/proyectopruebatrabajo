package servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.TipoCuenta;

@Stateless
@LocalBean
public class TipoCuentasEJB {

	@PersistenceContext
	EntityManager manager;

	public List<TipoCuenta> consultarTodosTipoCuenta() {
		String jpql = "SELECT tc From TipoCuenta tc";

		Query query = manager.createQuery(jpql);

		List<TipoCuenta> tiposCuenta = query.getResultList();

		return tiposCuenta;
	}
	
	
	public TipoCuenta consultarPorLlave(Long idTipoCuenta) {
		
		return manager.find(TipoCuenta.class, idTipoCuenta);
	}

}
