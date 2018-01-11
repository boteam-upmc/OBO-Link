package org.upmc.obolink.model;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "username")
    @NotEmpty(message = "*Please provide your username.")
    private String username;

    @Column(name = "email")
    @Email(message = "*Please provide a valid email.")
    @NotEmpty(message = "*Please provide an email.")
    private String email;

    @Column(name = "password")
    @Length(min = 8, message = "*Your password must have at least 8 characters.")
    @NotEmpty(message = "*Please provide your password.")
    private String password;

    @Column(name = "first_name")
    @NotEmpty(message = "*Please provide your first name.")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "*Please provide your last name.")
    private String lastName;

    @Column(name = "alpha")
    private int alpha;

    @Column(name = "active")
    private int active;

    @Column(name = "number_of_videos_taken")
    private int numberOfVideosTaken;

    @Column(name = "number_of_videos_deleted")
    private int numberOfVideosDeleted;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    /*
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_robot",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "robot_id"))
    private Set<Robot> robots;
    */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getNumberOfVideosTaken() {
        return numberOfVideosTaken;
    }

    public void setNumberOfVideosTaken(int numberOfVideosTaken) {
        this.numberOfVideosTaken = numberOfVideosTaken;
    }

    public int getNumberOfVideosDeleted() {
        return numberOfVideosDeleted;
    }

    public void setNumberOfVideosDeleted(int numberOfVideosDeleted) {
        this.numberOfVideosDeleted = numberOfVideosDeleted;
    }

    /*
    public Set<Robot> getRobots() {
        return robots;
    }

    public void setRobots(Set<Robot> robots) {
        this.robots = robots;
    }
    */
}
