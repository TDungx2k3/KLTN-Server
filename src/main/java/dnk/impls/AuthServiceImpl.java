package dnk.impls;

import org.springframework.stereotype.Service;

import dnk.dtos.requests.RequestCreateAccountDTO;
import dnk.entities.User;
import dnk.exceptions.BusinessLogicException;
import dnk.mappers.MapperUtils;
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
            User newUser = MapperUtils.map(request, User.class);
            System.out.println(newUser);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessLogicException("Create user failed", e);
        }
    }

}
