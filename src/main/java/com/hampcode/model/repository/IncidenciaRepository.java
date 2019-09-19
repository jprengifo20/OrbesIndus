package com.hampcode.model.repository;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Incidencia;

@Named
public class IncidenciaRepository implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	public long insert(Incidencia incidencia)throws Exception
	{
		em.persist(incidencia);
		return incidencia.getId();
	}
	
	public long update(Incidencia incidencia)throws Exception
	{
		em.merge(incidencia); 
		return incidencia.getId();
	}
	public List<Incidencia>findall()throws Exception
	{
		List<Incidencia>incidencias=new ArrayList<>();
		TypedQuery<Incidencia>query=em.createQuery("FROM Incidencia i",Incidencia.class); 
		incidencias=query.getResultList(); 
		return incidencias; 
	}
	

	
}
