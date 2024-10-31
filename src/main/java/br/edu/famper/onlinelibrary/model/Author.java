package br.edu.famper.onlinelibrary.model;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Calendar dateOfBirth;

    @Column(name = "date_of_death")
    @Temporal(TemporalType.DATE)
    private Calendar dateOfDeath;

    @Column(name = "written_book")
    private String writtenBook;
}
