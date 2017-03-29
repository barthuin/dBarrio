package com.mercadolocal.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dbarrio.model.dao.AlimentacionDao;
import com.dbarrio.model.dao.DaoGenerico;
import com.dbarrio.model.dao.MarcasDao;
import com.dbarrio.model.dao.MunicipiosDao;
import com.dbarrio.model.dao.ProductosDao;
import com.dbarrio.model.dao.ProvinciasDao;
import com.dbarrio.model.dao.RecomendacionesDao;
import com.dbarrio.model.dao.RopaDao;
import com.dbarrio.model.dao.SubtipoDao;
import com.dbarrio.model.dao.TallasDao;
import com.dbarrio.model.dao.TipoDao;
import com.dbarrio.model.dao.TipoproductoDao;
import com.dbarrio.model.dao.UsuarioDao;
import com.dbarrio.model.dto.Alimentacion;
import com.dbarrio.model.dto.Marcas;
import com.dbarrio.model.dto.Municipios;
import com.dbarrio.model.dto.Productos;
import com.dbarrio.model.dto.Recomendaciones;
import com.dbarrio.model.dto.Ropa;
import com.dbarrio.model.dto.Subtipo;
import com.dbarrio.model.dto.Tallas;
import com.dbarrio.model.dto.Tipo;
import com.dbarrio.model.dto.Tipoproducto;
import com.dbarrio.model.dto.Usuario;


public class UsuariosHibernateTest {
	
	DaoGenerico daoGenerico = new DaoGenerico();

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void insertarUsuario(){
		Usuario usuario = new Usuario();
		
		usuario.setNombre("Dani");
		usuario.setApellidos("Rico");
		usuario.setLogin("barthuin");
		usuario.setPassword("barthuin");
		usuario.setDni("32696354Z");
		usuario.setCodigoPostal(15008);
		usuario.setEmail("barthuin@gmail.com");
		usuario.setDireccion("C/Jose Pascual Lopez Cortón 8 2ºF");
		
		Municipios municipio = new Municipios();
		municipio.setNombre("Fene");
		ArrayList listMunicipios = (ArrayList) daoGenerico.findByExample(Municipios.class.getName(), municipio);
		if (listMunicipios != null && !listMunicipios.isEmpty()){
			municipio = (Municipios)listMunicipios.get(0);
			usuario.setMunicipios(municipio);
			usuario.setProvincias(municipio.getProvincias());
		}
		
		usuario.setLatitud("");
		usuario.setLongitud("");
		usuario.setTelefono(981343137);
		usuario.setTipoUsuario(1);

		//usuarioHome.attachDirty(usuario);
	}
	
	@Test
	public void actualizarUsuario(){
		Usuario usuario = new Usuario();
		
		usuario.setLogin("barthuin");
		usuario.setPassword("barthuin");
		usuario.setTipoUsuario(1);
		
		List<Usuario> listUsuario = daoGenerico.findByExample(Usuario.class.getName(), usuario);
		if(listUsuario != null && !listUsuario.isEmpty()){
			usuario = listUsuario.get(0);
		}
	
		usuario.setDireccion("C/Jose Pascual Lopez Cortón 8 2ºF");

		daoGenerico.attachDirty(usuario);
	}
	
	@Test
	public void buscarUsuarioPorId(){
		Usuario usuario = new Usuario();
		
		
		usuario = (Usuario) daoGenerico.findById(Usuario.class.getName(), 1);
	
		System.out.println(usuario.getLogin());
		Set<Recomendaciones> recomendacionesHechas = usuario.getRecomendacionesesForIdUsuarioEnvio();
		for (Iterator iterator = recomendacionesHechas.iterator(); iterator.hasNext();) {
			Recomendaciones recomendacion = (Recomendaciones) iterator.next();
			System.out.println(recomendacion.getPuntuacion()+" "+recomendacion.getMensaje());
		}
	}
	
	@Test
	public void insertarProductosRopa(){
		//tipo = 1
		//subtipo = 1
		//tipoproducto = 76
		//tallas = 284
		//idmarca = 1
		
		Productos producto = new Productos();
		producto.setNombre("Camiseta Adidas");
		producto.setDescripcion("Se vende camiseta Adidas, talla XL");
		producto.setTipo((Tipo) daoGenerico.findById(Tipo.class.getName(), 1));
		producto.setSubtipo((Subtipo) daoGenerico.findById(Subtipo.class.getName(), 1));
		producto.setPrecio(new BigDecimal(12.5));
		producto.setUsuario((Usuario) daoGenerico.findById(Usuario.class.getName(), 1));
		
		
		Ropa ropa = new Ropa();
		ropa.setTipoproducto((Tipoproducto) daoGenerico.findById(Tipoproducto.class.getName(), 76));
		ropa.setMarcas((Marcas) daoGenerico.findById(Marcas.class.getName(),1));
		ropa.setTallas((Tallas) daoGenerico.findById(Tallas.class.getName(), 284));
		ropa.setStock(10);
		
		//productosHome.attachDirty(producto);
		
		ropa.setProductos(producto);
		//ropaHome.attachDirty(ropa);
	}
	
	@Test
	public void insertarProductosAlimentacion(){
		//tipo = 2
		//subtipo = 8
		//tipoproducto = 10
		
		Productos producto = new Productos();
		producto.setNombre("Carne de vacuno");
		producto.setDescripcion("Carne de vacuno 100% galega 1kg");
		producto.setTipo((Tipo) daoGenerico.findById(Tipo.class.getName(), 2));
		producto.setSubtipo((Subtipo) daoGenerico.findById(Subtipo.class.getName(), 8));
		producto.setPrecio(new BigDecimal(12.5));
		producto.setUsuario((Usuario) daoGenerico.findById(Usuario.class.getName(), 1));
		
		
		Alimentacion alimentacion = new Alimentacion();
		alimentacion.setTipoproducto((Tipoproducto) daoGenerico.findById(Tipoproducto.class.getName(), 10));
		alimentacion.setStock(10);
		
		//productosHome.attachDirty(producto);
		
		alimentacion.setProductos(producto);
		//alimentacionHome.attachDirty(alimentacion);
	}
	
	@Test
	public void realizarPedido(){
		
	}
	
	@Test
	public void realizarRecomendacion(){
		Usuario usuario = new Usuario();
		
		Recomendaciones recomendacion = new Recomendaciones();
		recomendacion.setUsuarioByIdUsuarioEnvio(usuario);
		recomendacion.setUsuarioByIdUsuarioReceptor(usuario);
		recomendacion.setFecha(new Date());
		recomendacion.setMensaje("Un buen usuario. Me ha entregado un producto perfecto");
		recomendacion.setPuntuacion(5);
		
		//recomendacionesHome.persist(recomendacion);
	}
}
