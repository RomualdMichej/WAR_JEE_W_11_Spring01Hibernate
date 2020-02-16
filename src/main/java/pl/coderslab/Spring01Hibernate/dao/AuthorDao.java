package pl.coderslab.Spring01Hibernate.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Spring01Hibernate.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Author author) {
        entityManager.persist(author);
    }

    public Author merge(Author author) {
        return entityManager.merge(author);
    }

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }

    public void removeById(long id) {
        Author author = findById(id);
        author = entityManager.contains(author) ? author : entityManager.merge(author);
        entityManager.remove(author);
    }

}
