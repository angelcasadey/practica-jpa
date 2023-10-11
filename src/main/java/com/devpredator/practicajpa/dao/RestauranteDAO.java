/**
 * 
 */
package com.devpredator.practicajpa.dao;

import java.util.List;

import com.devpredator.practicajpa.entity.Restaurante;


/**
 * @author angel Interface que genera el DAO para las transacciones del CRUD a
 *         la tabla de la Restaurante.
 */
public interface RestauranteDAO {
	
	void guardar(Restaurante restaurante);
	void actualizar(Restaurante restaurante);
	void eliminar(Long id);
	
	List<Restaurante> consultar();

	Restaurante consultarById(Long id);

	
	/*
	 * Metodo que permite consultar con JQPL la disquera a partir de una descripcion.
	 * @param descripcion {@link String} descripcion del restaurante.
	 * @return {@link Restaurante} el restaurante
	 */
	Restaurante consultarByDescripcionJPQL(String descripcion);
	
	
	/*
	 * Metodo que permite consultar con SQL Nativo, el restaurante a partir de una descripcion.
	 * @param descripcion {@link String} descripcion del restaurante
	 * @return {@link Restaurante} el restaurante
	 */
	Restaurante consultarByDescripcionNative(String descripcion);

}
