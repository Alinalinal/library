package com.alinab.springcourse.dao;

import com.alinab.springcourse.models.Book;
import com.alinab.springcourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book (person_id, title, author, year) VALUES (null, ?, ?, ?)",
                book.getTitle(), book.getAuthor(), book.getYear());
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET title=?, author=?, year=? WHERE id=?", updatedBook.getTitle(),
                updatedBook.getAuthor(), updatedBook.getYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }

    public Optional<Person> getBookOwner(int id) {
        return jdbcTemplate.query("SELECT Person.* FROM Person JOIN Book " +
                        "ON Person.id = Book.person_id WHERE Book.id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public void appoint(int bookId, int personId) {
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?", personId, bookId );
    }

    public void release(int id) {
        jdbcTemplate.update("UPDATE Book SET person_id=null WHERE id=?", id);
    }
}
