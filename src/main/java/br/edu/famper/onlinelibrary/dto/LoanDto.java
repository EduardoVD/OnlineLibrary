package br.edu.famper.onlinelibrary.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

//Used For Transfer Data Between Different Parts From An Application...

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Loan", description = "Loan´s Information")
public class LoanDto {

    //Adding Title, Description And Example For "Unpaid Debt" To An Better Understanding In Swagger...

    @Schema(description = "Loan´s Unpaid Debt", example = "20.50", title = "Unpaid Debt")
    private Double unpaidDebt;

    //Getting "Customer";

    private CustomerDto customer;

    //Getting "Book"

    private BookDto book;
}
