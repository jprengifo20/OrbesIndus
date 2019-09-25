package com.hampcode.model.repository;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	
	public void delete (Long id) throws Exception
	{
		Proveedor proveedor=em.find(Proveedor.class, id);
		if(proveedor!=null)
		{
			em.remove(proveedor);
		}
	}
	
	public List<Proveedor> findAll() throws Exception
	{
		List<Proveedor> proveedores= new ArrayList<>();
		
		TypedQuery<Proveedor> query = em.createQuery("FROM Proveedor p", Proveedor.class);
		proveedores=query.getResultList();
		return proveedores;
	}
	
	public List<Proveedor> findByEmpresa (String empresa) throws Exception
	{
		List<Proveedor> proveedores=new ArrayList<>();
		
		TypedQuery<Proveedor> query = em.createQuery("FROM Proveedor p WHERE p.empresa LIKE ?1", Proveedor.class);
		query.setParameter(1, "%"+empresa+"%");
		proveedores=query.getResultList();
		
		return proveedores;
	}
	
	public List<Proveedor> findByProducto (String producto) throws Exception
	{
		List<Proveedor> proveedores=new ArrayList<>();
		
		TypedQuery<Proveedor> query = em.createQuery("FROM Proveedor p WHERE p.producto LIKE ?1", Proveedor.class);
		query.setParameter(1, "%"+producto+"%");
		proveedores=query.getResultList();
		
		return proveedores;
	}
	
	public List<Proveedor> findByRUC(Long ruc) throws Exception
	{
		List<Proveedor> proveedores = new ArrayList<>();
		
		TypedQuery<Proveedor> query = em.createQuery("FROM Proveedor p WHERE p.ruc LIKE ?1",Proveedor.class);
		query.setParameter(1,ruc+"%");
		proveedores=query.getResultList();
		
		return proveedores;
	}
}
