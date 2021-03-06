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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tallas generated by hbm2java
 */
@Entity
@Table(name = "tallas", catalog = "mercadolocal")
public class Tallas implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4063625083022524694L;
	private Integer idtallas;
	private Subtipo subtipo;
	private Tipoproducto tipoproducto;
	private String talla;
	private Set<Ropa> ropas = new HashSet<Ropa>(0);

	public Tallas() {
	}

	public Tallas(Subtipo subtipo, Tipoproducto tipoproducto) {
		this.subtipo = subtipo;
		this.tipoproducto = tipoproducto;
	}

	public Tallas(Subtipo subtipo, Tipoproducto tipoproducto, String talla, Set<Ropa> ropas) {
		this.subtipo = subtipo;
		this.tipoproducto = tipoproducto;
		this.talla = talla;
		this.ropas = ropas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idtallas", unique = true, nullable = false)
	public Integer getIdtallas() {
		return this.idtallas;
	}

	public void setIdtallas(Integer idtallas) {
		this.idtallas = idtallas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsubtipo", nullable = false)
	public Subtipo getSubtipo() {
		return this.subtipo;
	}

	public void setSubtipo(Subtipo subtipo) {
		this.subtipo = subtipo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtipoproducto", nullable = false)
	public Tipoproducto getTipoproducto() {
		return this.tipoproducto;
	}

	public void setTipoproducto(Tipoproducto tipoproducto) {
		this.tipoproducto = tipoproducto;
	}

	@Column(name = "talla", length = 5)
	public String getTalla() {
		return this.talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tallas")
	public Set<Ropa> getRopas() {
		return this.ropas;
	}

	public void setRopas(Set<Ropa> ropas) {
		this.ropas = ropas;
	}

}
