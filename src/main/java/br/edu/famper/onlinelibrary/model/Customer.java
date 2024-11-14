package br.edu.famper.onlinelibrary.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

//Making The Attributes For "Customer"...

@Entity
@Table(name = "Customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "code")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    @Schema(description = "Customer´s First Name", example = "Eduardo", title = "First Name")
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "customer",
            targetEntity = Loan.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Customer> customers;
}
