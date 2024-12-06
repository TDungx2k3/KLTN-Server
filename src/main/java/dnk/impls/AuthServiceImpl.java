package dnk.impls;

import org.springframework.stereotype.Service;

import dnk.dtos.requests.RequestCreateAccountDTO;
import dnk.exceptions.BusinessLogicException;
import dnk.services.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Override
    public void createUser(RequestCreateAccountDTO request) {
        try {

        } catch (Exception e) {
            // TODO: handle exception
            log.error(e.getMessage());
            throw new BusinessLogicException("Create user failed", e);
        }
    }

}
