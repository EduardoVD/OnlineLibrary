package br.edu.famper.onlinelibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.apache.tomcat.jni.Library;

import java.util.Calendar;
import java.util.Set;

@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "code")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    @Column(name = "title")
    private String title;

    @Column(name = "year_of_publication")
    private Calendar yearOfPublication;

    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy = "book",
        targetEntity = Author.class,
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Author> authors;

    @OneToMany(mappedBy = "book",
        targetEntity = Publisher.class,
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Publisher> publishers;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

}
