package me.mikholsky.practice5.domain.repository;

import me.mikholsky.practice5.domain.entity.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CommonRepository<Book> {
}
