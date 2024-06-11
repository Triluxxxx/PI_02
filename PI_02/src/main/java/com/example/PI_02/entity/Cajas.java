package com.example.PI_02.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cajas")
@SQLDelete(sql = "UPDATE cajas SET estado = 0 WHERE id = ?")
@Where(clause = "estado = 1")
public class Cajas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime fechaApertura;
	private LocalDateTime fechaCierre;
	@Column(nullable = false)
	private Integer estado = 1;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(LocalDateTime fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	public LocalDateTime getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(LocalDateTime fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}	

}
