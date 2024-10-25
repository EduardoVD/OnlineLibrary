package br.edu.famper.onlinelibrary.dto;

import lombok.*;

import java.util.Calendar;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {

    private String title;
    private Calendar yearOfPublication;
    private Double price;
    private String author;
}
