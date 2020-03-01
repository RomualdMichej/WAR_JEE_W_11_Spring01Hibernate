package pl.coderslab.Spring01Hibernate.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Spring01Hibernate.model.Author;
import pl.coderslab.Spring01Hibernate.model.Book;
import pl.coderslab.Spring01Hibernate.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

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

    public List<Book> findAllPropositions() {
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.proposition = true");
        return query.getResultList();
    }

    public List<Book> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        return query.getResultList();
    }

    public List<Book> getRatingList(int rating) {
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.rating = :givenRating");
        query.setParameter("givenRating", rating);
        return query.getResultList();
    }

    public List<Book> findAllWithPublisher() {
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher is not null");
        return query.getResultList();
    }

    public List<Book> findAllWithPublisher(Publisher publisher) {
        Query query = entityManager.createQuery("SELECT b FROM Book b where b.publisher = :publisher");
        query.setParameter("publisher", publisher);
        return query.getResultList();
    }

    public List<Book> findAllWithAuthor(Author author) {
        Query query = entityManager.createQuery("SELECT b FROM Book b inner join Author a on a.id = :authorId");
        query.setParameter("authorId", author.getId());
        return query.getResultList();
    }

}
