package br.edu.famper.onlinelibrary.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Set;

//Making The Attributes For "Book"...

@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "code")
public class Book {

    //Attribute "Code" For The Class "Book"...

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(hidden = true)
    private Long code;

    //Attribute "Title" For The Class "Book"...

    @Schema(description = "Book´s Title", example = "Macbeth", title = "Title")
    @Column(name = "title")
    private String title;

    //Attribute "Genre" For The Class "Book"...

    @Schema(description = "Book´s Genre", example = "Tragedy", title = "Genre")
    @Column(name = "genre")
    private String genre;

    //Attribute "Number Of Pages" For The Class "Book"...

    @Schema(description = "Book´s Number Of Pages", example = "128", title = "Number Of Pages")
    @Column(name = "number_of_pages")
    private Integer numberOfPages;

    //Attribute "Year Of Publication" For The Class "Book"...

    @Schema(description = "Book´s Year Of Publication", format = "date", example = "1623-08-24", title = "Year Of Publication")
    @Column(name = "year_of_publication")
    private LocalDate yearOfPublication;

    //Attribute "Price" For The Class "Book"...

    @Schema(description = "Book´s Price", example = "20.50", title = "Price")
    @Column(name = "price")
    private Double price;

    //Attribute "Author" For The Class "Book"...

    @Schema(description = "Book´s Author", example = "William Shakespeare", title = "Author")
    @Column(name = "author")
    private String author;

    //OneToMany Relationship With Loan, Mapped By The “Book” Property...

    @OneToMany(mappedBy = "book",
            targetEntity = Loan.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Book> books;
}
