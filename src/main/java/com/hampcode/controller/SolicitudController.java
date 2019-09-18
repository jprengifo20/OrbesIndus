package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.SolicitudBusiness;
import com.hampcode.model.entity.Solicitud;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class SolicitudController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SolicitudBusiness solicitudBusiness;


	private Solicitud solicitud;
	private List<Solicitud> solicitudA;
	private Solicitud solicitudSelect;



	private String filterName;

	@PostConstruct
	public void init() {
		solicitud = new Solicitud();
		solicitudA = new ArrayList<Solicitud>();


		getAllSolicitud();
	}

//Methods
	public void getAllSolicitud() {
		try {
			solicitudA = solicitudBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Productos :" + e.getMessage());
		}
	}
	
	public String listSolicitud() {
		return "list.xhtml";
	}
	
	public void searchSolicitudByName() {
		try {

			solicitudA = solicitudBusiness.getSolicitudByName(this.filterName.trim());
			resetForm();
			if (solicitudA.isEmpty()) {
				Message.messageInfo("No se encontraron solicitudes");

			}

		} catch (Exception e) {
			Message.messageError("Error Solicitud Search :" + e.getMessage());
		}
	}
	
 //Select y reset//
	public void selectProduct(SelectEvent e) {
		this.solicitudSelect = (Solicitud) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.solicitud = new Solicitud();
	}
	
	
//Setters y Getters
	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public List<Solicitud> getSolicitudA() {
		return solicitudA;
	}

	public void setSolicitudA(List<Solicitud> solicitudA) {
		this.solicitudA = solicitudA;
	}

	public Solicitud getSolicitudSelect() {
		return solicitudSelect;
	}

	public void setSolicitudSelect(Solicitud solicitudSelect) {
		this.solicitudSelect = solicitudSelect;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	

	
	

	
	
}
