package br.edu.famper.onlinelibrary.model;

import jakarta.persistence.*;
import lombok.*;

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
}
