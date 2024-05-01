package ma.enset.hospitalthymeleaf.security.services;

import ma.enset.hospitalthymeleaf.security.entities.AppRole;
import ma.enset.hospitalthymeleaf.security.entities.AppUser;

public interface IAccountService {
    AppUser addNewUser(String email, String username, String password, String confrimPassword);

    AppRole addNewRole(String role);

    void addRoleToUser(String username, String role);

    void removeRoleFromUser(String username, String role);

    AppUser loadUserByUsername(String username);
}
