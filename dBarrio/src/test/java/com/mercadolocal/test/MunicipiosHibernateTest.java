package com.mercadolocal.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dbarrio.model.dao.DaoGenerico;
import com.dbarrio.model.dto.Municipios;


public class MunicipiosHibernateTest {
	
	DaoGenerico daoGenerico;

	@Before
	public void setUp() throws Exception {
		daoGenerico = new DaoGenerico();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void obtenerMunicipiosPorId() {
		Municipios municipios =	(Municipios) daoGenerico.findById(Municipios.class.getName(),1);
		System.out.println("Metodo obtenerMunicipiosPorId");
		if (municipios != null){
			System.out.println("Provincia: "+municipios.getNombre());
		}
		
	}
	
	@Test
	public void obtenerMunicipiosPorNombre() {
		System.out.println("Metodo obtenerMunicipiosPorNombre");
		Municipios Municipios = new Municipios();
		Municipios.setNombre("prueba");
		List municipioss = daoGenerico.findByExample(Municipios.class.getName(), Municipios);
		if(municipioss.size() > 0){
			for(int i = 0 ; i< municipioss.size() ; i++){
				Municipios = (Municipios) municipioss.get(i);
				System.out.println("Municipios: "+Municipios.getNombre());
			}
		}
		else{
			System.out.println("No hay ningún juego con el nombre seleccionado");
		}
	}
	
	@Test
	public void obtenerListaMunicipios() {
		System.out.println("Metodo obtenerListaMunicipios");
		Municipios Municipios = new Municipios();
		List municipioss = daoGenerico.findByExample(Municipios.class.getName(), Municipios);
		for(int i = 0 ; i< municipioss.size() ; i++){
			Municipios = (Municipios) municipioss.get(i);
			System.out.println("Municipios: "+Municipios.getNombre());
		}
		
	}
	
/*	
	@Test
	public void insertarMunicipios() {
		System.out.println("Metodo insertarMunicipios");
		Municipios municipios = new Municipios();
		municipios.setNombre("prueba");
		municipiosHome.attachDirty(municipios);
	}
	
	@Test
	public void actualizarMunicipios() {
		System.out.println("Metodo actualizarMunicipios");
		Municipios municipios = new Municipios();
		municipios.setNombre("prueba");
		List municipioss = municipiosHome.findByExample(municipios);
		if(municipioss.size() > 0){
			for(int i = 0 ; i< municipioss.size() ; i++){
				municipios = (Municipios) municipioss.get(i);
				municipios.setNombre("dani");
				municipiosHome.attachDirty(municipios);
			}
		}
	}
	
	@Test
	public void eliminarMunicipios() {
		System.out.println("Metodo eliminarMunicipios");
		Municipios Municipios = new Municipios();
		Municipios.setNombre("dani");
		List municipioss = municipiosHome.findByExample(Municipios);
		if(municipioss.size() > 0){
			for(int i = 0 ; i< municipioss.size() ; i++){
				Municipios = (Municipios) municipioss.get(i);
				municipiosHome.delete(Municipios);
			}
		}
	}
*/
}
