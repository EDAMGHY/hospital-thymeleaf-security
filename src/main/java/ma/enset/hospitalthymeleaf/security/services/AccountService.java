package ma.enset.hospitalthymeleaf.security.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.enset.hospitalthymeleaf.security.entities.AppRole;
import ma.enset.hospitalthymeleaf.security.entities.AppUser;
import ma.enset.hospitalthymeleaf.security.repositories.AppRoleRepository;
import ma.enset.hospitalthymeleaf.security.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountService implements IAccountService {

    private AppUserRepository userRepository;
    private AppRoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public AppUser addNewUser(String email, String username, String password, String confirmPassword) {
        AppUser existedUser = userRepository.findByUsername(username);


        if (existedUser != null) {
            throw new RuntimeException("The user already exists");
        }


        if (!password.equals(confirmPassword)) {
            throw new RuntimeException("The passwords does not match");
        }

        AppUser user = AppUser.builder().userId(UUID.randomUUID().toString()).email(email).username(username).password(passwordEncoder.encode(password)).build();


        return userRepository.save(user);
    }

    @Override
    public AppRole addNewRole(String role) {
        AppRole appRole = roleRepository.findById(role).orElse(null);
        if (appRole != null) throw new RuntimeException("The Role already exists");
        appRole = AppRole.builder().role(role).build();
        return roleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser user = userRepository.findByUsername(username);
        if (user == null) throw new RuntimeException("The user doesnt exists...");

        AppRole appRole = roleRepository.findById(role).orElse(null);
        if (appRole == null) throw new RuntimeException("The Role doesnt exists...");

        user.getRoles().add(appRole);
    }

    @Override
    public void removeRoleFromUser(String username, String role) {
        AppUser user = userRepository.findByUsername(username);
        if (user == null) throw new RuntimeException("The user doesnt exists...");

        AppRole appRole = roleRepository.findById(role).orElse(null);
        if (appRole == null) throw new RuntimeException("The Role doesnt exists...");

        user.getRoles().remove(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        AppUser user = userRepository.findByUsername(username);
        if (user == null) throw new RuntimeException("The user doesnt exists...");
        return user;
    }
}
