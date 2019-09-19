package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.auth.message.MessageInfo;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.ProveedorBusiness;
import com.hampcode.model.entity.Product;
import com.hampcode.model.entity.Proveedor;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class ProveedorController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProveedorBusiness proveedorBusiness;

	private Proveedor proveedor;
	private List<Proveedor> proveedores;
	private Proveedor proveedorSelect;
	
	private String filterEmpresa;
	private Long filterId;
	
	@PostConstruct
	public void init()
	{
		proveedor=new Proveedor();
		proveedores=new ArrayList<Proveedor>();
		
		getAllProveedores();
	}
	
	public void getAllProveedores()
	{
		try
		{
			proveedores=proveedorBusiness.getAll();
		}catch (Exception e) {
			Message.messageError("Error en la carga de Proveedores:"+e.getMessage());
		}
	}
	
	public String newProveedor()
	{
		try {
			this.proveedores=proveedorBusiness.getAll();
			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "insertProveedor.xhtml";
	}
	
	public String listProveedor()
	{
		return "listProveedor.xhtml";
	}
	
	public String saveProveedor()
	{
		String view="";
		try {
			if(proveedor.getId()!= null)
			{
				proveedorBusiness.update(proveedor);
				Message.messageInfo("Se actualizó correctamente al proveedor");
			}else
			{
				proveedorBusiness.insert(proveedor);
				Message.messageInfo("Se registró correctamente el proveedor");
			}
			this.getAllProveedores();
			resetForm();
			view="/proveedor/listProveedor";
		} catch (Exception e) {
			Message.messageError("Error Proveedor :" + e.getStackTrace());
		}
		return view;
	}
	
	public String editProveedor()
	{
		String view ="";
		try {
			if(this.proveedorSelect!=null)
			{
				this.proveedor=proveedorSelect;
				view = "/proveedor/updateProveedor";
			}else
			{
				Message.messageInfo("Debe seleccionar un producto");
			}
		} catch (Exception e) {
			Message.messageError("Error Proveedor: "+e.getMessage());
		}
		
		return view;
	}
	
	public void searchProveedorByEmpresa()
	{
		try {
			proveedores=proveedorBusiness.getProveedorByEmpresa(this.filterEmpresa.trim());
			resetForm();
			if(proveedores.isEmpty())
			{
				Message.messageInfo("El proveedor buscado no existe");
			}
		} catch (Exception e) {
			Message.messageError("Error Buscar Proveedor: "+ e.getMessage());
		}
	}
	
	public void searchProovedorByID()
	{
		try {
			proveedores=proveedorBusiness.getProveedorById(this.filterId);
			resetForm();
			if(proveedores.isEmpty())
			{
				Message.messageInfo("No se encontraron productos");	
			}
		} catch (Exception e) {
			Message.messageError("Error Product Search :" + e.getMessage());
		}
	}
	
	public void selectProveedor(SelectEvent e)
	{
		this.proveedorSelect=(Proveedor) e.getObject();
	}
	
	public void resetForm() {
		this.filterEmpresa = "";
		this.proveedor = new Proveedor();
	}

	public void resetForm2() {
		this.filterId = null;
		this.proveedor = new Proveedor();
	}

	public ProveedorBusiness getProveedorBusiness() {
		return proveedorBusiness;
	}

	public void setProveedorBusiness(ProveedorBusiness proveedorBusiness) {
		this.proveedorBusiness = proveedorBusiness;
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

	public Proveedor getProveedorSelect() {
		return proveedorSelect;
	}

	public void setProveedorSelect(Proveedor proveedorSelect) {
		this.proveedorSelect = proveedorSelect;
	}

	public String getFilterEmpresa() {
		return filterEmpresa;
	}

	public void setFilterEmpresa(String filterEmpresa) {
		this.filterEmpresa = filterEmpresa;
	}

	public Long getFilterId() {
		return filterId;
	}

	public void setFilterId(Long filterId) {
		this.filterId = filterId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String Mensaje() {
		String view = "";
		try {

		Message.messageInfo("Se cargaron los datos correctamente");
			
		this.getAllProveedores();
		resetForm();
		view = "listProveedor2";
		} catch (Exception e) {
			Message.messageError("Error al cargar datos :" + e.getStackTrace());
		}

		return view;
	}
	
}

