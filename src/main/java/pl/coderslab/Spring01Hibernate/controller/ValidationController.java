package pl.coderslab.Spring01Hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Spring01Hibernate.model.Book;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/validation")
public class ValidationController {

    private final Validator validator;

    @Autowired
    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")
    @ResponseBody
    public String validate() {
        Book book = new Book();
        book.setTitle("test");
        book.setRating(15);
        book.setDescription("123456789012345678901234567890lki");
        book.setPages(1);
        Set<ConstraintViolation<Book>> validationResult = validator.validate(book);
        if(!validationResult.isEmpty()) {
            for (ConstraintViolation<Book> constraintViolation : validationResult) {
                System.out.println("!BLAD! " + constraintViolation.getPropertyPath() +
                        " " + constraintViolation.getMessage());
            }
           return "Encja niepoprawna";
        } else {
            return "Encja poprawna";
        }
    }

    @GetMapping("/validateView")
    public String validateView(Model model) {
        Book book = new Book();
        book.setTitle("test");
        book.setRating(15);
        book.setDescription("123456789012345678901234567890lki");
        book.setPages(1);
        Set<ConstraintViolation<Book>> validationResult = validator.validate(book);
        model.addAttribute("validationResult", validationResult);
        return "validation/result";
    }

}
