package org.upmc.obolink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.upmc.obolink.model.Robot;
import org.upmc.obolink.model.Role;

@Repository("robotRepository")
public interface RobotRepository extends JpaRepository<Robot, Integer> {
    Robot findById(int robotId);
}
