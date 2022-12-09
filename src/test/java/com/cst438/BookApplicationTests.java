package com.cst438;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = { Controller.class })
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest

class JunitTestBook {

	static final String URL = "http://localhost:3306";
	
	// Book attributes
	public static final int BOOK_ID = 1001;
	public static final String BOOK_TITLE = "The Hunger Game";
	public static final String BOOK_AUTHOR = "Suzanne Collins";
	public static final Integer BOOK_CHECKOUT_ID = 47200;
	public static final String BOOK_CHECKOUT_DATE = "12-20-2022";

}