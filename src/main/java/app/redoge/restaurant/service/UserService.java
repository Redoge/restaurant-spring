package app.redoge.restaurant.service;


import app.redoge.restaurant.entity.Role;
import app.redoge.restaurant.entity.User;
import app.redoge.restaurant.repository.RoleRepository;
import app.redoge.restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Service
public class UserService {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private RoleRepository roleDao;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;


    public Collection<? extends GrantedAuthority>  getAuthorizedUserRoles(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities();
    }

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findById(3L).orElse(null));
        user.setRoles(roles);
        userDao.save(user);
    }


    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
