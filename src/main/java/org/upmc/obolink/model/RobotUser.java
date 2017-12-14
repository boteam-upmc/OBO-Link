package org.upmc.obolink.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name ="user_robot")
public class RobotUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "assoc_id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "robot_id")
    private int robotId;

    @Column(name = "associated")
    private boolean associated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRobotId() {
        return robotId;
    }

    public void setRobotId(int robotId) {
        this.robotId = robotId;
    }

    public boolean isAssociated() {
        return associated;
    }

    public void setAssociated(boolean associated) {
        this.associated = associated;
    }
}
