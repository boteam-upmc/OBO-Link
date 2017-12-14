package org.upmc.obolink.service;

import org.upmc.obolink.model.Robot;
import org.upmc.obolink.model.RobotUser;

import java.util.List;

public interface RobotService {
    Robot findById(int robotId);
    List<Robot> findByUserRobots(List<RobotUser> userRobots);
}
