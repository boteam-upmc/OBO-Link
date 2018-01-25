package org.upmc.obolink.service;


import org.upmc.obolink.model.User;

public interface ControlService {
    Boolean checkRobotAndAssociation(int robotId, User user);
}
