package org.upmc.obolink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.upmc.obolink.model.User;

/**
 * The interface Repository of the user.
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Search in the database for a user by is name.
     * @param username the name of the user.
     * @return a user
     * @see User
     */
    User findByUsername(String username);
}
