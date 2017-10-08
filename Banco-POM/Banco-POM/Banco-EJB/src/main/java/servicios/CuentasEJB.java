package servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Cuenta;

@Stateless
@LocalBean
public class CuentasEJB {

	@PersistenceContext
	EntityManager manager;

	public void crearCuenta(Cuenta cuenta) {

		manager.persist(cuenta);
	}

	public List<Cuenta> consultarTodosCuenta() {
		String jpql = "SELECT cta From Cuenta cta";

		Query query = manager.createQuery(jpql);

		List<Cuenta> cuenta = query.getResultList();

		return cuenta;
	}

}
