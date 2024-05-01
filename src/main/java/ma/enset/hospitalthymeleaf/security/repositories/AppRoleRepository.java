package ma.enset.hospitalthymeleaf.security.repositories;

import ma.enset.hospitalthymeleaf.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, String> {

}
