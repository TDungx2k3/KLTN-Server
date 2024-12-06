package dnk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dnk.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByPhoneAndEmail(String phone, String email);

}
