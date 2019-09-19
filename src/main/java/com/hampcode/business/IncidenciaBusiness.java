package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.model.entity.Incidencia;
import com.hampcode.model.repository.IncidenciaRepository;

@Named
public class IncidenciaBusiness implements Serializable{

	int numero;
	int numero2;
	private static final long serialVersionUID = 1L;
	@Inject
	private IncidenciaRepository incidenciaRepositorio; 
	
	public long insert(Incidencia incidencia)throws Exception
	{
		return incidenciaRepositorio.insert(incidencia);
	}
	public long update(Incidencia incidencia)throws Exception
	{
		return incidenciaRepositorio.update(incidencia);
	}
	public List<Incidencia>getAll()throws Exception
	{
		return incidenciaRepositorio.findall();
	}
	
}
