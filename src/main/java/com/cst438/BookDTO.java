package com.cst438;

public class BookDTO {

	public int book_id;
	public String titlel;
	public String author;
	public Integer checkout_patron_id;
	public String checkout_date;
	
	@Override
	public String toString() {
		return "BookDTO [book_id=" + book_id + ", titlel=" + titlel + ", author=" + author + ", checkout_patron_id="
				+ checkout_patron_id + ", checkout_date=" + checkout_date + "]";
	}
}
