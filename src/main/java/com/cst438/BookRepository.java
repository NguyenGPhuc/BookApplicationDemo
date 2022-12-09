package com.cst438;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends CrudRepository <Book, Integer> {
	
	Book findById(int book_id);
	
	@Query("select a from Book a where a.checkout_patron_id = :checkout_patron_id")
	List<Book> findByPatronId(@Param("checkout_patron_id") Integer checkout_patron_id);

}