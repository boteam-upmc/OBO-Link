package org.upmc.obolink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upmc.obolink.model.RobotUser;
import org.upmc.obolink.repository.RobotUserRepository;

import java.util.List;

/**
 * The implementation of the robot user association Service.
 */
@Service("robotUserService")
public class RobotUserServiceImpl implements RobotUserService {
    private final RobotUserRepository robotUserRepository;

    @Autowired
    public RobotUserServiceImpl(RobotUserRepository robotUserRepository) {
        this.robotUserRepository = robotUserRepository;
    }

    /**
     * Search in the database all the robot user associations for a user id.
     * @param userId the id of the user.
     * @return A list of association.
     * @see RobotUser
     */
    @Override
    public List<RobotUser> findByUserId(int userId) {
        return robotUserRepository.findByUserId(userId);
    }

    /**
     * Search in the database a robot user association with a user id and a robot id.
     * @param userId the user id.
     * @param robotId the robot id.
     * @return an association of robot user
     * @see RobotUser
     */
    @Override
    public RobotUser getRobotUserByUserIdAndRobotId(int userId, int robotId) {
        return robotUserRepository.getRobotUserByUserIdAndRobotId(userId, robotId);
    }

    /**
     * Remove a robot user association from the database.
     * @param robotUser the robot user
     * @see RobotUser
     */
    @Override
    public void removeUserRobots(RobotUser robotUser) {
        robotUserRepository.delete(robotUser);
    }
    /**
     * Add a robot user association in the database.
     * @param robotUser the robot user
     * @see RobotUser
     */
    @Override
    public void saveUserRobots(RobotUser robotUser) {
        robotUserRepository.save(robotUser);
    }

}
