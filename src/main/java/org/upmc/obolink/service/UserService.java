package org.upmc.obolink.service;

import org.upmc.obolink.model.User;

public interface UserService {
    User findByUsername(String username);
    void saveUser(User user);
    void removeUser(User user);
}
