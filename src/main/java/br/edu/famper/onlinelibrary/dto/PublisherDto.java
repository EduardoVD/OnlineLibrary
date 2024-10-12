package br.edu.famper.onlinelibrary.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublisherDto {

    private String name;
    private BookDto book;
}
