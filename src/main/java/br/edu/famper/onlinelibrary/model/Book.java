package br.edu.famper.onlinelibrary.model;

import jakarta.persistence.*;
import lombok.*;

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
    private Integer yearOfPublication;

    @Column(name = "price")
    private Double price;

    private String author;

    private String publisher;

}
