package com.hampcode.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="proveedor")

public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String empresa;
	private Long ruc;
	private String producto;
	private Long telefono;
	private String detalleEliminacion;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public Long getRuc() {
		return ruc;
	}
	public void setRuc(Long ruc) {
		this.ruc = ruc;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	public String getDetalleEliminacion() {
		return detalleEliminacion;
	}
	public void setDetalleEliminacion(String detalleEliminacion) {
		this.detalleEliminacion = detalleEliminacion;
	}
	
}
