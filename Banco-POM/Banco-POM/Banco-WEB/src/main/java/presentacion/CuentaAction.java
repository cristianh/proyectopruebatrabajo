package presentacion;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import entidades.Cliente;
import entidades.Cuenta;
import entidades.TipoCuenta;
import servicios.ClientesEJB;
import servicios.CuentasEJB;
import servicios.TipoCuentasEJB;

@Named("cuentaAction")
@ViewScoped
public class CuentaAction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB 
	private ClientesEJB clienteEjb;
	
	@EJB
	private TipoCuentasEJB tiposCuentaEjb;
	
	@EJB
	private CuentasEJB cuentaEjb;
	
	
	private List<TipoCuenta> tiposCuenta;
	
	private List<Cliente> clientes;
	
	private List<Cuenta> cuentas;
	
	private boolean mostrarPanelCrud;
	
	private TipoCuenta tipoCuentaSeleccionado;
	
	private Cliente clienteSeleccionado;
	
	private Double saldo;
	
	private String numeroCuenta;
	
	private String estado;
	
	private String password;
	
	
	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	@PostConstruct
	public void inicializar(){
		tiposCuenta = tiposCuentaEjb.consultarTodosTipoCuenta();
		clientes = clienteEjb.consultarTodosClientes();
		cuentas = cuentaEjb.consultarTodosCuenta();
		mostrarPanelCrud = Boolean.FALSE;
		estado = "A";
	}
	
	
	
	
	public void seleccionarTipoCuenta(){

		System.out.println(tipoCuentaSeleccionado);
		
		if(tipoCuentaSeleccionado.getTipoCuentaId()==1L){
			saldo = new Double(10000L);
			return;
		}
		
		if(tipoCuentaSeleccionado.getTipoCuentaId()==2L){
			saldo = new Double(20000L);
			return;
		}
		
		if(tipoCuentaSeleccionado.getTipoCuentaId()==3L){
			saldo = new Double(30000L);
			return;
		}
		
	}
	
	 
	 
	 public void crearCuenta() {
	     
		 Cuenta cuenta = new Cuenta();
		 cuenta.setCancelada(estado.equals("A") ? false : true);
		 cuenta.setCliente(clienteSeleccionado);
		 cuenta.setNumero(numeroCuenta);
		 cuenta.setPassword(password);
		 cuenta.setSaldo(saldo);
		 cuenta.setTipoCuenta(tipoCuentaSeleccionado);
		 
		 cuentaEjb.crearCuenta(cuenta);
		 
		 mostrarPanelCrud = Boolean.FALSE;
		 cuentas = cuentaEjb.consultarTodosCuenta();
		 limpiarCampos();
		 
    }
	 
	 
	 public void limpiarCampos() {
		 
		 numeroCuenta = null;
		 clienteSeleccionado = null;
		 password = null;
		 saldo = null;
		 tipoCuentaSeleccionado = null;
	 }
	 
	
	public TipoCuenta getTipoCuentaSeleccionado() {
		return tipoCuentaSeleccionado;
	}

	public void setTipoCuentaSeleccionado(TipoCuenta tipoCuentaSeleccionado) {
		this.tipoCuentaSeleccionado = tipoCuentaSeleccionado;
	}

	public void habilitarPanel(){		
		mostrarPanelCrud = Boolean.TRUE;
	}
	
	public void inHabilitarPanel(){		
		mostrarPanelCrud = Boolean.FALSE;
	}

	public List<TipoCuenta> getTiposCuenta() {
		return tiposCuenta;
	}

	public void setTiposCuenta(List<TipoCuenta> tiposCuenta) {
		this.tiposCuenta = tiposCuenta;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public boolean isMostrarPanelCrud() {
		return mostrarPanelCrud;
	}

	public void setMostrarPanelCrud(boolean mostrarPanelCrud) {
		this.mostrarPanelCrud = mostrarPanelCrud;
	}

	public Cliente getClienteSeleccionado() {
		return clienteSeleccionado;
	}

	public void setClienteSeleccionado(Cliente clienteSeleccionado) {
		this.clienteSeleccionado = clienteSeleccionado;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
