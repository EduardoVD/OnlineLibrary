package br.edu.famper.onlinelibrary.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

//Making The Attributes For "Author"...

@Entity
@Table(name = "author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "code")
public class Author {

    //Attribute "Code" For The Class "Author"...

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    //Attribute "First Name" For The Class "Author"...

    @Column(name = "first_name")
    private String firstName;

    //Attribute "Last Name" For The Class "Author"...

    @Column(name = "last_name")
    private String lastName;

    //Attribute "Date Of Birth" For The Class "Author"...

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    //Attribute "Date Of Death" For The Class "Author"...

    @Column(name = "date_of_death")
    private LocalDate dateOfDeath;

    //Attribute "Written Book" For The Class "Author"...

    @Column(name = "written_book")
    private String writtenBook;
}
