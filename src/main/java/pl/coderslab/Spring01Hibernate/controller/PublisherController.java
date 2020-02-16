package pl.coderslab.Spring01Hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Spring01Hibernate.dao.PublisherDao;
import pl.coderslab.Spring01Hibernate.model.Publisher;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherDao publisherDao;

    @Autowired
    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/findById/{id}")
    @ResponseBody
    public String findById(@PathVariable("id") long id) {
        Publisher publisher = publisherDao.findById(id);
        return "Znaleziono wydawce o id: " + publisher.getId();
    }

    @GetMapping("/persist")
    @ResponseBody
    public String persist() {
        Publisher publisher = new Publisher();
        publisher.setName("Zielona szkola");
        publisherDao.persist(publisher);
        return "Zapisano wydawce";
    }

    @GetMapping("/merge")
    @ResponseBody
    public String merge() {
        Publisher publisher = publisherDao.findById(1L);
        publisher.setName("Zielona nowa szkoła");
        publisherDao.merge(publisher);
        return "Zaktualizowano wydawce o id 1";
    }

    @GetMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable("id") long id) {
        publisherDao.removeById(id);
        return "Usunieto wydawce";
    }

}
