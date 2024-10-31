package br.edu.famper.onlinelibrary.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.Calendar;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Book", description = "Book´s Information")
public class BookDto {

    @Schema(description = "Book´s Title", example = "Macbeth", title = "Title")
    private String title;

    @Schema(description = "Book´s Year Of Publication", example = "1623-08-24", title = "Year Of Publication")
    private Calendar yearOfPublication;

    @Schema(description = "Book´s Price", example = "20.00", title = "Price")
    private Double price;

    @Schema(description = "Book´s Author", example = "William Shakespeare", title = "Author")
    private String author;
}
