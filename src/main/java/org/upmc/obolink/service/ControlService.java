package org.upmc.obolink.service;


import org.upmc.obolink.model.User;
/**
 * The interface for control the robot.
 */
public interface ControlService {
    /**
     * Check the association between the robot and the user
     * @param robotId number that identifies the robot.
     * @param user the user id.
     * @return returns true if user and robot are well associated. False otherwise
     */
    Boolean checkRobotAndAssociation(int robotId, User user);
}
