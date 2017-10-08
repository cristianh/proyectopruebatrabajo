package entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="T_TRANSACCIONES")
public class Transaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TRANSACCION", unique=true, nullable=false)
	private Long transaccionId;
	
	@ManyToOne
	@JoinColumn(name="NUMERO_CUENTA", nullable=false)
	private Cuenta cuenta;	
	
	@Column(name="SALDO", nullable=false, precision = 10, scale = 0)
	private Double saldo;
	
	@ManyToOne
	@JoinColumn(name="ID_TIPOTRANSACCION", nullable=false)
	private TipoTransaccion tipoTransaccion;
	
	@Column(name="FECHA", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
		
	public Transaccion() {
	}

	public Long getTransaccionId() {
		return transaccionId;
	}

	public void setTransaccionId(Long transaccionId) {
		this.transaccionId = transaccionId;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public TipoTransaccion getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Transaccion [transaccionId=" + transaccionId + ", cuenta=" + cuenta + ", saldo=" + saldo
				+ ", tipoTransaccion=" + tipoTransaccion + ", fecha=" + fecha + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transaccionId == null) ? 0 : transaccionId.hashCode());
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
		Transaccion other = (Transaccion) obj;
		if (transaccionId == null) {
			if (other.transaccionId != null)
				return false;
		} else if (!transaccionId.equals(other.transaccionId))
			return false;
		return true;
	}

	

}