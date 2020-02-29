package pl.coderslab.Spring01Hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Spring01Hibernate.dao.AuthorDao;
import pl.coderslab.Spring01Hibernate.dao.BookDao;
import pl.coderslab.Spring01Hibernate.dao.PublisherDao;
import pl.coderslab.Spring01Hibernate.model.Author;
import pl.coderslab.Spring01Hibernate.model.Book;
import pl.coderslab.Spring01Hibernate.model.Publisher;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    @Autowired
    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/findById/{id}")
    @ResponseBody
    public String findById(@PathVariable("id") long id) {
        Book book = bookDao.findById(id);
        return "Znaleziono ksiazke o id: " + book.getId();
    }

    @GetMapping("/persist")
    @ResponseBody
    public String persist() {
        Book book = new Book();
        book.setTitle("Czerwony Kapturek");
        book.setRating(4);
        book.setDescription("Historia o czerwonym kapturku");

        Publisher publisher = new Publisher();
        publisher.setName("Wydawnictwo ERA");
        publisherDao.persist(publisher);
        book.setPublisher(publisher);

        Author firstAuthor = authorDao.findById(1);
        Author secondAuthor = authorDao.findById(3);
        book.getAuthorList().add(firstAuthor);
        book.getAuthorList().add(secondAuthor);

        bookDao.persist(book);
        return "Zapisano ksiazke";
    }

    @GetMapping("/merge")
    @ResponseBody
    public String merge() {
        Book book = bookDao.findById(1L);
        book.setTitle("Zedytowany tytul");
        bookDao.merge(book);
        return "Zaktualizowano ksiazke o id 1";
    }

    @GetMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable("id") long id) {
        bookDao.removeById(id);
        return "Usunieto ksiazke";
    }

    @GetMapping("/findAll")
    @ResponseBody
    public String findAll() {
        List<Book> books = bookDao.findAll();
        return books.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining("<br />"));
    }

    @GetMapping("/rating/{rating}")
    @ResponseBody
    public String getRatingList(@PathVariable("rating") int rating) {
        List<Book> books = bookDao.getRatingList(rating);
        return books.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining("<br />"));
    }

    @GetMapping("/publisher")
    @ResponseBody
    public String findWithPublisher() {
        List<Book> books = bookDao.findAllWithPublisher();
        return books.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining("<br />"));
    }

    @GetMapping("/publisher/{publisherId}")
    @ResponseBody
    public String findByGivenPublisher(@PathVariable("publisherId") int publisherId) {
        Publisher publisher = publisherDao.findById(publisherId);
        List<Book> books = bookDao.findAllWithPublisher(publisher);
        return books.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining("<br />"));
    }

    @GetMapping("/author/{authorId}")
    @ResponseBody
    public String findByGivenAuthor(@PathVariable("authorId") int authorId) {
        Author author = authorDao.findById(authorId);
        List<Book> books = bookDao.findAllWithAuthor(author);
        return books.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining("<br />"));
    }

}
