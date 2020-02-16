package pl.coderslab.Spring01Hibernate.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Spring01Hibernate.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Book book) {
        entityManager.persist(book);
    }

    public Book merge(Book book) {
        return entityManager.merge(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void removeById(long id) {
        Book book = findById(id);
        book = entityManager.contains(book) ? book : entityManager.merge(book);
        entityManager.remove(book);
    }

}
