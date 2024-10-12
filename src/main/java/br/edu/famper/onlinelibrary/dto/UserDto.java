package br.edu.famper.onlinelibrary.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String name;
    private Integer phone;
    private String country;
    private String state;
    private String city;
    private LoanDto loan;
}
