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

    @Schema(description = "Customer´s Last Name", example = "José", title = "Last Name")
    @Column(name = "last_name")
    private String lastName;

    @Schema(description = "Customer´s Phone", example = "+55 46 9964-2134", title = "Phone")
    @Column(name = "phone")
    private String phone;

    @Schema(description = "Customer´s Country", example = "Brazil", title = "Country")
    @Column(name = "country")
    private String country;

    @Schema(description = "Customer´s State", example = "PR", title = "State")
    @Column(name = "state")
    private String state;

    @Schema(description = "Customer´s City", example = "Ampére", title = "City")
    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "customer",
            targetEntity = Loan.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Customer> customers;
}
