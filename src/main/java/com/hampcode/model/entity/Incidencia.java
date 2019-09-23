package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="incidencias")
public class Incidencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@ManyToOne
	@JoinColumn(name="proveedor_id", nullable=false)
	private Proveedor proveedor; 
	
	@Column(name="fecha_llegada", nullable=false)
	private String fechaLlegada;
	
	@Column(name="gravedad",nullable=false)
	private String gravedad; 
	
	@Column(name="observaciones",nullable=false)
	private String observaciones;
	
	
}
