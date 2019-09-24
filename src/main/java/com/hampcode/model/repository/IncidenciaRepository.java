package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Incidencia;


public class IncidenciaRepository implements Serializable {

	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;
	
	public Long insert(Incidencia incidencia) throws Exception {
		em.persist(incidencia);
		return incidencia.getId();
	}
	
	public Long update(Incidencia incidencia) throws Exception {
		em.merge(incidencia);
		return incidencia.getId();
	}
	
	public List<Incidencia> findAll() throws Exception {
		List<Incidencia> incidencias = new ArrayList<>();

		TypedQuery<Incidencia> query = em.createQuery("FROM Incidencia i", Incidencia.class);
		incidencias = query.getResultList();

		return incidencias;
	}
	
}
