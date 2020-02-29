package pl.coderslab.Spring01Hibernate.controllerForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Spring01Hibernate.dao.AuthorDao;
import pl.coderslab.Spring01Hibernate.dao.BookDao;
import pl.coderslab.Spring01Hibernate.dao.PublisherDao;
import pl.coderslab.Spring01Hibernate.model.Author;
import pl.coderslab.Spring01Hibernate.model.Book;
import pl.coderslab.Spring01Hibernate.model.Publisher;
import pl.coderslab.Spring01Hibernate.util.ViewHelper;

import java.util.List;

@Controller
@RequestMapping("/bookForm")
public class BookFormController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    @Autowired
    public BookFormController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
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
    public String findAllBooks(Model model) {
        model.addAttribute("allBooks", bookDao.findAll());
        return "book/all";
    }

    @GetMapping("/add")
    public String initAddBook(Model model) {
        model.addAttribute("book", new Book());
        return "book/addAndEdit";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookDao.persist(book);
        return "redirect:";
    }

    @GetMapping("/edit")
    public String initEditBook(@RequestParam("toEditId") int toEditId, Model model) {
        model.addAttribute("book", bookDao.findById(toEditId));
        return "book/addAndEdit";
    }

    @PostMapping("/edit")
    public String editBook(@ModelAttribute Book book) {
        bookDao.merge(book);
        return "redirect:";
    }

    @GetMapping("/remove")
    public String initRemoveBook(@RequestParam("toRemoveId") int toRemoveId, Model model) {
        model.addAttribute("book", bookDao.findById(toRemoveId));
        model.addAttribute("viewHelper", new ViewHelper());
        return "book/remove";
    }

    @PostMapping("/remove")
    public String removeBook(@RequestParam int toRemoveId, @ModelAttribute ViewHelper viewHelper) {
        if(viewHelper.getOption().equals("confirmed")) {
            bookDao.removeById(toRemoveId);
        }
        return "redirect:";
    }

}
