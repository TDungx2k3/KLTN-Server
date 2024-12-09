package dnk.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dnk.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByPhoneAndEmail(String phone, String email);

    Optional<User> findByEmail(String email);

}
