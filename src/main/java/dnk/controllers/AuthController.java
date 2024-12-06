package dnk.controllers;

import javax.validation.Valid;

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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("${apiPrefix}/auth")
@Api(tags = "Authentication", description = "APIs for Authentication module")
public class AuthController {

    private final AuthService authService;

    public AuthController(
            AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/register")
    @ApiOperation(value = "requestType : RequestDomain enum", notes = "Create User API")
    public BaseResponse<String> createPositionAndSeat(
            @Valid @RequestBody RequestCreateAccountDTO requestDTO) {
        authService.createUser(requestDTO);
        return BaseResponse.ok(AppConstants.STATUS_201, AppConstants.MESSAGE_201);
    }

}
