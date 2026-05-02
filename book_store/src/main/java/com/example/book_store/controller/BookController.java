package com.example.book_store.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.book_store.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.book_store.models.BookModel; 
@Controller
public class BookController {

	@GetMapping("/book")
	public String Book(Model model) {
	    model.addAttribute("message", "Enter Your Book Details");
	    return "book-form";
	}
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/save-product")
	public String Product(BookModel bookData,Model model) {
	    
	    BookModel n = new BookModel();
	    n.setTitle(bookData.getTitle());
	    n.setAuthor(bookData.getAuthor());    
	    n.setPrice(bookData.getPrice()); 
	    bookRepository.save(n);
	    
	    model.addAttribute("message", "The book " + bookData.getTitle() +" is saved successfully");
	    return "book-form"; 
	} 
	
	@GetMapping("/books")
	public String showBooks(Model model) {
		 Iterable<BookModel> bookList = bookRepository.findAll();
	    model.addAttribute("books", bookList);
	    return "book-list";
	}

}