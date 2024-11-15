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

    //Attribute "Code" For The Class "Customer"...

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    //Attribute "First Name" For The Class "Customer"...

    @Schema(description = "Customer´s First Name", example = "Eduardo", title = "First Name")
    @Column(name = "first_name")
    private String firstName;

    //Attribute "Last Name" For The Class "Customer"...

    @Schema(description = "Customer´s Last Name", example = "José", title = "Last Name")
    @Column(name = "last_name")
    private String lastName;

    //Attribute "Phone" For The Class "Customer"...

    @Schema(description = "Customer´s Phone", example = "+55 46 9964-2134", title = "Phone")
    @Column(name = "phone")
    private String phone;

    //Attribute "Country" For The Class "Customer"...

    @Schema(description = "Customer´s Country", example = "Brazil", title = "Country")
    @Column(name = "country")
    private String country;

    //Attribute "State" For The Class "Customer"...

    @Schema(description = "Customer´s State", example = "PR", title = "State")
    @Column(name = "state")
    private String state;

    //Attribute "City" For The Class "Customer"...

    @Schema(description = "Customer´s City", example = "Ampére", title = "City")
    @Column(name = "city")
    private String city;

    //OneToMany Relationship With Loan, Mapped By The “Customer” Property...

    @OneToMany(mappedBy = "customer",
            targetEntity = Loan.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Customer> customers;
}
