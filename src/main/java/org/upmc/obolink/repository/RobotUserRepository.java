package org.upmc.obolink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.upmc.obolink.model.Robot;
import org.upmc.obolink.model.RobotUser;

import java.util.List;

/**
 * The interface Repository of the robot user association.
 */
@Repository("RobotUserRepository")
public interface RobotUserRepository extends JpaRepository<RobotUser, Integer> {
    /**
     * Search in the database all the robot user associations for a user id.
     * @param userId the id of the user.
     * @return A list of association.
     * @see RobotUser
     */
    List<RobotUser> findByUserId(int userId);

    /**
     * Search in the database a robot user association with a user id and a robot id.
     * @param userId the user id.
     * @param robotId tje robot id.
     * @return an association of robot user
     * @see RobotUser
     */
    RobotUser getRobotUserByUserIdAndRobotId(int userId, int robotId);
}
