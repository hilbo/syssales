package com.domain.syssales.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.domain.syssales.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	List<Category> findBynameIgnoreCase(String name);
	@Query("select c from Category c WHERE lower (c.name) like %?1%")
	List<Category> searchByName(String value);
	List<Category> findByNameContainingIgnoreCase(String name);
	//List<Category> findByDescriptionContainingIgnoreCase(String description);
	
}
