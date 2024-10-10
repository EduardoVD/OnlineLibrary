package br.edu.famper.onlinelibrary.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Entity
@Table(name = "author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "code")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
    private Calendar dateOfBirth;

    @Column(name = "date_of_death")
    private Calendar dateOfDeath;

    private String Book;
}
