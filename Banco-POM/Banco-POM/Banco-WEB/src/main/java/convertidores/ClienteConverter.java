package convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import entidades.Cliente;
import servicios.ClientesEJB;


@Named
@FacesConverter(value = "clienteConverter", forClass = Cliente.class)
public class ClienteConverter implements Converter {

	/**
	 * Ejb que contiene la lógica de la entidad cliente.
	 */
	@EJB
	private ClientesEJB clienteEJB;

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext
	 *      , javax.faces.component.UIComponent, java.lang.String)
	 */
	public Object getAsObject(FacesContext facesContext,
			UIComponent uIComponent, String string) {

		if (string == null
				|| string.trim().length() == 0
				|| string.equals("Seleccione")) {
			return null;
		}

		final String cedula = string;
		Cliente cliente = clienteEJB.consultarClientePorLlave(cedula);

		return cliente;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext
	 *      , javax.faces.component.UIComponent, java.lang.Object)
	 */
	public String getAsString(FacesContext facesContext,
			UIComponent uIComponent, Object object) {
		if (object == null) {
			return null;
		}
		if (object instanceof Cliente) {
			Cliente cliente = (Cliente) object;

			// Se obtiene el id de la entidad seleccionada
			final String cedula = cliente.getCedula();

			return cedula;
		} else {

			throw new IllegalArgumentException();
		}
	}

}
