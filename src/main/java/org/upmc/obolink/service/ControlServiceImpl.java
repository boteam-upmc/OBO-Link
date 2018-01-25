package org.upmc.obolink.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.upmc.obolink.model.RobotUser;
import org.upmc.obolink.model.User;
import org.upmc.obolink.repository.RobotRepository;
import org.upmc.obolink.repository.RobotUserRepository;

@Service("controlService")
public class ControlServiceImpl implements ControlService {

    private final RobotRepository robotRepository;
    private final RobotUserRepository robotUserRepository;
    @Autowired
    public ControlServiceImpl(@Qualifier("robotRepository") RobotRepository robotRepository,
                              RobotUserRepository robotUserRepository) {
        this.robotRepository = robotRepository;
        this.robotUserRepository = robotUserRepository;
    }

    @Override
    public Boolean checkRobotAndAssociation(int robotId, User user) {
        Boolean check = false;

        if(robotRepository.findById(robotId) != null){
            check = true;
        }
        RobotUser robotUser = robotUserRepository.getRobotUserByUserIdAndRobotId(user.getId(), robotId);
        if(robotUser != null){
            check = true;
        }

        return check;
    }
}
