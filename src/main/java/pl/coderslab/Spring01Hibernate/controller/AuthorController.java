package pl.coderslab.Spring01Hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Spring01Hibernate.dao.AuthorDao;
import pl.coderslab.Spring01Hibernate.model.Author;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDao authorDao;

    @Autowired
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/findById/{id}")
    @ResponseBody
    public String findById(@PathVariable("id") long id) {
        Author author = authorDao.findById(id);
        return "Znaleziono autora o id: " + author.getId();
    }

    @GetMapping("/persist")
    @ResponseBody
    public String persist() {
        Author author = new Author();
        author.setFirstName("Marek");
        author.setLastName("Nowak");
        authorDao.persist(author);
        return "Zapisano autora";
    }

    @GetMapping("/merge")
    @ResponseBody
    public String merge() {
        Author author = authorDao.findById(1L);
        author.setFirstName("Adam");
        authorDao.merge(author);
        return "Zaktualizowano autora o id 1";
    }

    @GetMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable("id") long id) {
        authorDao.removeById(id);
        return "Usunieto autora";
    }

}
