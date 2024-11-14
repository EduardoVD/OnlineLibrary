package br.edu.famper.onlinelibrary.model;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

//Making The Attributes For "Loan"...

@Entity
@Table(name = "loan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "code")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    @Schema(description = "Loan´s Unpaid Debt", example = "20.50", title = "Unpaid Debt")
    private Double unpaidDebt;

    //Get The Book´s Code...

    @ManyToOne
    @JoinColumn(name = "book_code")
    private Book book;

    //Get The Customer´s Code...

    @ManyToOne
    @JoinColumn(name = "customer_code")
    private Customer customer;
}
