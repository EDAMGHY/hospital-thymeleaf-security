package ma.enset.hospitalthymeleaf.security.repositories;

import ma.enset.hospitalthymeleaf.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
