package org.upmc.obolink.service;

import org.upmc.obolink.model.Robot;
import org.upmc.obolink.model.RobotUser;

import java.util.List;

/**
 * The inteface Service of the robot.
 */
public interface RobotService {
    /**
     *  Search in the database a robot with his id.
     *
     * @param robotId The id of the robot
     * @return The robot found
     * @see Robot
     */
    Robot findById(int robotId);
}
