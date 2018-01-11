package org.upmc.obolink.service;

import org.upmc.obolink.model.RobotUser;
import org.upmc.obolink.model.User;

import java.util.List;

/**
 * The interface Service of the robot user association.
 */
public interface RobotUserService {
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
     * @param robotId the robot id.
     * @return an association of robot user
     * @see RobotUser
     */
    RobotUser getRobotUserByUserIdAndRobotId(int userId, int robotId);

    /**
     * Remove a robot user association from the database.
     * @param robotUser the robot user
     * @see RobotUser
     */
    void removeUserRobots(RobotUser robotUser);
    /**
     * Add a robot user association in the database.
     * @param robotUser the robot user
     * @see RobotUser
     */
    void saveUserRobots(RobotUser robotUser);
}
