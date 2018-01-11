package org.upmc.obolink.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The bean who represent the video.
 *
 * @author boteam
 * @version 1.0
 */
@Entity
@Table(name = "video")
public class Video {
    /**
     * The id of the video.
     */
    @Id
    @Column(name = "video_id")
    private int id;

    /**
     * The title of the video.
     */
    @Column(name = "title")
    @NotEmpty
    private String title;

    /*
    @Column(name = "date")
    @NotEmpty
    private String date;
    */

    /**
     * The url of the image.
     */
    @Column(name = "image_url")
    @NotEmpty
    private String imageURL;

    /**
     * The url of the video.
     */
    @Column(name = "video_url")
    @NotEmpty
    private String videoURL;

    /**
     * The id of the user.
     * @see User
     */
    @Column(name = "user_id")
    @NotEmpty
    private int userId;

    /**
     * The id of the robot.
     * @see Robot
     */
    @Column(name = "robot_id")
    @NotEmpty
    private int robotId;

    /**
     * The duration of the video.
     */
    @Column(name = "duration")
    @NotEmpty
    private String duration;

    /**
     * The date of creation of the video.
     */
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

    /*
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    */

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
