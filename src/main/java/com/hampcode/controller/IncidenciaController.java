package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.business.IncidenciaBusiness;
import com.hampcode.business.SupplierBusiness;
import com.hampcode.model.entity.Incidencia;
import com.hampcode.model.entity.Supplier;
import com.hampcode.model.repository.IncidenciaRepository;
import com.hampcode.util.Message;
@Named
@ViewScoped

public class IncidenciaController implements Serializable {
	private static final long serialVersionUID=1L;
	@Inject
	private IncidenciaBusiness incidenciaBusiness; 
	@Inject
	private SupplierBusiness supplierBusiness; 
	private Incidencia incidencia; 
	private List<Incidencia> incidencias;
	private Incidencia incidenciaSeleccionada;
	
	private Supplier supplier; 
	private List<Supplier> suppliers; 
	
	public void init()
	{
		incidencia= new Incidencia(); 
		incidencias= new ArrayList<Incidencia>();
		supplier= new Supplier();
		suppliers=new ArrayList<Supplier>(); 
		
	}
	
	void getAllSuppliers()
	{
		try
		{
			incidencias=incidenciaBusiness.getAll();
		}catch(Exception E)
		{
			Message.messageError("Error en la carga de datos");
		}
	}
}
