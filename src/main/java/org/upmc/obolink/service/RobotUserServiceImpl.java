package org.upmc.obolink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upmc.obolink.model.RobotUser;
import org.upmc.obolink.repository.RobotUserRepository;

import java.util.List;

@Service("robotUserService")
public class RobotUserServiceImpl implements RobotUserService {
    private final RobotUserRepository robotUserRepository;

    @Autowired
    public RobotUserServiceImpl(RobotUserRepository robotUserRepository) {
        this.robotUserRepository = robotUserRepository;
    }

    @Override
    public List<RobotUser> findByUserId(int userId) {
        return robotUserRepository.findByUserId(userId);
    }

    @Override
    public RobotUser getRobotUserByUserIdAndRobotId(int userId, int robotId) {
        return robotUserRepository.getRobotUserByUserIdAndRobotId(userId, robotId);
    }

    @Override
    public void removeUserRobots(RobotUser robotUser) {
        robotUserRepository.delete(robotUser);
    }

    @Override
    public void saveUserRobots(RobotUser robotUser) {
        robotUserRepository.save(robotUser);
    }

}
