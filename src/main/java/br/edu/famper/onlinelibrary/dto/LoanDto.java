package br.edu.famper.onlinelibrary.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanDto {

    private Double unpaidDebt;
    private UserDto user;
    private BookDto book;
}
