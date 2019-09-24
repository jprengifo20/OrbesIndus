package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.business.IncidenciaBusiness;
import com.hampcode.business.ProveedorBusiness;
import com.hampcode.model.entity.Incidencia;
import com.hampcode.model.entity.Product;
import com.hampcode.model.entity.Proveedor;
import com.hampcode.util.Message;

@Named
@ViewScoped
public class IncidenciaController implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Inject 
	private IncidenciaBusiness incidenciaBusiness;
	
	@Inject 
	private ProveedorBusiness proveedorBusiness; 
	
	private Incidencia incidencia;
	public Incidencia getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(Incidencia incidencia) {
		this.incidencia = incidencia;
	}

	public List<Incidencia> getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(List<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}

	public Incidencia getIncidenciaSeleccionada() {
		return incidenciaSeleccionada;
	}

	public void setIncidenciaSeleccionada(Incidencia incidenciaSeleccionada) {
		this.incidenciaSeleccionada = incidenciaSeleccionada;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	private List<Incidencia> incidencias; 
	private Incidencia incidenciaSeleccionada; 
	
	private Proveedor proveedor; 
	private List<Proveedor>proveedores; 
	
	@PostConstruct
	public void init()
	{
		incidencia= new Incidencia(); 
		incidencias=new ArrayList<Incidencia>(); 
		
		proveedor= new Proveedor(); 
		proveedores= new ArrayList<Proveedor>(); 
	}
	
	public void getAllIncidencias()
	{
		try
		{
			incidencias= incidenciaBusiness.getall();
		}catch(Exception e)
		{
			Message.messageError("Error en la carga de incidencias");
		}
	}
	
	/*public String newIncidencias()
	{
		try {
			this.incidencias=incidenciaBusiness.getall();
			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}*/
	

	
	
	
	
	
	
	
	
	
}
