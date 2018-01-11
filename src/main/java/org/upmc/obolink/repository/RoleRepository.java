package org.upmc.obolink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.upmc.obolink.model.Role;

/**
 * The interface Repository of the role.
 */
@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
        /**
         * Search in the database for a role.
         * @param role the name of the role.
         * @return a role
         * @see Role
         */
        Role findByRole(String role);
}
