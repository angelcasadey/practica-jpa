/**
 * 
 */
package com.devpredator.practicajpa.dao.impl;

import java.util.List;

import com.devpredator.practicajpa.dao.RestauranteDAO;
import com.devpredator.practicajpa.entity.Restaurante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * @author angel
 */
public class RestauranteDAOImpl implements RestauranteDAO {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceDevPredator");

	@Override
	public void guardar(Restaurante restaurante) {

		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();

		try {
			em.persist(restaurante);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.clear();
		}

	}

	@Override
	public void actualizar(Restaurante restaurante) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();

		try {
			em.merge(restaurante);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.clear();
		}

	}

	@Override
	public void eliminar(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		Restaurante restauranteConsultado = em.find(Restaurante.class, id);

		EntityTransaction et = em.getTransaction();
		et.begin();

		try {
			em.remove(restauranteConsultado);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.clear();
		}

	}

	@Override
	public List<Restaurante> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurante consultarById(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		Restaurante restauranteConsultado = em.find(Restaurante.class, id);
		if (restauranteConsultado == null) {
			System.out.println("El Restaurante con id " + id + " no se encontro");
			throw new EntityNotFoundException("El Restaurante con id " + id + " no se encontro");
		}
		return restauranteConsultado;
	}

	@Override
	public Restaurante consultarByDescripcionJPQL(String descripcion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurante consultarByDescripcionNative(String descripcion) {
		// TODO Auto-generated method stub
		return null;
	}

}
