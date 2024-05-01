package ma.enset.hospitalthymeleaf.security.services;

import lombok.AllArgsConstructor;
import ma.enset.hospitalthymeleaf.security.entities.AppRole;
import ma.enset.hospitalthymeleaf.security.entities.AppUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = accountService.loadUserByUsername(username);
        if (appUser == null) throw new UsernameNotFoundException(String.format("User %s doesnt exists...", username));

        String[] roles = appUser.getRoles().stream().map(AppRole::getRole).toArray(String[]::new);

        return User.withUsername(appUser.getUsername()).password(appUser.getPassword()).roles(roles).build();
    }
}
