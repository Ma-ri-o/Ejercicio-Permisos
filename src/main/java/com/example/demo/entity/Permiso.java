package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "permiso")
public class Permiso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NOMBREEMPLEADO")
	@NonNull
	private String nombreEmpleado;
	
	@Column(name = "APELLIDOSEMPLEADO")
	@NonNull
	private String apellidosEmpleado;
	
	@Column(name = "TIPOPERMISO")
	@NonNull
	private int tipoPermiso;

	@Column(name = "FECHAPERMISO")
	@Temporal(TemporalType.DATE)
	private Date fechaPermiso;
	
	@NonNull
	private Long idd;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_tipo", referencedColumnName = "idd")
	private List<TipoPermiso> permiso = new ArrayList<>();

	
	  
	public Long getIdd() {
		return idd;
	}

	public void setIdd(Long idd) {
		this.idd = idd;
	}

	public List<TipoPermiso> getPermiso() {
		return permiso;
	}

	public void setPermiso(List<TipoPermiso> permiso) {
		this.permiso = permiso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getApellidosEmpleado() {
		return apellidosEmpleado;
	}

	public void setApellidosEmpleado(String apellidosEmpleado) {
		this.apellidosEmpleado = apellidosEmpleado;
	}

	public int getTipoPermiso() {
		return tipoPermiso;
	}

	public void setTipoPermiso(int tipoPermiso) {
		this.tipoPermiso = tipoPermiso;
	}

	public Date getFechaPermiso() {
		return fechaPermiso;
	}

	public void setFechaPermiso(Date fechaPermiso) {
		this.fechaPermiso = fechaPermiso;
	}

}
