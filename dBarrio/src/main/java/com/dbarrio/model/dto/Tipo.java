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
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * Tipo generated by hbm2java
 */
@Entity
@Table(name = "tipo", catalog = "mercadolocal")
public class Tipo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3076835933996354120L;
	private Integer idtipo;
	private String nombre;
	private Set<Productos> productoses = new HashSet<Productos>(0);
	private Set<Subtipo> subtipos = new HashSet<Subtipo>(0);

	public Tipo() {
	}

	public Tipo(String nombre, Set<Productos> productoses, Set<Subtipo> subtipos) {
		this.nombre = nombre;
		this.productoses = productoses;
		this.subtipos = subtipos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idtipo", unique = true, nullable = false)
	public Integer getIdtipo() {
		return this.idtipo;
	}

	public void setIdtipo(Integer idtipo) {
		this.idtipo = idtipo;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipo")
	public Set<Productos> getProductoses() {
		return this.productoses;
	}

	public void setProductoses(Set<Productos> productoses) {
		this.productoses = productoses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipo")
	@OrderBy("nombre asc")
	public Set<Subtipo> getSubtipos() {
		return this.subtipos;
	}

	public void setSubtipos(Set<Subtipo> subtipos) {
		this.subtipos = subtipos;
	}

}
