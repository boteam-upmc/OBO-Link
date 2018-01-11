package org.upmc.obolink.model;

import javax.persistence.*;

/**
 * The bean who represent the robot.
 *
 * @author boteam
 * @version 1.0
 */
@Entity
@Table(name = "robot")
public class Robot {

    /**
     * The robot id.
     */
    @Id
    @Column(name = "robot_id")
    private int id;

    /**
     * The serial number of the robot.
     */
    @Column(name = "serial_number")
    private String serialNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
