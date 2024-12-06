package dnk.dtos.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestCreateAccountDTO {

    @NotBlank(message = "Phone number is not blank.")
    @Pattern(regexp = "^0\\d{9}$", message = "Phone number is invalid. Begin with 0 and have 10 number digits.")
    @Schema(description = "Phone number")
    private String phone;

    @NotBlank(message = "Name is not blank.")
    @Schema(description = "Name")
    private String name;

    @NotBlank(message = "Email is not blank.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Email address is invalid.")
    @Schema(description = "Email address")
    private String email;

    @NotBlank(message = "Password is not blank.")
    @Schema(description = "Password")
    private String password;
}
