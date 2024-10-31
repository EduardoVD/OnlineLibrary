package br.edu.famper.onlinelibrary.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.Calendar;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Author", description = "Author´s Information")
public class AuthorDto {

    @Schema(description = "Author´s First Name", example = "William", title = "First Name")
    private String firstName;

    @Schema(description = "Author´s Last Name", example = "Shakespeare", title = "Last Name")
    private String lastName;

    @Schema(description = "Author´s Date Of Birth", example = "1564-04-23", title = "Date Of Birth")
    private Calendar dateOfBirth;

    @Schema(description = "Author´s Date Of Death", example = "1616-04-23", title = "Date Of Death")
    private Calendar dateOfDeath;

    @Schema(description = "Author´s Written Book", example = "Macbeth", title = "Written Book")
    private String writtenBook;
}
