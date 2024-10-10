package br.edu.famper.onlinelibrary.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "code")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;
}
