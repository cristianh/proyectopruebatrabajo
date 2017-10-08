package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="T_CUENTAS")
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMERO", length=30, unique=true, nullable=false)
	private String numero;
	
	@ManyToOne
	@JoinColumn(name="CED_CLIENTE", nullable=false)
	private Cliente cliente;	
	
	@Column(name="SALDO", nullable=false, precision = 10, scale = 0)
	private Double saldo;
	
	@Column(name="PASSWORD", nullable=false, length=10)
	private String password;
	
	@ManyToOne
	@JoinColumn(name="ID_TIPOCUENTA", nullable=false)
	private TipoCuenta tipoCuenta;
	
	@Column(name="CANCELADA", nullable=false)
	private Boolean cancelada;

	
	public Cuenta() {
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Double getSaldo() {
		return saldo;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}


	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}


	public Boolean getCancelada() {
		return cancelada;
	}


	public void setCancelada(Boolean cancelada) {
		this.cancelada = cancelada;
	}


	@Override
	public String toString() {
		return "Cuenta [numero=" + numero + ", cliente=" + cliente + ", saldo=" + saldo + ", password=" + password
				+ ", tipoCuenta=" + tipoCuenta + ", cancelada=" + cancelada + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Cuenta other = (Cuenta) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}


	

}