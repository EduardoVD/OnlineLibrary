package br.edu.famper.onlinelibrary.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

//Represent The Structure Of An Error Response In The Application...

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

    private Date timestamp;
    private String status;
    private String message;
    private String details;
}
