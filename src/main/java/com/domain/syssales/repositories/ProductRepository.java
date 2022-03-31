package com.domain.syssales.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.domain.syssales.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findBynameIgnoreCase(String name);
	@Query("select p from Product p WHERE lower (p.name) like %?1%")
	List<Product> searchByName(String value);
	List<Product> findByNameContainingIgnoreCase(String name);
	List<Product> findByDescriptionContainingIgnoreCase(String description);
	
}
