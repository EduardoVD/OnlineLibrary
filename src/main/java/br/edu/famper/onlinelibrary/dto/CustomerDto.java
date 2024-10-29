package br.edu.famper.onlinelibrary.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {

    @Schema(description = "Customer´s Name", example = "Eduardo José", title = "Name")
    private String name;

    @Schema(description = "Customer´s Phone", example = "+55 46 9964-2134", title = "Phone")
    private Integer phone;

    @Schema(description = "Customer´s Country", example = "Brazil", title = "Country")
    private String country;

    @Schema(description = "Customer´s State", example = "PR", title = "State")
    private String state;

    @Schema(description = "Customer´s City", example = "Ampére", title = "City")
    private String city;
}
