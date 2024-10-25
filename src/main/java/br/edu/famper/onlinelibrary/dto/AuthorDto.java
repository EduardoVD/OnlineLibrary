package br.edu.famper.onlinelibrary.dto;

import lombok.*;

import java.util.Calendar;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {

    private String firstName;
    private String lastName;
    private Calendar dateOfBirth;
    private Calendar dateOfDeath;
    private String writtenBook;
}
