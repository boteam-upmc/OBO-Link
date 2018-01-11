package org.upmc.obolink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.upmc.obolink.model.Video;

import java.sql.Timestamp;
import java.util.List;

/**
 * The interface Repository of the video.
 */
@Repository("videoRepository")
public interface VideoRepository extends JpaRepository<Video, Long> {
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
     * @param date the date of creation
     * @return a list of video
     */
    List<Video> findByUserIdAndRobotIdAndCreationDateIsAfter(int id, int robotId, Timestamp date);
}
