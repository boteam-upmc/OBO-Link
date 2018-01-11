package org.upmc.obolink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.upmc.obolink.model.Robot;
import org.upmc.obolink.model.RobotUser;
import org.upmc.obolink.repository.RobotRepository;

import java.util.ArrayList;
import java.util.List;
/**
 * The implementation of the robot service.
 */
@Service("robotService")
public class RobotServiceImpl implements RobotService {
    private final RobotRepository robotRepository;

    @Autowired
    public RobotServiceImpl(@Qualifier("robotRepository") RobotRepository robotRepository) {
        this.robotRepository = robotRepository;
    }


    /**
     *  Search in the database a robot with his id.
     *
     * @param robotId The id of the robot
     * @return The robot found
     * @see Robot
     */
    @Override
    public Robot findById(int robotId) {
        return robotRepository.findById(robotId);
    }

}
