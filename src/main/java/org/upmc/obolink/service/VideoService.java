package org.upmc.obolink.service;

import org.upmc.obolink.model.User;
import org.upmc.obolink.model.Video;

import java.util.List;

/**
 * The interface Service of the video.
 */
public interface VideoService {
    /**
     * Search in the database for all the videos for a user.
     * @param id the id of the user.
     * @return a list of videos for the user.
     */
    List<Video> findByUserId(int id);
    /**
     * Search in the database for a specific video.
     * @param videoID the id of the video.
     * @return the video.
     */
    Video findById(int videoID);
    /**
     * Search in the database for a list of video for a user, a robot, and after a creation date.
     * @param id the user id
     * @param robotId the robot id
     * @return a list of video
     */
    List<Video> findByUserIdAndRobotId(int id, int robotId);

    /**
     * Remove a user from the database.
     * @param video the user
     * @see Video
     */
    void removeVideo(Video video);
}
