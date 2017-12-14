package org.upmc.obolink.service;

import org.upmc.obolink.model.RobotUser;
import org.upmc.obolink.model.User;

import java.util.List;

public interface RobotUserService {
    List<RobotUser> findByUserId(int userId);
    RobotUser getRobotUserByUserIdAndRobotId(int userId, int robotId);
    void removeUserRobots(RobotUser robotUser);
    void saveUserRobots(RobotUser robotUser);
}
