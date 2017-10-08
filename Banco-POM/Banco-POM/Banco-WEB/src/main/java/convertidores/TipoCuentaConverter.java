package convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import entidades.TipoCuenta;
import servicios.TipoCuentasEJB;

@FacesConverter(value = "tipoCuentaConverter", forClass = TipoCuenta.class)
@Named
public class TipoCuentaConverter implements Converter {

	/**
	 * Ejb que contiene la lógica de la entidad TipoCuenta.
	 */
	@EJB
	private TipoCuentasEJB tipoCuentaEJB;

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

		final String id = string;
		TipoCuenta tipoCuenta = tipoCuentaEJB.consultarPorLlave(Long.parseLong(id));

		return tipoCuenta;
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
		if (object instanceof TipoCuenta) {
			TipoCuenta tipoCuenta = (TipoCuenta) object;

			// Se obtiene el id de la entidad seleccionada
			final String idTipoCuenta = String.valueOf(tipoCuenta.getTipoCuentaId());

			return idTipoCuenta;
		} else {

			throw new IllegalArgumentException();
		}
	}
}
