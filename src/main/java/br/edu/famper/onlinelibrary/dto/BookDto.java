package br.edu.famper.onlinelibrary.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDate;

//Used For Transfer Data Between Different Parts From An Application...

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Book", description = "Book´s Information")
public class BookDto {

    @Schema(description = "Book´s Title", example = "Macbeth", title = "Title")
    private String title;

    @Schema(description = "Book´s Genre", example = "Tragedy", title = "Genre")
    private String genre;

    @Schema(description = "Book´s Number Of Pages", example = "128", title = "Number Of Pages")
    private Integer numberOfPages;

    @Schema(description = "Book´s Year Of Publication", format = "date", example = "1623-08-24", title = "Year Of Publication")
    private LocalDate yearOfPublication;

    @Schema(description = "Book´s Price", example = "20.50", title = "Price")
    private Double price;

    @Schema(description = "Book´s Author", example = "William Shakespeare", title = "Author")
    private String author;

}
