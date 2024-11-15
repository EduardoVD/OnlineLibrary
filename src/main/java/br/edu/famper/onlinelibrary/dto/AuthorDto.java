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
@Schema(name = "Author", description = "Author´s Information")
public class AuthorDto {

    //Adding Title, Description And Example For "First Name" To An Better Understanding In Swagger...

    @Schema(description = "Author´s First Name", example = "William", title = "First Name")
    private String firstName;

    //Adding Title, Description And Example For "Last Name" To An Better Understanding In Swagger...

    @Schema(description = "Author´s Last Name", example = "Shakespeare", title = "Last Name")
    private String lastName;

    //Adding Title, Description And Example For "Date Of Birth" To An Better Understanding In Swagger...

    @Schema(description = "Author´s Date Of Birth", example = "1564-04-23", title = "Date Of Birth")
    private LocalDate dateOfBirth;

    //Adding Title, Description And Example For "Date Of Death" To An Better Understanding In Swagger...

    @Schema(description = "Author´s Date Of Death", example = "1616-04-23", title = "Date Of Death")
    private LocalDate dateOfDeath;

    //Adding Title, Description And Example For "Written Book" To An Better Understanding In Swagger...

    @Schema(description = "Author´s Written Book", example = "Macbeth", title = "Written Book")
    private String writtenBook;
}


