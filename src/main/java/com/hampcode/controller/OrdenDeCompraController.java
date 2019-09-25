package com.hampcode.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.OrdenDeCompraBusiness;
import com.hampcode.business.SupplierBusiness;
import com.hampcode.model.entity.OrdenDeCompra;
import com.hampcode.util.Message;

public class OrdenDeCompraController {

	private static final long serialVersionUID = 1L;

	@Inject
	private OrdenDeCompraBusiness ordenBusiness;

	@Inject
	private SupplierBusiness supplierBusiness;

	private OrdenDeCompra orden;
	private List<OrdenDeCompra> ordenes;
	private OrdenDeCompra ordenSelect;


	private String filterName;
	private String filterDate;
	private String filterCountry;

	@PostConstruct
	public void init() {
		orden = new OrdenDeCompra();
		ordenes = new ArrayList<OrdenDeCompra>();

	
		getAllOrden();
	}

	public void getAllOrden() {
		try {
			ordenes = ordenBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Orden de Compra :" + e.getMessage());
		}
	}

	public String newOrden() {
		try {
			this.ordenes=ordenBusiness.getAll();
			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}
	return "insertOrden.xhtml";
	}

	public String listOrden() {
	return "listOrden.xhtml";
	}

	
	public String saveProduct() {
		String view = "";
		try {

			if (orden.getId() != null) {
				
				ordenBusiness.update(orden);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				
				ordenBusiness.insert(orden);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllOrden();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error de Orden de Compra :" + e.getStackTrace());
		}

		return view;
	}

	public String editOrden() {
		String view = "";
		try {
			if (this.ordenSelect != null) {
				this.orden = ordenSelect;

				view = "/orden/update";
			} else {
				Message.messageInfo("Debe seleccionar un producto");
			}
		} catch (Exception e) {
			Message.messageError("Error Product :" + e.getMessage());
		}

		return view;
	}

	public void searchOrdenByName() {
		try {

			ordenes = ordenBusiness.getOrdenDeCompraByProveedor(this.filterName.trim());
			resetForm();
			if (ordenes.isEmpty()) {
				Message.messageInfo("No se encontraron ordenes de compra");

			}

		} catch (Exception e) {
			Message.messageError("Error Product Search :" + e.getMessage());
		}
	}
	public void searchOrdenByDate() {
		try {

			ordenes = ordenBusiness.getOrdenDeCompraByDate(this.filterDate.trim());
			resetForm();
			if (ordenes.isEmpty()) {
				Message.messageInfo("No se encontraron ordenes de compra");

			}

		} catch (Exception e) {
			Message.messageError("Error Orden Search :" + e.getMessage());
		}
	}


	public void selectOrden(SelectEvent e) {
		this.ordenSelect = (OrdenDeCompra) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.orden = new OrdenDeCompra();
	}

	public void resetForm2() {
		this.filterDate = "";
		this.orden = new OrdenDeCompra();
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	public OrdenDeCompraBusiness getOrdenBusiness() {
		return ordenBusiness;
	}

	public void setOrdenBusiness(OrdenDeCompraBusiness ordenBusiness) {
		this.ordenBusiness = ordenBusiness;
	}

	public SupplierBusiness getSupplierBusiness() {
		return supplierBusiness;
	}

	public void setSupplierBusiness(SupplierBusiness supplierBusiness) {
		this.supplierBusiness = supplierBusiness;
	}

	public OrdenDeCompra getOrden() {
		return orden;
	}

	public void setOrden(OrdenDeCompra orden) {
		this.orden = orden;
	}

	public List<OrdenDeCompra> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<OrdenDeCompra> ordenes) {
		this.ordenes = ordenes;
	}

	public OrdenDeCompra getOrdenSelect() {
		return ordenSelect;
	}

	public void setOrdenSelect(OrdenDeCompra ordenSelect) {
		this.ordenSelect = ordenSelect;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public String getFilterDate() {
		return filterDate;
	}

	public void setFilterDate(String filterDate) {
		this.filterDate = filterDate;
	}

	public String getFilterCountry() {
		return filterCountry;
	}

	public void setFilterCountry(String filterCountry) {
		this.filterCountry = filterCountry;
	}

	public String Mensaje() {
		String view = "";
		try {

		Message.messageInfo("Se cargaron los datos correctamente");
			
		this.getAllOrden();
		resetForm();
		view = "listOrden2.xhtml";
		} catch (Exception e) {
			Message.messageError("Error al cargar datos :" + e.getStackTrace());
		}

		return view;
	}



	
}
