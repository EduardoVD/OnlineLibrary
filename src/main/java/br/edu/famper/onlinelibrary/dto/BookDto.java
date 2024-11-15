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

    //Adding Title, Description And Example For "Title" To An Better Understanding In Swagger...

    @Schema(description = "Book´s Title", example = "Macbeth", title = "Title")
    private String title;

    //Adding Title, Description And Example For "Genre" To An Better Understanding In Swagger...

    @Schema(description = "Book´s Genre", example = "Tragedy", title = "Genre")
    private String genre;

    //Adding Title, Description And Example For "Number Of Pages" To An Better Understanding In Swagger...

    @Schema(description = "Book´s Number Of Pages", example = "128", title = "Number Of Pages")
    private Integer numberOfPages;

    //Adding Title, Description And Example For "Year Of Publication" To An Better Understanding In Swagger...

    @Schema(description = "Book´s Year Of Publication", format = "date", example = "1623-08-24", title = "Year Of Publication")
    private LocalDate yearOfPublication;

    //Adding Title, Description And Example For "Price" To An Better Understanding In Swagger...

    @Schema(description = "Book´s Price", example = "20.50", title = "Price")
    private Double price;

    //Adding Title, Description And Example For "Author" To An Better Understanding In Swagger...

    @Schema(description = "Book´s Author", example = "William Shakespeare", title = "Author")
    private String author;
}
