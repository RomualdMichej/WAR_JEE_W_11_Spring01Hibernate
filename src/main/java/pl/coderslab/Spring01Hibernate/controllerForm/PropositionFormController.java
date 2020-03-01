package pl.coderslab.Spring01Hibernate.controllerForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Spring01Hibernate.dao.AuthorDao;
import pl.coderslab.Spring01Hibernate.dao.BookDao;
import pl.coderslab.Spring01Hibernate.dao.PublisherDao;
import pl.coderslab.Spring01Hibernate.model.Author;
import pl.coderslab.Spring01Hibernate.model.Book;
import pl.coderslab.Spring01Hibernate.model.Publisher;
import pl.coderslab.Spring01Hibernate.util.ViewHelper;
import pl.coderslab.Spring01Hibernate.validator.group.PropositionValidationGroup;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/propositionForm")
public class PropositionFormController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    @Autowired
    public PropositionFormController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @ModelAttribute("allPublishers")
    public List<Publisher> allPublishers() {
        return publisherDao.findAll();
    }

    @ModelAttribute("allAuthors")
    public List<Author> allAuthors() {
        return authorDao.findAll();
    }

    @GetMapping("/")
    public String findAllProposition(Model model) {
        model.addAttribute("allPropositions", bookDao.findAllPropositions());
        return "proposition/all";
    }

    @GetMapping("/add")
    public String initAddProposition(Model model) {
        model.addAttribute("proposition", new Book());
        return "proposition/addAndEdit";
    }

    @PostMapping("/add")
    public String addProposition(@ModelAttribute("proposition") @Validated({PropositionValidationGroup.class}) Book proposition, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "proposition/addAndEdit";
        }
        proposition.setProposition(true);
        bookDao.persist(proposition);
        return "redirect:";
    }

    @GetMapping("/edit")
    public String initEditProposition(@RequestParam int toEditId, Model model) {
        model.addAttribute("proposition", bookDao.findById(toEditId));
        return "proposition/addAndEdit";
    }

    @PostMapping("/edit")
    public String editProposition(@ModelAttribute("proposition") @Validated({PropositionValidationGroup.class}) Book proposition, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "proposition/addAndEdit";
        }
        bookDao.merge(proposition);
        return "redirect:";
    }

    @GetMapping("/remove")
    public String initRemoveProposition(@RequestParam int toRemoveId, Model model) {
        model.addAttribute("proposition", bookDao.findById(toRemoveId));
        model.addAttribute("viewHelper", new ViewHelper());
        return "book/remove";
    }

    @PostMapping("/remove")
    public String removeProposition(@RequestParam int toRemoveId, @ModelAttribute ViewHelper viewHelper) {
        if(viewHelper.getOption().equals("confirmed")) {
            bookDao.removeById(toRemoveId);
        }
        return "redirect:";
    }

}
