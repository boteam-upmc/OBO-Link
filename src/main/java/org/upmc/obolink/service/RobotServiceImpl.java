package org.upmc.obolink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.upmc.obolink.model.Robot;
import org.upmc.obolink.model.RobotUser;
import org.upmc.obolink.repository.RobotRepository;

import java.util.ArrayList;
import java.util.List;

@Service("robotService")
public class RobotServiceImpl implements RobotService {
    private final RobotRepository robotRepository;

    @Autowired
    public RobotServiceImpl(@Qualifier("robotRepository") RobotRepository robotRepository) {
        this.robotRepository = robotRepository;
    }


    @Override
    public Robot findById(int robotId) {
        return robotRepository.findById(robotId);
    }

    @Override
    public List<Robot> findByUserRobots(List<RobotUser> userRobots) {
        List<Robot> robots = new ArrayList<>();
        for (RobotUser userRobot : userRobots) {
            robots.add(robotRepository.findById(userRobot.getRobotId()));
        }
        return robots;
    }
}
