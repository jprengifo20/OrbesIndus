package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.OrdenDeCompra;
import com.hampcode.model.entity.Product;

public class OrdenDeCompraRepository implements Serializable{
		
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;

	public Long insert(OrdenDeCompra orden) throws Exception {
		em.persist(orden);
		return orden.getId();
	}

	public Long update(OrdenDeCompra orden) throws Exception {
		em.merge(orden);
		return orden.getId();
	}

	public List<OrdenDeCompra> findAll() throws Exception {
		List<OrdenDeCompra> orden = new ArrayList<>();

		TypedQuery<OrdenDeCompra> query = em.createQuery("FROM orden o", OrdenDeCompra.class);
		orden = query.getResultList();

		return orden;
	}

	public List<OrdenDeCompra> findByProveedor(String name) throws Exception {
		List<OrdenDeCompra> orden = new ArrayList<>();

		TypedQuery<OrdenDeCompra> query = em.createQuery("FROM orden o WHERE o.proveedor LIKE ?1", OrdenDeCompra.class);
		query.setParameter(1, "%" + name + "%");
		orden = query.getResultList();
		
		return orden;
	}
	public List<OrdenDeCompra> findByDate(String name) throws Exception {
		List<OrdenDeCompra> orden = new ArrayList<>();

		TypedQuery<OrdenDeCompra> query = em.createQuery("FROM orden o WHERE o.fecha LIKE ?1", OrdenDeCompra.class);
		query.setParameter(3, "%" + name + "%");
		orden = query.getResultList();

		return orden;
	}
	




}
