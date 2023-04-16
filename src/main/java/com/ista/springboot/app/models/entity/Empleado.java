package com.ista.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="empleado")
public class Empleado implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private double costo_hora;
	private String designacion;
	private double horas_laboradas;
	private double salario;
	
	@Column(name= "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	
	@PrePersist
	public void prePersist() {
		
		createAt = new Date();
	}
	
	private static final long serialVersionUID = 3283444068336136587L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCosto_hora() {
		return costo_hora;
	}

	public void setCosto_hora(double costo_hora) {
		this.costo_hora = costo_hora;
	}

	public String getDesignacion() {
		return designacion;
	}

	public void setDesignacion(String designacion) {
		this.designacion = designacion;
	}

	public double getHoras_laboradas() {
		return horas_laboradas;
	}

	public void setHoras_laboradas(double horas_laboradas) {
		this.horas_laboradas = horas_laboradas;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
}
