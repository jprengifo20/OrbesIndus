package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Proveedor;
import com.hampcode.model.repository.ProveedorRepository;

@Named
public class ProveedorBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProveedorRepository proveedorRepository;
	private Long id;
	
	@Transactional
	public Long insert (Proveedor proveedor)throws Exception
	{
		return proveedorRepository.insert(proveedor);
	}
	
	@Transactional
	public Long update (Proveedor proveedor) throws Exception
	{
		return proveedorRepository.update(proveedor);
	}
	
	public List<Proveedor> getAll() throws Exception 
	{
		return proveedorRepository.findAll();
	}
	
	public List<Proveedor> getProveedorByEmpresa (String empresa) throws Exception
	{
		return proveedorRepository.findByEmpresa(empresa);
	}
	
	public List<Proveedor> getProveedorById (Long id) throws Exception
	{
		return proveedorRepository.findById(id);
	}
}
