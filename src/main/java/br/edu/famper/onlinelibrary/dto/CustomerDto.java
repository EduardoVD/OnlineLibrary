package br.edu.famper.onlinelibrary.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

//Used For Transfer Data Between Different Parts From An Application...

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Customer", description = "Customer´s Information")
public class CustomerDto {

    //Adding Title, Description And Example For "First Name" To An Better Understanding In Swagger...

    @Schema(description = "Customer´s First Name", example = "Eduardo", title = "First Name")
    private String firstName;

    //Adding Title, Description And Example For "Last Name" To An Better Understanding In Swagger...

    @Schema(description = "Customer´s Last Name", example = "José", title = "Last Name")
    private String lastName;

    //Adding Title, Description And Example For "Phone" To An Better Understanding In Swagger...

    @Schema(description = "Customer´s Phone", example = "+55 46 9964-2134", title = "Phone")
    private String phone;

    //Adding Title, Description And Example For "Country" To An Better Understanding In Swagger...

    @Schema(description = "Customer´s Country", example = "Brazil", title = "Country")
    private String country;

    //Adding Title, Description And Example For "State" To An Better Understanding In Swagger...

    @Schema(description = "Customer´s State", example = "PR", title = "State")
    private String state;

    //Adding Title, Description And Example For "City" To An Better Understanding In Swagger...

    @Schema(description = "Customer´s City", example = "Ampére", title = "City")
    private String city;
}
