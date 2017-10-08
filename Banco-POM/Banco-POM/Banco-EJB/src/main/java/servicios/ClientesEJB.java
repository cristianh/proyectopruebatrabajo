package servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Cliente;
import entidades.TipoCuenta;

@Stateless
@LocalBean
public class ClientesEJB {

	@PersistenceContext
	EntityManager manager;

	public List<Cliente> consultarTodosClientes() {
		String jpql = "SELECT cli From Cliente cli";

		Query query = manager.createQuery(jpql);

		List<Cliente> clientes = query.getResultList();

		return clientes;
	}
	
	
	public Cliente consultarClientePorLlave(String cedula) {
		
		return manager.find(Cliente.class, cedula);
	}

}
