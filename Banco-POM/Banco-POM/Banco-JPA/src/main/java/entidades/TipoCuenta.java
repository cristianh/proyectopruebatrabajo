package entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="T_TIPOSCUENTA")
public class TipoCuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TIPOCUENTA", unique=true, nullable=false)
	private Long tipoCuentaId;

	@Column(name="DESCRIPCION", nullable=false, length=255)
	private String descripcion;

	@OneToMany(mappedBy="tipoCuenta")
	private List<Cuenta> cuentas;
	
	public TipoCuenta() {
	}

	public Long getTipoCuentaId() {
		return tipoCuentaId;
	}

	public void setTipoCuentaId(Long tipoCuentaId) {
		this.tipoCuentaId = tipoCuentaId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	@Override
	public String toString() {
		return "TipoCuenta [tipoCuentaId=" + tipoCuentaId + ", descripcion=" + descripcion + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipoCuentaId == null) ? 0 : tipoCuentaId.hashCode());
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
		TipoCuenta other = (TipoCuenta) obj;
		if (tipoCuentaId == null) {
			if (other.tipoCuentaId != null)
				return false;
		} else if (!tipoCuentaId.equals(other.tipoCuentaId))
			return false;
		return true;
	}

	
	

}