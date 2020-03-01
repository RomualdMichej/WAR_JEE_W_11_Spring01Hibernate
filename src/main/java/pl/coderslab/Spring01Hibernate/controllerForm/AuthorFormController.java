package pl.coderslab.Spring01Hibernate.controllerForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Spring01Hibernate.dao.AuthorDao;
import pl.coderslab.Spring01Hibernate.model.Author;
import pl.coderslab.Spring01Hibernate.util.ViewHelper;

@Controller
@RequestMapping("/authorForm")
public class AuthorFormController {

    private final AuthorDao authorDao;

    @Autowired
    public AuthorFormController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/")
    public String findAllAuthors(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "author/all";
    }

    @GetMapping("/add")
    public String initAddPublisher(Model model) {
        model.addAttribute("author", new Author());
        return "author/addAndEdit";
    }

    @PostMapping("/add")
    public String addPublisher(@ModelAttribute Author author) {
        authorDao.persist(author);
        return "redirect:";
    }

    @GetMapping("/remove")
    public String initRemoveAuthor(@RequestParam int toRemoveId, Model model) {
        model.addAttribute("author", authorDao.findById(toRemoveId));
        model.addAttribute("viewHelper", new ViewHelper());
        return "publisher/remove";
    }

    @PostMapping("/remove")
    public String removePublisher(@RequestParam int toRemoveId, @ModelAttribute ViewHelper viewHelper) {
        if("confirmed".equals(viewHelper.getOption())) {
            authorDao.removeById(toRemoveId);
        }
        return "redirect:";
    }

    @GetMapping("/edit")
    public String initEditBook(@RequestParam int toEditId, Model model) {
        model.addAttribute("author", authorDao.findById(toEditId));
        return "author/addAndEdit";
    }

    @PostMapping("/edit")
    public String editBook(@ModelAttribute Author author) {
        authorDao.merge(author);
        return "redirect:";
    }

}
