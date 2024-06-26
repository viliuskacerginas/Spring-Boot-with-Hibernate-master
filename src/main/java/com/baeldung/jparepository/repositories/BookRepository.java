package com.baeldung.jparepository.repositories;

import com.baeldung.jparepository.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Modifying
    @Transactional
    @Query("insert into Book b (b.name) values (:#{#book.name})")
    void insertEntity(@Param("book") Book book);

    @Query("select b from Book b")
    List<Book> findAllEntities();
}
