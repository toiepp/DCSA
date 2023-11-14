package me.mikholsky.practice5.controller;

import me.mikholsky.practice5.domain.entity.Book;
import me.mikholsky.practice5.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController extends AbstractController<Book, BookService> {
    public BookController(BookService service) {
        super(service);
    }
}
