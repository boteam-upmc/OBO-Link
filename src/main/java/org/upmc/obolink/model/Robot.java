package org.upmc.obolink.model;

import javax.persistence.*;

@Entity
@Table(name = "robot")
public class Robot {

    @Id
    @Column(name = "robot_id")
    private int id;

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
