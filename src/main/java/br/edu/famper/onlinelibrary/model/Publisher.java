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

    //Attribute "Code" For The Class "Publisher"...

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    //Attribute "Name" For The Class "Publisher"...

    @Column(name = "name")
    private String name;

    //Attribute "Published Book" For The Class "Publisher"...

    @Column(name = "published_book")
    private String publishedBook;
}
