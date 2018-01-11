package org.upmc.obolink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.upmc.obolink.model.Role;
import org.upmc.obolink.model.User;
import org.upmc.obolink.repository.RoleRepository;
import org.upmc.obolink.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * The implementation of the user Service.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(@Qualifier("userRepository") UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, @Qualifier("roleRepository") RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    /**
     * Search in the database for a user by is name.
     * @param username the name of the user.
     * @return a user
     * @see User
     */
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Add a user in the database.
     * @param user the user
     * @see User
     */
    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setAlpha(0);
        user.setActive(1);
        Role userRole = roleRepository.findByRole("STANDARD");
        user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
        userRepository.save(user);
    }

    /**
     * Remove a user from the database.
     * @param user the user
     * @see User
     */
    @Override
    public void removeUser(User user) {
        userRepository.delete(user);
    }
}
