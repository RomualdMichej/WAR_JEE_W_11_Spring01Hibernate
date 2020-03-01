package pl.coderslab.Spring01Hibernate.controllerForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Spring01Hibernate.dao.PublisherDao;
import pl.coderslab.Spring01Hibernate.model.Publisher;
import pl.coderslab.Spring01Hibernate.util.ViewHelper;

@Controller
@RequestMapping("/publisherForm")
public class PublisherFormController {

    private final PublisherDao publisherDao;

    @Autowired
    public PublisherFormController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/")
    public String findAllPublishers(Model model) {
        model.addAttribute("publishers", publisherDao.findAll());
        return "publisher/all";
    }

    @GetMapping("/add")
    public String initAddPublisher(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publisher/addAndEdit";
    }

    @PostMapping("/add")
    public String addPublisher(@ModelAttribute Publisher publisher) {
        publisherDao.persist(publisher);
        return "redirect:";
    }

    @GetMapping("/remove")
    public String initRemovePublisher(@RequestParam int toRemoveId, Model model) {
        model.addAttribute("publisher", publisherDao.findById(toRemoveId));
        model.addAttribute("viewHelper", new ViewHelper());
        return "publisher/remove";
    }

    @PostMapping("/remove")
    public String removePublisher(@RequestParam int toRemoveId, @ModelAttribute ViewHelper viewHelper) {
        if(viewHelper.getOption().equals("confirmed")) {
            publisherDao.removeById(toRemoveId);
        }
        return "redirect:";
    }

    @GetMapping("/edit")
    public String initEditBook(@RequestParam int toEditId, Model model) {
        model.addAttribute("publisher", publisherDao.findById(toEditId));
        return "publisher/addAndEdit";
    }

    @PostMapping("/edit")
    public String editBook(@ModelAttribute Publisher publisher) {
        publisherDao.merge(publisher);
        return "redirect:";
    }

}
