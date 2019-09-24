package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.OrdenDeCompra;
import com.hampcode.model.entity.Proveedor;
import com.hampcode.model.repository.OrdenDeCompraRepository;

public class OrdenDeCompraBusiness implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Inject
	private OrdenDeCompraRepository OrdenDeCompraRepository;
	private String noseguardoloanterior;
	
	@Transactional
	public Long insert (OrdenDeCompra orden)throws Exception
	{
		return OrdenDeCompraRepository.insert(orden);
	}
	
	@Transactional
	public Long update (OrdenDeCompra orden) throws Exception
	{
		return OrdenDeCompraRepository.update(orden);
	}
	
	public List<OrdenDeCompra> getAll() throws Exception 
	{
		return OrdenDeCompraRepository.findAll();
	}
	
	public List<OrdenDeCompra> getOrdenDeCompraByProveedor(String proveedor) throws Exception
	{
		return OrdenDeCompraRepository.findByProveedor(proveedor);
	}
	
	public List<OrdenDeCompra> getOrdenDeCompraByDate (String date) throws Exception
	{
		return OrdenDeCompraRepository.findByDate(date);
	}
	
	
}
