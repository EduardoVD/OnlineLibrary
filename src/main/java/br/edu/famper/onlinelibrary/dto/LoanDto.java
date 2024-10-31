package br.edu.famper.onlinelibrary.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Loan", description = "Loan´s Information")
public class LoanDto {

    @Schema(description = "Loan´s Unpaid Debt", example = "20.00", title = "Unpaid Debt")
    private Double unpaidDebt;

    private CustomerDto customer;

    private BookDto book;
}
