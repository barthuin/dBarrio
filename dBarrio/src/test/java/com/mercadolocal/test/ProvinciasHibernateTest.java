package com.mercadolocal.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dbarrio.model.dao.DaoGenerico;
import com.dbarrio.model.dao.ProvinciasDao;
import com.dbarrio.model.dto.Municipios;
import com.dbarrio.model.dto.Provincias;


public class ProvinciasHibernateTest {
	
	DaoGenerico daoGenerico;

	@Before
	public void setUp() throws Exception {
		daoGenerico = new DaoGenerico();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void obtenerProvinciasPorId() {
		Provincias provincia =	(Provincias) daoGenerico.findById(Provincias.class.getName(),1);
		System.out.println("Metodo obtenerProvinciasPorId");
		if (provincia != null){
			System.out.println("Provincia: "+provincia.getProvincia());
		}
		
	}
	
	@Test
	public void obtenerProvinciasPorNombre() {
		System.out.println("Metodo obtenerProvinciasPorNombre");
		Provincias provincia = new Provincias();
		provincia.setProvincia("Coruña, A");
		List provincias = daoGenerico.findByExample(Provincias.class.getName(),provincia);
		if(provincias.size() > 0){
			for(int i = 0 ; i< provincias.size() ; i++){
				provincia = (Provincias) provincias.get(i);
				System.out.println("Provincias: "+provincia.getProvincia());
				Set<Municipios> municipios = provincia.getMunicipioses();
				for (Iterator iterator = municipios.iterator(); iterator.hasNext();) {
					Municipios municipio = (Municipios) iterator.next();
					System.out.println(municipio.getNombre());
				}
			}
		}
		else{
			System.out.println("No hay ningún juego con el nombre seleccionado");
		}
	}
	
	/*@Test
	public void obtenerListaProvincias() {
		System.out.println("Metodo obtenerListaProvincias");
		Provincias Provincias = new Provincias();
		List provincias = provinciasHome.findByExample(Provincias);
		for(int i = 0 ; i< provincias.size() ; i++){
			Provincias = (Provincias) provincias.get(i);
			System.out.println("Provincias: "+Provincias.getProvincia());
		}
		
	}
	
	@Test
	public void obtenerListaMunicipiosPorProvincias() {
		System.out.println("Metodo obtenerListaMunicipiosPorProvincias");
		Provincias provincia = new Provincias();
		List provincias = provinciasHome.findByExample(provincia);
		for(int i = 0 ; i< provincias.size() ; i++){
			provincia = (Provincias) provincias.get(i);
			System.out.println("Provincia: "+provincia.getProvincia());
			System.out.println("Sus municipios son");
			List<Municipios> municipios = new ArrayList<Municipios>(provincia.getMunicipioses());
			if(municipios.size() > 0){
				for (int j = 0 ; j < municipios.size() ; j++){
					Municipios municipio = municipios.get(j);
					System.out.println(municipio.getNombre());
				}
			}
			else System.out.println("No hay municipios para la provincia "+provincia.getProvincia());
		}
		
	}
	
/*	@Test
	public void insertarProvincias() {
		System.out.println("Metodo insertarProvincias");
		Provincias Provincias = new Provincias();
		Provincias.setProvincia("prueba");
		provinciasHome.attachDirty(Provincias);
	}
	
	@Test
	public void actualizarProvincias() {
		System.out.println("Metodo actualizarProvincias");
		Provincias Provincias = new Provincias();
		Provincias.setProvincia("prueba");
		List provincias = provinciasHome.findByExample(Provincias);
		if(provincias.size() > 0){
			for(int i = 0 ; i< provincias.size() ; i++){
				Provincias = (Provincias) provincias.get(i);
				Provincias.setProvincia("dani");
				provinciasHome.attachDirty(Provincias);
			}
		}
	}
	
	@Test
	public void eliminarProvincias() {
		System.out.println("Metodo eliminarProvincias");
		Provincias Provincias = new Provincias();
		Provincias.setProvincia("dani");
		List provincias = provinciasHome.findByExample(Provincias);
		if(provincias.size() > 0){
			for(int i = 0 ; i< provincias.size() ; i++){
				Provincias = (Provincias) provincias.get(i);
				provinciasHome.delete(Provincias);
			}
		}
	}
*/
}
