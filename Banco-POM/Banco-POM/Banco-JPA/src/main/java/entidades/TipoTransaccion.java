package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="T_TIPOSTRANSACCION")
public class TipoTransaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TIPOTRANSACCION", unique=true, nullable=false)
	private Long tipoTransaccionId;

	@Column(name="DESCRIPCION", nullable=false, length=255)
	private String descripcion;
	
	@Column(name="IMPUESTO", nullable=false, precision = 10, scale = 2)
	private Double impuesto;
	
	
	public TipoTransaccion() {
	}


	public Long getTipoTransaccionId() {
		return tipoTransaccionId;
	}


	public void setTipoTransaccionId(Long tipoTransaccionId) {
		this.tipoTransaccionId = tipoTransaccionId;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Double getImpuesto() {
		return impuesto;
	}


	public void setImpuesto(Double impuesto) {
		this.impuesto = impuesto;
	}


	@Override
	public String toString() {
		return "TipoTransaccion [tipoTransaccionId=" + tipoTransaccionId + ", descripcion=" + descripcion
				+ ", impuesto=" + impuesto + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipoTransaccionId == null) ? 0 : tipoTransaccionId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoTransaccion other = (TipoTransaccion) obj;
		if (tipoTransaccionId == null) {
			if (other.tipoTransaccionId != null)
				return false;
		} else if (!tipoTransaccionId.equals(other.tipoTransaccionId))
			return false;
		return true;
	}



	

}