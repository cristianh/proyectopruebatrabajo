package entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//Prueba para subir al git prueba git 2
@Entity
@Table(name="T_CLIENTES")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CEDULA", length=15, unique=true, nullable=false)
	private String cedula;

	@Column(name="NOMBRE", nullable=false, length=50)
	private String nombre;
	
	@Column(name="TELEFONO", length=15)
	private String telefono;
	
	@Column(name="DIRECCION", length=50, nullable=false)
	private String direccion;
	
//	@OneToMany(mappedBy="cliente")
//	private List<Cuenta> cuentas;

	public Cliente() {
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
//	public List<Cuenta> getCuentas() {
//		return cuentas;
//	}
//
//	public void setCuentas(List<Cuenta> cuentas) {
//		this.cuentas = cuentas;
//	}

	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion="
				+ direccion + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		return true;
	}

	
}