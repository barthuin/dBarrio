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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * Subtipo generated by hbm2java
 */
@Entity
@Table(name = "subtipo", catalog = "mercadolocal")
public class Subtipo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3219738768879247523L;
	private Integer idsubtipo;
	private Tipo tipo;
	private String nombre;
	private Set<Productos> productoses = new HashSet<Productos>(0);
	private Set<Tallas> tallases = new HashSet<Tallas>(0);
	private Set<Tipoproducto> tipoproductos = new HashSet<Tipoproducto>(0);

	public Subtipo() {
	}

	public Subtipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Subtipo(Tipo tipo, String nombre, Set<Productos> productoses, Set<Tallas> tallases, Set<Tipoproducto> tipoproductos) {
		this.tipo = tipo;
		this.nombre = nombre;
		this.productoses = productoses;
		this.tallases = tallases;
		this.tipoproductos = tipoproductos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idsubtipo", unique = true, nullable = false)
	public Integer getIdsubtipo() {
		return this.idsubtipo;
	}

	public void setIdsubtipo(Integer idsubtipo) {
		this.idsubtipo = idsubtipo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtipo", nullable = false)
	public Tipo getTipo() {
		return this.tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subtipo")
	public Set<Productos> getProductoses() {
		return this.productoses;
	}

	public void setProductoses(Set<Productos> productoses) {
		this.productoses = productoses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subtipo")
	public Set<Tallas> getTallases() {
		return this.tallases;
	}

	public void setTallases(Set<Tallas> tallases) {
		this.tallases = tallases;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "subtipo_has_tipoproducto", catalog = "mercadolocal", joinColumns = {
			@JoinColumn(name = "idsubtipo", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "idtipoproducto", nullable = false, updatable = false) })
	@OrderBy("nombre asc")
	public Set<Tipoproducto> getTipoproductos() {
		return this.tipoproductos;
	}

	public void setTipoproductos(Set<Tipoproducto> tipoproductos) {
		this.tipoproductos = tipoproductos;
	}

}
