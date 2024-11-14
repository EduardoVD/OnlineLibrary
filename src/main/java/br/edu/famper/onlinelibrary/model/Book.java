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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    @Schema(description = "Book´s Title", example = "Macbeth", title = "Title")
    @Column(name = "title")
    private String title;

    @Schema(description = "Book´s Genre", example = "Tragedy", title = "Genre")
    @Column(name = "genre")
    private String genre;

    @Schema(description = "Book´s Number Of Pages", example = "128", title = "Number Of Pages")
    @Column(name = "number_of_pages")
    private Integer numberOfPages;

    @Schema(description = "Book´s Year Of Publication", format = "date", example = "1623-08-24", title = "Year Of Publication")
    @Column(name = "year_of_publication")
    private LocalDate yearOfPublication;

    @Schema(description = "Book´s Price", example = "20.50", title = "Price")
    @Column(name = "price")
    private Double price;

    @Schema(description = "Book´s Author", example = "William Shakespeare", title = "Author")
    @Column(name = "author")
    private String author;

    @OneToMany(mappedBy = "book",
            targetEntity = Loan.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Book> books;
}
