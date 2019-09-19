package com.hampcode.model.repository;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Proveedor;

public class ProveedorRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;
	
	public Long insert (Proveedor proveedor) throws Exception
	{
		em.persist(proveedor);
		return proveedor.getId();
	}
	
	public Long update (Proveedor proveedor) throws Exception
	{
		em.merge(proveedor);
		return proveedor.getId();
	}
	public java.util.List<Proveedor> findAll() throws Exception
	{
		java.util.List<Proveedor> proveedores= new ArrayList<>();
		
		TypedQuery<Proveedor> query = em.createQuery("SELECT s FROM Proveedor s", Proveedor.class);
		proveedores=query.getResultList();
		return proveedores;
	}
	
	public java.util.List<Proveedor> findByEmpresa (String empresa) throws Exception
	{
		java.util.List<Proveedor> proveedores=new ArrayList<>();
		
		TypedQuery<Proveedor> query = em.createQuery("FROM Proveedor p WHERE p.empresa LIKE ?1", Proveedor.class);
		query.setParameter(1, "%"+empresa+"%");
		proveedores=query.getResultList();
		
		return proveedores;
	}
	
	public java.util.List<Proveedor> findById(Long id) throws Exception
	{
		java.util.List<Proveedor> proveedores = new ArrayList<>();
		
		TypedQuery<Proveedor> query = em.createQuery("FROM Proveedor p WHERE p.id LIKE ?1",Proveedor.class);
		query.setParameter(1,"%"+id+"%");
		proveedores=query.getResultList();
		
		return proveedores;
	}
}
