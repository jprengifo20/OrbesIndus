package com.hampcode.model.repository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Solicitud;


@Named
public class SolicitudRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;
	
	
	public List<Solicitud> findAll() throws Exception {
		List<Solicitud> solicitud = new ArrayList<>();

		TypedQuery<Solicitud> query = em.createQuery("SELECT s FROM Solicitud s", Solicitud.class);
		solicitud = query.getResultList();
		return solicitud;
	}
	
	public List<Solicitud> findByName(String name) throws Exception {
		List<Solicitud> solicitud = new ArrayList<>();

		TypedQuery<Solicitud> query = em.createQuery("FROM Solicitud p WHERE p.name LIKE ?1", Solicitud.class);
		query.setParameter(1, "%" + name + "%");
		solicitud = query.getResultList();

		return solicitud;
	}

	
	
}
