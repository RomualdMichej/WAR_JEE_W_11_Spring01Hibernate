package pl.coderslab.Spring01Hibernate.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Spring01Hibernate.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Person person) {
        entityManager.persist(person);
    }

    public Person merge(Person person) {
        return entityManager.merge(person);
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public void removeById(long id) {
        Person person = findById(id);
        person = entityManager.contains(person) ? person : entityManager.merge(person);
        entityManager.remove(person);
    }

}
