package org.upmc.obolink.model;

import javax.persistence.*;

/**
 * The bean who represent the role of the user.
 *
 * @author boteam
 * @version 1.0
 */
@Entity
@Table(name = "role")
public class Role {
    /**
     * The id of the role.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;

    /**
     * The name of the role.
     */
    @Column(name = "role")
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
