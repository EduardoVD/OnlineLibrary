package br.edu.famper.onlinelibrary.model;
import jakarta.persistence.*;
import lombok.*;

//Making The Attributes For "Publisher"...

@Entity
@Table(name = "publisher")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "code")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    @Column(name = "name")
    private String name;

    @Column(name = "published_book")
    private String publishedBook;
}
