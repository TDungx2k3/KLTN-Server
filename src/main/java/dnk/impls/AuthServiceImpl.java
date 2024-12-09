package dnk.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dnk.constants.AppConstants;
import dnk.dtos.requests.RequestCreateAccountDTO;
import dnk.dtos.requests.RequestLoginAccount;
import dnk.dtos.responses.ResponseLogInAccount;
import dnk.entities.User;
import dnk.exceptions.BusinessLogicException;
import dnk.exceptions.ResourceNotFoundException;
import dnk.mappers.MapperUtils;
import dnk.repositories.UserRepository;
import dnk.services.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(RequestCreateAccountDTO request) {
        try {
            User newUser = MapperUtils.map(request, User.class);
            System.out.println(newUser);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessLogicException("Create user failed", e);
        }
    }

    @Override
    public ResponseLogInAccount login(RequestLoginAccount request) {
        try {
            User user = userRepository.findByEmail(request.getEmail()).orElseThrow(
                    () -> new ResourceNotFoundException(AppConstants.USERS, "email", request.getEmail()));
            String token = "ss";
            ResponseLogInAccount response = new ResponseLogInAccount();
            response.setMessage(token);
            response.setToken(token);
            return response;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessLogicException("Login failed", e);
        }
    }

}
