package com.devpredator.practicajpa.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.devpredator.practicajpa.dao.impl.RestauranteDAOImpl;
import com.devpredator.practicajpa.entity.Restaurante;




class RestauranteDAOTest {

	private RestauranteDAOImpl restauranteDAO = new RestauranteDAOImpl();

	/**
	 * Test method for
	 * {@link persistenceDevPredator.dao.impl.RestauranteDAOImpl#guardar(persistenceDevPredator.entity.Restaurante)}.
	 */
	@Test
	void testGuardar() {
		Restaurante restaurante = new Restaurante();
		restaurante.setNombre("Carnitas Chabelo");
		restaurante.setImagen("chabelo.png");
		restaurante.setSlogan("Chabelo nació para hacer carnitas");
		restaurante.setIdTipoRestaurante(1L);
		restaurante.setFechaCreacion(LocalDateTime.now());
		restaurante.setEstatus(true);

		this.restauranteDAO.guardar(restaurante);
	}
	
	@Test
	void testActualizar() {
		Restaurante restauranteConsultado = this.restauranteDAO.consultarById(14L);
		restauranteConsultado.setNombre("El Cardenal");
		this.restauranteDAO.actualizar(restauranteConsultado);
	}
	
	@Test
	void testEliminar() {
		Long id = 14L;
		
		this.restauranteDAO.eliminar(id);
	}
	
	
	@Test
	void testConsultarById() {
		Restaurante restaurante = this.restauranteDAO.consultarById(15L);
		assertNotNull(restaurante);
		System.out.println("Restaurante: " + restaurante.getNombre());
	}
}
