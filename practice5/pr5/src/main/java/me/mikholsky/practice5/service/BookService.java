package me.mikholsky.practice5.service;

import me.mikholsky.practice5.domain.entity.Book;
import me.mikholsky.practice5.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService extends AbstractService<Book, BookRepository> {
    public BookService(BookRepository repository) {
        super(repository);
    }
}
