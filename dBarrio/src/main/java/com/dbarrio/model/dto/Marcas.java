package com.dbarrio.model.dto;
// Generated 17-ene-2017 20:27:04 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Marcas generated by hbm2java
 */
@Entity
@Table(name = "marcas", catalog = "mercadolocal")
public class Marcas implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1079451712050496295L;
	private Integer idmarcas;
	private String nombre;
	private Set<Ropa> ropas = new HashSet<Ropa>(0);

	public Marcas() {
	}

	public Marcas(String nombre, Set<Ropa> ropas) {
		this.nombre = nombre;
		this.ropas = ropas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idmarcas", unique = true, nullable = false)
	public Integer getIdmarcas() {
		return this.idmarcas;
	}

	public void setIdmarcas(Integer idmarcas) {
		this.idmarcas = idmarcas;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "marcas")
	public Set<Ropa> getRopas() {
		return this.ropas;
	}

	public void setRopas(Set<Ropa> ropas) {
		this.ropas = ropas;
	}

}