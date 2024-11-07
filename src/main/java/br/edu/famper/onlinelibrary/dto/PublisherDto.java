package br.edu.famper.onlinelibrary.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

//Used For Transfer Data Between Different Parts From An Application...

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Publisher", description = "Publisher´s Information")
public class PublisherDto {

    @Schema(description = "Publisher´s Name", example = "CPB", title = "Name")
    private String name;

    @Schema(description = "Publisher´s Published Book", example = "Macbeth", title = "Published Book")
    private String publishedBook;
}
