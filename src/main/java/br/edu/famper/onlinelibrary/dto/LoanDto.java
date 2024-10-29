package br.edu.famper.onlinelibrary.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanDto {

    @Schema(description = "Loan´s Unpaid Debt", example = "20,00", title = "Unpaid Debt")
    private Double unpaidDebt;

    @Schema(description = "Loan´s Registered Customer", example = "Eduardo José", title = "Loan´s Customer")
    private CustomerDto customer;

    @Schema(description = "Loan´s Registered Book", example = "Macbeth", title = "Book´s Customer")
    private BookDto book;
}
