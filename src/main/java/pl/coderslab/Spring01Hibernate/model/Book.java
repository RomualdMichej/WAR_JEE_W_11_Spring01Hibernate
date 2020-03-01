package pl.coderslab.Spring01Hibernate.model;

import org.hibernate.validator.constraints.Range;
import pl.coderslab.Spring01Hibernate.validator.group.BookValidationGroup;
import pl.coderslab.Spring01Hibernate.validator.group.PropositionValidationGroup;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, groups = {BookValidationGroup.class, PropositionValidationGroup.class})
    private String title;

    @Range(min = 1, max = 10, groups = BookValidationGroup.class)
    private int rating;

    @Size(max = 30, groups = {BookValidationGroup.class, PropositionValidationGroup.class})
    @NotBlank(groups = PropositionValidationGroup.class)
    private String description;

    @ManyToOne
    @NotNull(groups = BookValidationGroup.class)
    private  Publisher publisher;

    @ManyToMany
    @NotEmpty(groups = BookValidationGroup.class)
    private List<Author> authorList = new ArrayList<>();

    @Min(value = 2, groups = BookValidationGroup.class)
    private int pages;

    private boolean proposition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isProposition() {
        return proposition;
    }

    public void setProposition(boolean proposition) {
        this.proposition = proposition;
    }
}
