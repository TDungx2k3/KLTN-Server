package dnk.services;

import dnk.dtos.requests.RequestCreateAccountDTO;
import dnk.dtos.requests.RequestLoginAccount;
import dnk.dtos.responses.ResponseLogInAccount;

public interface AuthService {
    void createUser(RequestCreateAccountDTO requestDTO);

    ResponseLogInAccount login(RequestLoginAccount requestDTO);
}
