package br.edu.famper.onlinelibrary.model;
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
