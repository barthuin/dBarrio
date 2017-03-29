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
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "mercadolocal")
public class Usuario implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idusuario;
	private Municipios municipios;
	private Provincias provincias;
	private String login;
	private String password;
	private int tipoUsuario;
	private String nombre;
	private String apellidos;
	private String dni;
	private String email;
	private String direccion;
	private Integer codigoPostal;
	private Integer telefono;
	private String latitud;
	private String longitud;
	private Set<Productos> productoses = new HashSet<Productos>(0);
	private Set<Chat> chatsForUsuarioReceptor = new HashSet<Chat>(0);
	private Set<Chat> chatsForUsuarioEnvio = new HashSet<Chat>(0);
	private Set<Pedido> pedidos = new HashSet<Pedido>(0);
	private Set<Recomendaciones> recomendacionesesForIdUsuarioEnvio = new HashSet<Recomendaciones>(0);
	private Set<Recomendaciones> recomendacionesesForIdUsuarioReceptor = new HashSet<Recomendaciones>(0);

	public Usuario() {
	}

	public Usuario(String login, String password, int tipoUsuario, String nombre, String apellidos, String dni,
			String email) {
		this.login = login;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email = email;
	}

	public Usuario(Municipios municipios, Provincias provincias, String login, String password, int tipoUsuario,
			String nombre, String apellidos, String dni, String email, String direccion, Integer codigoPostal,
			Integer telefono, String latitud, String longitud, Set<Productos> productoses, Set<Chat> chatsForUsuarioReceptor,
			Set<Chat> chatsForUsuarioEnvio, Set<Pedido> pedidos) {
		this.municipios = municipios;
		this.provincias = provincias;
		this.login = login;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email = email;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.telefono = telefono;
		this.latitud = latitud;
		this.longitud = longitud;
		this.productoses = productoses;
		this.chatsForUsuarioReceptor = chatsForUsuarioReceptor;
		this.chatsForUsuarioEnvio = chatsForUsuarioEnvio;
		this.pedidos = pedidos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idusuario", unique = true, nullable = false)
	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ciudad")
	public Municipios getMunicipios() {
		return this.municipios;
	}

	public void setMunicipios(Municipios municipios) {
		this.municipios = municipios;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "provincia")
	public Provincias getProvincias() {
		return this.provincias;
	}

	public void setProvincias(Provincias provincias) {
		this.provincias = provincias;
	}

	@Column(name = "login", nullable = false, length = 45)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "tipoUsuario", nullable = false)
	public int getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellidos", nullable = false, length = 45)
	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Column(name = "dni", nullable = false, length = 9)
	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Column(name = "email", nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "direccion")
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "codigo_postal")
	public Integer getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Column(name = "telefono")
	public Integer getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	@Column(name = "latitud", length = 45)
	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	@Column(name = "longitud", length = 45)
	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Productos> getProductoses() {
		return this.productoses;
	}

	public void setProductoses(Set<Productos> productoses) {
		this.productoses = productoses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioByUsuarioReceptor")
	public Set<Chat> getChatsForUsuarioReceptor() {
		return this.chatsForUsuarioReceptor;
	}

	public void setChatsForUsuarioReceptor(Set<Chat> chatsForUsuarioReceptor) {
		this.chatsForUsuarioReceptor = chatsForUsuarioReceptor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioByUsuarioEnvio")
	public Set<Chat> getChatsForUsuarioEnvio() {
		return this.chatsForUsuarioEnvio;
	}

	public void setChatsForUsuarioEnvio(Set<Chat> chatsForUsuarioEnvio) {
		this.chatsForUsuarioEnvio = chatsForUsuarioEnvio;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioByIdUsuarioEnvio")
	public Set<Recomendaciones> getRecomendacionesesForIdUsuarioEnvio() {
		return this.recomendacionesesForIdUsuarioEnvio;
	}

	public void setRecomendacionesesForIdUsuarioEnvio(Set<Recomendaciones> recomendacionesesForIdUsuarioEnvio) {
		this.recomendacionesesForIdUsuarioEnvio = recomendacionesesForIdUsuarioEnvio;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioByIdUsuarioReceptor")
	public Set<Recomendaciones> getRecomendacionesesForIdUsuarioReceptor() {
		return this.recomendacionesesForIdUsuarioReceptor;
	}

	public void setRecomendacionesesForIdUsuarioReceptor(Set<Recomendaciones> recomendacionesesForIdUsuarioReceptor) {
		this.recomendacionesesForIdUsuarioReceptor = recomendacionesesForIdUsuarioReceptor;
	}
	
	

}