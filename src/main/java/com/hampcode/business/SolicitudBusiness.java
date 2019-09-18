package com.hampcode.business;

import java.io.Serializable;
import java.util.List;


import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.model.entity.Solicitud;
import com.hampcode.model.repository.SolicitudRepository;

@Named
public class SolicitudBusiness implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private SolicitudRepository solicitudRepository;

	
	public List<Solicitud> getAll() throws Exception {
		return solicitudRepository.findAll();
	}
	
	public List<Solicitud> getSolicitudByName(String name) throws Exception{
		return solicitudRepository.findByName(name);
	}

}
