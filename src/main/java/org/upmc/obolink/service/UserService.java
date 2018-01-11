package org.upmc.obolink.service;

import org.upmc.obolink.model.User;

/**
 * The interface Service of the user.
 */
public interface UserService {
    /**
     * Search in the database for a user by is name.
     * @param username the name of the user.
     * @return a user
     * @see User
     */
    User findByUsername(String username);
    /**
     * Add a user in the database.
     * @param user the user
     * @see User
     */
    void saveUser(User user);
    /**
     * Remove a user from the database.
     * @param user the user
     * @see User
     */
    void removeUser(User user);
}
