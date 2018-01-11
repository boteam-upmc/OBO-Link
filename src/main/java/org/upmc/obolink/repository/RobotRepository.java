package org.upmc.obolink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.upmc.obolink.model.Robot;
import org.upmc.obolink.model.Role;

/**
 * The interface Repository of the robot.
 */
@Repository("robotRepository")
public interface RobotRepository extends JpaRepository<Robot, Integer> {
    /**
     *  Search in the database a robot with his id.
     *
     * @param robotId The id of the robot
     * @return The robot found
     * @see Robot
     */
    Robot findById(int robotId);
}
