package pl.coderslab.Spring01Hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.Spring01Hibernate.model.Student;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList(
                "Poland",
                "Germany",
                "France",
                "Russia",
                "Denmark"
        );
    }

    @ModelAttribute("hobbies")
    public List<String> getHobbies() {
        return Arrays.asList(
                "sport",
                "automotive",
                "horse riding"
        );
    }

    @ModelAttribute("programmingSkills")
    public List<String> getProgrammingSkills() {
        return Arrays.asList(
                "Java",
                "C#",
                "Ruby",
                "PHP",
                "Javascript"
        );
    }

    @GetMapping("/form")
    public String prepareStudent(Model model) {
        model.addAttribute("student", new Student());
        return "/student/form";
    }

    @PostMapping("/form")
    public String redirectStudent(@ModelAttribute Student student, Model model) {
        model.addAttribute("student", student);
        return "/student/view";
    }

}
