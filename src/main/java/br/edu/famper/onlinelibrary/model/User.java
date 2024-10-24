package br.edu.famper.onlinelibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "code")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "user",
        targetEntity = Loan.class,
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Loan> loans;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;
}
