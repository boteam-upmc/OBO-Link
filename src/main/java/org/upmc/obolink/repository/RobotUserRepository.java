package org.upmc.obolink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.upmc.obolink.model.Robot;
import org.upmc.obolink.model.RobotUser;

import java.util.List;

@Repository("RobotUserRepository")
public interface RobotUserRepository extends JpaRepository<RobotUser, Integer> {
    List<RobotUser> findByUserId(int userId);
    RobotUser getRobotUserByUserIdAndRobotId(int userId, int robotId);
}
