package br.edu.famper.onlinelibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "publisher")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "code")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "publisher",
        targetEntity = Book.class,
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Book> Books;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
