package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Incidencia;
import com.hampcode.model.repository.IncidenciaRepository;

@Named
public class IncidenciaBusiness implements Serializable{
	private static final long serialVersionUID = 1L;
	private IncidenciaRepository incidenciaRepository; 
	@Transactional
	public long insert (Incidencia incidencia) throws Exception
	{
		return incidenciaRepository.insert(incidencia); 
	}
	
	public long update(Incidencia incidencia)throws Exception
	{
		return incidenciaRepository.update(incidencia); 
	}
	public List<Incidencia> getall()throws Exception
	{
		return incidenciaRepository.findAll();
	}
	
	
}
