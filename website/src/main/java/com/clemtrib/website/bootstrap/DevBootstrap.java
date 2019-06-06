package com.clemtrib.website.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.clemtrib.website.model.Author;
import com.clemtrib.website.model.Book;
import com.clemtrib.website.model.Publisher;
import com.clemtrib.website.repositories.AuthorRepository;
import com.clemtrib.website.repositories.BookRepository;
import com.clemtrib.website.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	public void initData() {
		
		final Publisher publisher = new Publisher("Harper Collins", "Albertville, France");
		
		publisherRepository.save(publisher);

		final Author author1 = new Author("Clement", "Tribouillard");
		final Book book1 = new Book("Les imposteurs", "4376", publisher);
		author1.getBooks().add(book1);
		book1.getAuthors().add(author1);
		
		authorRepository.save(author1);
		bookRepository.save(book1);
		final Author author2 = new Author("Louis", "Antoine");
		final Book book2 = new Book("Mile End", "4377", publisher);
		
		author2.getBooks().add(book2);
		book2.getAuthors().add(author2);
		
		authorRepository.save(author2);
		bookRepository.save(book2);

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
		
	}

}
