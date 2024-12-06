package dnk.services;

import dnk.dtos.requests.RequestCreateAccountDTO;

public interface AuthService {
    void createUser(RequestCreateAccountDTO requestDTO);
}
