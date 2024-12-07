package dnk.dtos.requests;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestCreateAccountDTO {

    @Pattern(regexp = "^0\\d{9}$", message = "Phone number is invalid. Begin with 0 and have 10 number digits.")
    @Schema(description = "Phone number")
    private String phone;

    @NotBlank(message = "Name is not blank.")
    @Schema(description = "Name")
    private String name;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Email address is invalid.")
    @Schema(description = "Email address")
    private String email;

    @NotBlank(message = "Password is not blank.")
    @Schema(description = "Password")
    private String password;

    @NotNull(message = "Birth date is required.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Schema(description = "Birth of date")
    private Date birthDate;
}
