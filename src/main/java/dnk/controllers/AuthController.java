package dnk.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dnk.constants.AppConstants;
import dnk.dtos.commons.BaseResponse;
import dnk.dtos.requests.RequestCreateAccountDTO;
import dnk.services.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@CrossOrigin
@RestController
@RequestMapping("${api.prefix}/auth")
@Api(tags = "Authentication", description = "APIs for Authentication module")
public class AuthController {

    private final AuthService authService;

    public AuthController(
            AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/register")
    @ApiOperation(value = "", notes = "Create User API")
    public ResponseEntity<BaseResponse<String>> createUser(
            @Valid @RequestBody RequestCreateAccountDTO requestDTO) {
        try {
            authService.createUser(requestDTO);
            return ResponseEntity
                    .ok(BaseResponse.ok(AppConstants.STATUS_201, AppConstants.MESSAGE_201));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError()
                    .body(BaseResponse.error(AppConstants.STATUS_500, ex.getMessage()));
        }
    }

}
