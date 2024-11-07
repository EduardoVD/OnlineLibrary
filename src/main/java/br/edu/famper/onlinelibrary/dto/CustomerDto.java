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

    @Schema(description = "Customer´s First Name", example = "Eduardo", title = "First Name")
    private String firstName;

    @Schema(description = "Customer´s Last Name", example = "José", title = "Last Name")
    private String lastName;

    @Schema(description = "Customer´s Phone", example = "+55 46 9964-2134", title = "Phone")
    private String phone;

    @Schema(description = "Customer´s Country", example = "Brazil", title = "Country")
    private String country;

    @Schema(description = "Customer´s State", example = "PR", title = "State")
    private String state;

    @Schema(description = "Customer´s City", example = "Ampére", title = "City")
    private String city;
}
