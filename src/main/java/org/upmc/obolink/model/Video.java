package org.upmc.obolink.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "video")
public class Video {
    @Id
    @Column(name = "video_id")
    private int id;

    @Column(name = "title")
    @NotEmpty
    private String title;

    @Column(name = "date")
    @NotEmpty
    private String date;

    @Column(name = "image_url")
    @NotEmpty
    private String imageURL;

    @Column(name = "video_url")
    @NotEmpty
    private String videoURL;

    @Column(name = "user_id")
    @NotEmpty
    private int userId;

    @Column(name = "robot_id")
    @NotEmpty
    private int robotId;


    @Column(name = "duration")
    @NotEmpty
    private String duration;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user_id) {
        this.userId = user_id;
    }

    public int getRobotId() {
        return robotId;
    }

    public void setRobotId(int robot_id) {
        this.robotId = robot_id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }
}
