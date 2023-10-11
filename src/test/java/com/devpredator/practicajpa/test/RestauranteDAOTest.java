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
	
	/**
	 * Test method for
	 * {@link persistenceDevPredator.dao.impl.RestauranteDAOImpl#actualizar(persistenceDevPredator.entity.Restaurante)}
	 */
	@Test
	void testActualizar() {
		Restaurante restauranteConsultado = this.restauranteDAO.consultarById(15L);
		restauranteConsultado.setNombre("El Cardenal");
		this.restauranteDAO.actualizar(restauranteConsultado);
	}
	
	/**
	 * Test method for
	 * {@link persistenceDevPredator.dao.impl.RestauranteDAOImpl#eliminar(persistenceDevPredator.entity.Restaurante)}
	 */
	@Test
	void testEliminar() {
		Long id = 14L;
		
		this.restauranteDAO.eliminar(id);
	}
	
	/**
	 * Test method for
	 * {@link persistenceDevPredator.dao.impl.RestauranteDAOImpl#consultar(persistenceDevPredator.entity.Restaurante)}
	 */
	@Test
	void testConsultarById() {
		Restaurante restaurante = this.restauranteDAO.consultarById(14L);
		assertNotNull(restaurante);
		System.out.println("Restaurante: " + restaurante.getNombre());
	}
}
