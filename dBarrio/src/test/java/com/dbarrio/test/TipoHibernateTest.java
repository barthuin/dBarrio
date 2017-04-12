package com.dbarrio.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dbarrio.model.dao.DaoGenerico;
import com.dbarrio.model.dao.TipoDao;
import com.dbarrio.model.dto.Subtipo;
import com.dbarrio.model.dto.Tipo;
import com.dbarrio.model.dto.Tipoproducto;


public class TipoHibernateTest {
	
	DaoGenerico tipoDao;

	@Before
	public void setUp() throws Exception {
		tipoDao = new DaoGenerico();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void obtenerTipoPorId() {
		Tipo tipo =	(Tipo) tipoDao.findById(Tipo.class.getName(), 1);
		System.out.println("Metodo obtenerTipoPorId");
		if (tipo != null){
			System.out.println("Tipo: "+tipo.getNombre());
			List<Subtipo> subtipos = new ArrayList<Subtipo>(tipo.getSubtipos());
			if(subtipos.size() > 0){
				for (int j = 0 ; j < subtipos.size() ; j++){
					Subtipo subtipo = subtipos.get(j);
					System.out.println("->"+subtipo.getNombre());
					System.out.println("Sus subtipos-productos son");
					List<Tipoproducto> subtipoproductos = new ArrayList<Tipoproducto>(subtipo.getTipoproductos());
					if(subtipoproductos.size() > 0){
						for (int k = 0 ; k < subtipoproductos.size() ; k++){
							Tipoproducto subtipoproducto = subtipoproductos.get(k);
							System.out.println(subtipoproducto.getNombre());
						}
					}
				}
			}
		}
		
	}
	
	@Test
	public void obtenerTipoPorNombre() {
		System.out.println("Metodo obtenerTipoPorNombre");
		Tipo tipo = new Tipo();
		tipo.setNombre("prueba");
		List tipos = tipoDao.findByExample(Tipo.class.getName(), tipo);
		if(tipos.size() > 0){
			for(int i = 0 ; i< tipos.size() ; i++){
				tipo = (Tipo) tipos.get(i);
				System.out.println("Tipo: "+tipo.getNombre());
			}
		}
		else{
			System.out.println("No hay ningún juego con el nombre seleccionado");
		}
	}
	
	@Test
	public void obtenerListaTipo() {
		System.out.println("Metodo obtenerListaTipo");
		Tipo Tipo = new Tipo();
		List tipos = tipoDao.findByExample(Tipo.class.getName(), Tipo);
		for(int i = 0 ; i< tipos.size() ; i++){
			Tipo = (Tipo) tipos.get(i);
			System.out.println("Tipo: "+Tipo.getNombre());
		}
		
	}
	
	@Test
	public void obtenerListaSubtipoPorTipo() {
		System.out.println("Metodo obtenerListaSubtipoPorTipo");
		Tipo tipo = new Tipo();
		List tipos = tipoDao.findByExample(Tipo.class.getName(), tipo);
		for(int i = 0 ; i< tipos.size() ; i++){
			tipo = (Tipo) tipos.get(i);
			System.out.println("Tipo: "+tipo.getNombre());
			System.out.println("Sus subtipos son");
			List<Subtipo> subtipos = new ArrayList<Subtipo>(tipo.getSubtipos());
			if(subtipos.size() > 0){
				for (int j = 0 ; j < subtipos.size() ; j++){
					Subtipo subtipo = subtipos.get(j);
					System.out.println(subtipo.getNombre());
					System.out.println("Sus subtipos-productos son");
					List<Tipoproducto> subtipoproductos = new ArrayList<Tipoproducto>(subtipo.getTipoproductos());
					if(subtipoproductos.size() > 0){
						for (int k = 0 ; k < subtipoproductos.size() ; k++){
							Tipoproducto subtipoproducto = subtipoproductos.get(k);
							System.out.println(subtipoproducto.getNombre());
						}
					}
				}
			}
			else System.out.println("No hay subtipos para la tipo "+tipo.getNombre());
		}
		
	}
}
