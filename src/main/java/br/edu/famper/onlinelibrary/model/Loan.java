package br.edu.famper.onlinelibrary.model;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne
    @JoinColumn(name = "book_code")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "customer_code")
    private Customer customer;
}
