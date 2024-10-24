package br.edu.famper.onlinelibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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

    @OneToMany(mappedBy = "loan",
    targetEntity = User.class,
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<User> users;

    @OneToMany(mappedBy = "loan",
        targetEntity = Book.class,
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Book> Books;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
