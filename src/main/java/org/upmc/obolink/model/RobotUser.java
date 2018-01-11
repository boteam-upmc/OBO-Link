package org.upmc.obolink.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * The bean who represent the association robot and user.
 *
 * @author boteam
 * @version 1.0
 */
@Entity
@Table(name ="user_robot")
public class RobotUser {

    /**
     * Id of the association.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "assoc_id")
    private int id;

    /**
     * Id of the user.
     * @see User
     */
    @Column(name = "user_id")
    private int userId;

    /**
     * Id of the robot.
     * @see Robot
     */
    @Column(name = "robot_id")
    private int robotId;

    /**
     * If the robot is associated(true) or if it's only a request(false).
     */
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
