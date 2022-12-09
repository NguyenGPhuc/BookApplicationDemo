package com.cst438;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.transaction.Transactional;

@RestController
public class Controller {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	PatronRepository patronRepository;
	
	// Check if a book is checked out by a patron. Return status if patron has fine or not.
	@Transactional
	@PutMapping("/book/{book_id}/checkout/{patron_id}")
	public int checkout (@PathVariable("patron_id") int patron_id, @PathVariable("book_id") int book_id) {
		
		Book op = bookRepository.findById(book_id);
		if (op == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book ID: " + book_id + " not found");
		}else {
			Patron pa = patronRepository.findById(patron_id);
			if (pa == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patron ID: " + patron_id + " not found");
			}
			else {
				if (pa.getFines() != 0) {
					return -3;
				}
				else {
					op.setCheckout_patron_id(pa.getPatron_id());
					bookRepository.save(op);
					return 0;
				}
			}
		}
		
	}

	// Reset return status to 0 when book is returned.
	@Transactional
	@PutMapping("/book/{book_id}/return")
	public int findReturn (@PathVariable("book_id") int book_id) {
		Book op = bookRepository.findById(book_id);
		
		if(op == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book ID: " + book_id + " not found");
		}
		else {
			// If return, reset checkout date and check out patron.
			op.setCheckout_date(null);
			op.setCheckout_patron_id(null);
			bookRepository.save(op);
			return 0;
		}
	}
	
	// Return of list of borrow books by a patron.
	@Transactional
	@GetMapping("/patron/{patron_id}/checkouts")
	public List<Book> checkouts(@PathVariable("patron_id") int patron_id){
		
		Patron pa = patronRepository.findById(patron_id);
		if (pa == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patron ID: " + patron_id + " not found");
		}
		else {
			List<Book> op = bookRepository.findByPatronId(patron_id);
			return op;
		}
		
 	}
	
	
	// Return information about a patron.
	@Transactional
	@GetMapping("/patron/{patron_id}")
	public Patron patronInfo(@PathVariable("patron_id") int patron_id) {
		Patron pa = patronRepository.findById(patron_id);
		if (pa == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patron ID: " + patron_id + " not found");
		}
		else
			return pa;
	}
}
