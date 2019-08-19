package com.aerotravel.flightticketbooking.user_management.service.serviceImplem;


import com.aerotravel.flightticketbooking.user_management.model.Admin;
import com.aerotravel.flightticketbooking.user_management.repository.UserRepository;
import com.aerotravel.flightticketbooking.user_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
        return new org.springframework.security.core.userdetails.User(admin.getUsername(), admin.getPassword(),
                getAuthorities(admin));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(Admin admin) {
        String[] userRoles = admin.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
}
